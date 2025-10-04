package com.backend.server.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.backend.server.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.server.model.User;
import com.backend.server.repository.UserRepository;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOp = userRepository.findByUsername(username);

        if (userOp.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        User user = userOp.get();
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(user.getAuthorities())
                .accountLocked(!user.isAccountNonLocked())
                .disabled(!user.isEnabled())
                .build();
    }

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

	public void deleteAllUser() {
		userRepository.deleteByisSuperuserFalse();
	}

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            user.setRoles(Collections.singletonList("ROLE_VIEWER"));
        }
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            if (Utils.isCausedBy(e, DuplicateKeyException.class)) {
                throw new RuntimeException("Username already exists: " + user.getUsername());
            }
            throw e;
        }
    }
    public User updateUser(String id, User updatedUser) {
        User existingUser = getUserById(id);

        if (updatedUser.getUsername() != null)
            existingUser.setUsername(updatedUser.getUsername());

        if (updatedUser.getPassword() != null)
            existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

        if (updatedUser.getRoles() != null && !updatedUser.getRoles().isEmpty())
            existingUser.setRoles(updatedUser.getRoles());

        existingUser.setSuperuser(updatedUser.isSuperuser());

        return userRepository.save(existingUser);
    }

    public User updateRoles(String id, List<String> roles) {
        User user = getUserById(id);
        user.setRoles(roles);
        return userRepository.save(user);
    }

    public void deleteUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (user.isSuperuser()) {
            throw new RuntimeException("Cannot delete a superuser");
        }

        userRepository.deleteById(id);
    }
}

package com.backend.server;

import com.backend.server.config.Scheduler;
import com.backend.server.controller.OrderController;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.connection.ConnectionPoolSettings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
//@EnableScheduling
//@ComponentScan(basePackageClasses = Scheduler.class)
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		final CorsConfiguration configuration = new CorsConfiguration();
//		List<String> origins = new ArrayList<>();
//		origins.add("https://setu-crm.web.app");
//		configuration.setAllowedOrigins(origins);
//		List<String> methods = new ArrayList<>();
//		methods.add("GET");
//		methods.add("POST");
//		methods.add("PUT");
//		methods.add("DELETE");
//		configuration.setAllowedMethods(methods);
//		configuration.setAllowCredentials(true);
//		List<String> headers = new ArrayList<>();
//		headers.add("Authorization");
//		headers.add("Cache-Control");
//		headers.add("Content-Type");
//		configuration.setAllowedHeaders(headers);
//
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//
//		return source;
//	}

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer () {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//						.allowedMethods("*").allowedOrigins("https://setu-crm.web.app");
//			}
//		};
//	}
}



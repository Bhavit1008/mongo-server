package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("architects")
public class Architect {

    @Id
    private String id;

    // ── Identity ─────────────────────────────────────────────────────────
    private String companyName;
    private String type;              // Architecture Firm / Interior Designer / Both
    private String logoUrl;
    private String photoUrl;

    // ── Contact ──────────────────────────────────────────────────────────
    private String contactPerson;
    private String designation;
    private String phone;
    private String whatsapp;
    private String email;

    // ── Address ──────────────────────────────────────────────────────────
    private String officeAddress;
    private String city;
    private String state;
    private String pincode;
    private String mapLink;

    // ── Online presence ──────────────────────────────────────────────────
    private String website;
    private String instagram;
    private String linkedin;

    // ── About ────────────────────────────────────────────────────────────
    private String about;
    private String yearEstablished;
    private String teamSize;
    private String projectType;

    private List<String> specializations;
    private List<String> serviceAreas;
    private List<String> tags;

    // ── CRM tracking ─────────────────────────────────────────────────────
    private String status;            // Research | Not Contacted | Contacted | Visited | Onboarded
    private String priority;          // A | B | C
    private String source;            // Google | Website | Referral | ...
    private String leadOwner;

    private String firstContactDate;
    private String lastContactDate;
    private String onboardedDate;

    private Long createdAt;
    private Long updatedAt;

    public Architect() {}

    public String getId()                          { return id; }
    public void   setId(String id)                 { this.id = id; }

    public String getCompanyName()                 { return companyName; }
    public void   setCompanyName(String companyName) { this.companyName = companyName; }

    public String getType()                        { return type; }
    public void   setType(String type)             { this.type = type; }

    public String getLogoUrl()                     { return logoUrl; }
    public void   setLogoUrl(String logoUrl)       { this.logoUrl = logoUrl; }

    public String getPhotoUrl()                    { return photoUrl; }
    public void   setPhotoUrl(String photoUrl)     { this.photoUrl = photoUrl; }

    public String getContactPerson()                { return contactPerson; }
    public void   setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }

    public String getDesignation()                 { return designation; }
    public void   setDesignation(String designation) { this.designation = designation; }

    public String getPhone()                       { return phone; }
    public void   setPhone(String phone)           { this.phone = phone; }

    public String getWhatsapp()                    { return whatsapp; }
    public void   setWhatsapp(String whatsapp)     { this.whatsapp = whatsapp; }

    public String getEmail()                       { return email; }
    public void   setEmail(String email)           { this.email = email; }

    public String getOfficeAddress()                { return officeAddress; }
    public void   setOfficeAddress(String officeAddress) { this.officeAddress = officeAddress; }

    public String getCity()                        { return city; }
    public void   setCity(String city)             { this.city = city; }

    public String getState()                       { return state; }
    public void   setState(String state)           { this.state = state; }

    public String getPincode()                     { return pincode; }
    public void   setPincode(String pincode)       { this.pincode = pincode; }

    public String getMapLink()                     { return mapLink; }
    public void   setMapLink(String mapLink)       { this.mapLink = mapLink; }

    public String getWebsite()                     { return website; }
    public void   setWebsite(String website)       { this.website = website; }

    public String getInstagram()                   { return instagram; }
    public void   setInstagram(String instagram)   { this.instagram = instagram; }

    public String getLinkedin()                    { return linkedin; }
    public void   setLinkedin(String linkedin)     { this.linkedin = linkedin; }

    public String getAbout()                       { return about; }
    public void   setAbout(String about)           { this.about = about; }

    public String getYearEstablished()              { return yearEstablished; }
    public void   setYearEstablished(String yearEstablished) { this.yearEstablished = yearEstablished; }

    public String getTeamSize()                    { return teamSize; }
    public void   setTeamSize(String teamSize)     { this.teamSize = teamSize; }

    public String getProjectType()                 { return projectType; }
    public void   setProjectType(String projectType) { this.projectType = projectType; }

    public List<String> getSpecializations()        { return specializations; }
    public void   setSpecializations(List<String> specializations) { this.specializations = specializations; }

    public List<String> getServiceAreas()           { return serviceAreas; }
    public void   setServiceAreas(List<String> serviceAreas) { this.serviceAreas = serviceAreas; }

    public List<String> getTags()                   { return tags; }
    public void   setTags(List<String> tags)        { this.tags = tags; }

    public String getStatus()                      { return status; }
    public void   setStatus(String status)         { this.status = status; }

    public String getPriority()                    { return priority; }
    public void   setPriority(String priority)     { this.priority = priority; }

    public String getSource()                      { return source; }
    public void   setSource(String source)         { this.source = source; }

    public String getLeadOwner()                   { return leadOwner; }
    public void   setLeadOwner(String leadOwner)   { this.leadOwner = leadOwner; }

    public String getFirstContactDate()             { return firstContactDate; }
    public void   setFirstContactDate(String firstContactDate) { this.firstContactDate = firstContactDate; }

    public String getLastContactDate()              { return lastContactDate; }
    public void   setLastContactDate(String lastContactDate) { this.lastContactDate = lastContactDate; }

    public String getOnboardedDate()                { return onboardedDate; }
    public void   setOnboardedDate(String onboardedDate) { this.onboardedDate = onboardedDate; }

    public Long getCreatedAt()                      { return createdAt; }
    public void   setCreatedAt(Long createdAt)      { this.createdAt = createdAt; }

    public Long getUpdatedAt()                      { return updatedAt; }
    public void   setUpdatedAt(Long updatedAt)      { this.updatedAt = updatedAt; }
}

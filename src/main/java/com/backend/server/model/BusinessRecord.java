package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("architect_business")
public class BusinessRecord {

    @Id
    private String id;

    private String architectId;
    private String architectName;

    private String enquiryNumber;
    private String projectName;
    private String city;
    private String recordType;    // Enquiry | Quotation | Order
    private String status;        // Under Discussion | Quotation Sent | Won | Lost
    private String date;
    private Double value;

    private Long createdAt;

    public BusinessRecord() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getEnquiryNumber()             { return enquiryNumber; }
    public void   setEnquiryNumber(String enquiryNumber) { this.enquiryNumber = enquiryNumber; }

    public String getProjectName()               { return projectName; }
    public void   setProjectName(String projectName) { this.projectName = projectName; }

    public String getCity()                     { return city; }
    public void   setCity(String city)          { this.city = city; }

    public String getRecordType()                { return recordType; }
    public void   setRecordType(String recordType) { this.recordType = recordType; }

    public String getStatus()                   { return status; }
    public void   setStatus(String status)      { this.status = status; }

    public String getDate()                     { return date; }
    public void   setDate(String date)          { this.date = date; }

    public Double getValue()                    { return value; }
    public void   setValue(Double value)        { this.value = value; }

    public Long getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }
}

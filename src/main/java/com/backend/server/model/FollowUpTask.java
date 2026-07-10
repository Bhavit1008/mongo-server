package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("architect_followups")
public class FollowUpTask {

    @Id
    private String id;

    private String architectId;
    private String architectName;

    private String title;
    private String type;          // Call | Visit | Email | Other
    private String dueDate;       // yyyy-MM-dd
    private String priority;      // High | Medium | Low
    private String status;        // Pending | Completed
    private String notes;

    private Long createdAt;
    private Long completedAt;

    public FollowUpTask() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getTitle()                    { return title; }
    public void   setTitle(String title)        { this.title = title; }

    public String getType()                     { return type; }
    public void   setType(String type)          { this.type = type; }

    public String getDueDate()                  { return dueDate; }
    public void   setDueDate(String dueDate)    { this.dueDate = dueDate; }

    public String getPriority()                 { return priority; }
    public void   setPriority(String priority)  { this.priority = priority; }

    public String getStatus()                   { return status; }
    public void   setStatus(String status)      { this.status = status; }

    public String getNotes()                    { return notes; }
    public void   setNotes(String notes)        { this.notes = notes; }

    public Long getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }

    public Long getCompletedAt()                 { return completedAt; }
    public void   setCompletedAt(Long completedAt) { this.completedAt = completedAt; }
}

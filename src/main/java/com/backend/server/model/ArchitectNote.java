package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("architect_notes")
public class ArchitectNote {

    @Id
    private String id;

    private String architectId;
    private String architectName;
    private String text;

    private Long createdAt;

    public ArchitectNote() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getText()                     { return text; }
    public void   setText(String text)          { this.text = text; }

    public Long getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }
}

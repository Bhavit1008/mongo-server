package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * A logged touchpoint with an architect: a call, meeting, office visit or
 * showroom visit. The "Visit Tracker" page is simply this collection
 * filtered to the two visit types.
 */
@Document("architect_interactions")
public class Interaction {

    @Id
    private String id;

    private String architectId;
    private String architectName;      // denormalized for list display without a join

    private String type;               // Call | Meeting | Office Visit | Showroom Visit
    private String date;               // yyyy-MM-dd
    private String time;               // HH:mm
    private List<String> team;         // our staff present (visits)
    private String notes;

    private Long createdAt;

    public Interaction() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getType()                     { return type; }
    public void   setType(String type)          { this.type = type; }

    public String getDate()                     { return date; }
    public void   setDate(String date)          { this.date = date; }

    public String getTime()                     { return time; }
    public void   setTime(String time)          { this.time = time; }

    public List<String> getTeam()                { return team; }
    public void   setTeam(List<String> team)     { this.team = team; }

    public String getNotes()                    { return notes; }
    public void   setNotes(String notes)        { this.notes = notes; }

    public Long getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }
}

package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("architect_samples")
public class Sample {

    @Id
    private String id;

    private String architectId;
    private String architectName;

    private String materialName;
    private String category;      // Sample | Material  (Samples Given vs Materials Shown)
    private String photoUrl;
    private String piecesCount;
    private String dateGiven;
    private boolean returned;
    private String returnedDate;

    private Long createdAt;

    public Sample() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getMaterialName()              { return materialName; }
    public void   setMaterialName(String materialName) { this.materialName = materialName; }

    public String getCategory()                 { return category; }
    public void   setCategory(String category)  { this.category = category; }

    public String getPhotoUrl()                 { return photoUrl; }
    public void   setPhotoUrl(String photoUrl)  { this.photoUrl = photoUrl; }

    public String getPiecesCount()               { return piecesCount; }
    public void   setPiecesCount(String piecesCount) { this.piecesCount = piecesCount; }

    public String getDateGiven()                { return dateGiven; }
    public void   setDateGiven(String dateGiven) { this.dateGiven = dateGiven; }

    public boolean isReturned()                 { return returned; }
    public void    setReturned(boolean returned) { this.returned = returned; }

    public String getReturnedDate()              { return returnedDate; }
    public void   setReturnedDate(String returnedDate) { this.returnedDate = returnedDate; }

    public Long getCreatedAt()                   { return createdAt; }
    public void   setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }
}

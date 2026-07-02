package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("catalogue")
public class CatalogueItem {

    @Id
    private String id;

    private String itemCode;   // user-supplied ID / product code
    private String origin;
    private String material;
    private String quality;    // quality / colour
    private Long   createdAt;

    public CatalogueItem() {}

    public String getId()                      { return id; }
    public void   setId(String id)             { this.id = id; }

    public String getItemCode()                      { return itemCode; }
    public void   setItemCode(String itemCode)        { this.itemCode = itemCode; }

    public String getOrigin()                  { return origin; }
    public void   setOrigin(String origin)     { this.origin = origin; }

    public String getMaterial()                { return material; }
    public void   setMaterial(String material) { this.material = material; }

    public String getQuality()                 { return quality; }
    public void   setQuality(String quality)   { this.quality = quality; }

    public Long getCreatedAt()                 { return createdAt; }
    public void setCreatedAt(Long createdAt)   { this.createdAt = createdAt; }
}

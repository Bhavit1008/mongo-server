package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** architectId is nullable — company-wide files (price lists, brochures) aren't tied to one architect. */
@Document("architect_documents")
public class ArchitectDocument {

    @Id
    private String id;

    private String architectId;
    private String architectName;

    private String fileName;
    private String fileUrl;
    private String fileType;      // pdf | jpg | png | ...
    private Long fileSizeBytes;
    private String category;      // Company | Project | Quotation | Other

    private Long uploadedAt;

    public ArchitectDocument() {}

    public String getId()                       { return id; }
    public void   setId(String id)              { this.id = id; }

    public String getArchitectId()               { return architectId; }
    public void   setArchitectId(String architectId) { this.architectId = architectId; }

    public String getArchitectName()             { return architectName; }
    public void   setArchitectName(String architectName) { this.architectName = architectName; }

    public String getFileName()                 { return fileName; }
    public void   setFileName(String fileName)  { this.fileName = fileName; }

    public String getFileUrl()                  { return fileUrl; }
    public void   setFileUrl(String fileUrl)    { this.fileUrl = fileUrl; }

    public String getFileType()                 { return fileType; }
    public void   setFileType(String fileType)  { this.fileType = fileType; }

    public Long getFileSizeBytes()               { return fileSizeBytes; }
    public void   setFileSizeBytes(Long fileSizeBytes) { this.fileSizeBytes = fileSizeBytes; }

    public String getCategory()                 { return category; }
    public void   setCategory(String category)  { this.category = category; }

    public Long getUploadedAt()                  { return uploadedAt; }
    public void   setUploadedAt(Long uploadedAt) { this.uploadedAt = uploadedAt; }
}

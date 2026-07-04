package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("catalogue")
public class CatalogueItem {

    @Id
    private String id;

    private Long createdAt;

    // ── 1. Basic Information ──────────────────────────────────────────
    private String itemCode;           // Product Code * (unique stone code)
    private String marbleName;         // Marble Name *
    private String collectionName;
    private String alternateTradeName;
    private String skuCode;
    private String materialType;       // *
    private String stoneFamily;        // *

    // ── 2. Origin Details ──────────────────────────────────────────────
    private String country;            // *
    private String state;
    private String city;
    private String villageRegion;
    private String quarryMineName;
    private String mineOwner;
    private String gpsCoordinates;
    private String elevation;
    private String mineStatus;

    // ── 3. Material Characteristics ─────────────────────────────────────
    private String materialNature;
    private String fragility;
    private String porosity;
    private Double waterAbsorption;
    private Double density;
    private Double specificGravity;
    private Double compressiveStrength;
    private Double flexuralStrength;
    private Double mohsHardness;

    // ── 4. Appearance ────────────────────────────────────────────────────
    private String primaryColor;
    private String secondaryColor;
    private String accentColor;
    private String backgroundTone;
    private String veinColor;
    private String veinPattern;
    private String surfaceTexture;
    private String movement;
    private String transparency;

    // ── 5. Finish Compatibility ──────────────────────────────────────────
    private List<String> finishCompatibility;
    private String finishOthers;

    // ── 6. Applications ───────────────────────────────────────────────────
    private List<String> applications;
    private String applicationsOthers;

    // ── 7. Technical Recommendation ──────────────────────────────────────
    private String bookmatch;
    private String backNetRequired;
    private String resinFillingRequired;
    private String epoxyRequired;
    private String fiberglassRequired;
    private List<String> suitableThickness;
    private String suitableThicknessOther;

    // ── Quality Notes (Common Issues) ────────────────────────────────────
    private List<String> qualityIssues;
    private String otherIssues;

    // ── Commercial Information ───────────────────────────────────────────
    private String availability;
    private String commercialMineStatus;
    private String productionCapacity;
    private String exportAvailability;
    private String approxBlocksPerMonth;
    private String leadTime;

    // ── Maintenance Guide ─────────────────────────────────────────────────
    private String recommendedSealer;
    private String cleaningInstructions;
    private String outdoorRecommendation;
    private String chemicalResistance;
    private String heatResistance;
    private String scratchResistance;

    // ── Sustainability ────────────────────────────────────────────────────
    private String ecoFriendly;
    private String recyclable;
    private String naturalStoneCertification;
    private String sustainabilityNotes;

    // ── Media ─────────────────────────────────────────────────────────────
    private String mainSlabPhotoUrl;
    private String bookmatchPhotoUrl;
    private String blockPhotoUrl;
    private String mineQuarryPhotoUrl;
    private String quarryVideoUrl;
    private String view360Url;

    // ── Marketing Information ────────────────────────────────────────────
    private String shortDescription;
    private String luxuryDescription;
    private String usp;
    private String bestSellingPoints;
    private String keywords;
    private String suitableInteriorStyle;

    // ── Internal Information ─────────────────────────────────────────────
    private String preferredSupplier;
    private String purchaseManager;
    private String supplierContact;
    private String mineContact;
    private String createdBy;
    private String remarks;

    // ── Stone DNA (SETU Exclusive) ────────────────────────────────────────
    private String originMapLocation;
    private String quarryAge;
    private String geologicalFormation;
    private String mineralComposition;
    private String typicalBlockSize;
    private String averageRecoveryPercent;
    private String averageRecoverySqftPerTon;
    private String recommendedFinish;
    private String premiumGrade;
    private String bestMatchingMaterials;
    private String similarStones;
    private String priceCategory;
    private Integer rarityIndex;

    public CatalogueItem() {}

    public String getId()                              { return id; }
    public void   setId(String id)                     { this.id = id; }

    public Long getCreatedAt()                          { return createdAt; }
    public void setCreatedAt(Long createdAt)            { this.createdAt = createdAt; }

    public String getItemCode()                         { return itemCode; }
    public void   setItemCode(String itemCode)          { this.itemCode = itemCode; }

    public String getMarbleName()                       { return marbleName; }
    public void   setMarbleName(String marbleName)      { this.marbleName = marbleName; }

    public String getCollectionName()                   { return collectionName; }
    public void   setCollectionName(String collectionName) { this.collectionName = collectionName; }

    public String getAlternateTradeName()               { return alternateTradeName; }
    public void   setAlternateTradeName(String alternateTradeName) { this.alternateTradeName = alternateTradeName; }

    public String getSkuCode()                          { return skuCode; }
    public void   setSkuCode(String skuCode)            { this.skuCode = skuCode; }

    public String getMaterialType()                     { return materialType; }
    public void   setMaterialType(String materialType)  { this.materialType = materialType; }

    public String getStoneFamily()                      { return stoneFamily; }
    public void   setStoneFamily(String stoneFamily)    { this.stoneFamily = stoneFamily; }

    public String getCountry()                          { return country; }
    public void   setCountry(String country)            { this.country = country; }

    public String getState()                            { return state; }
    public void   setState(String state)                { this.state = state; }

    public String getCity()                             { return city; }
    public void   setCity(String city)                  { this.city = city; }

    public String getVillageRegion()                    { return villageRegion; }
    public void   setVillageRegion(String villageRegion) { this.villageRegion = villageRegion; }

    public String getQuarryMineName()                   { return quarryMineName; }
    public void   setQuarryMineName(String quarryMineName) { this.quarryMineName = quarryMineName; }

    public String getMineOwner()                        { return mineOwner; }
    public void   setMineOwner(String mineOwner)        { this.mineOwner = mineOwner; }

    public String getGpsCoordinates()                   { return gpsCoordinates; }
    public void   setGpsCoordinates(String gpsCoordinates) { this.gpsCoordinates = gpsCoordinates; }

    public String getElevation()                        { return elevation; }
    public void   setElevation(String elevation)        { this.elevation = elevation; }

    public String getMineStatus()                       { return mineStatus; }
    public void   setMineStatus(String mineStatus)      { this.mineStatus = mineStatus; }

    public String getMaterialNature()                   { return materialNature; }
    public void   setMaterialNature(String materialNature) { this.materialNature = materialNature; }

    public String getFragility()                        { return fragility; }
    public void   setFragility(String fragility)        { this.fragility = fragility; }

    public String getPorosity()                         { return porosity; }
    public void   setPorosity(String porosity)          { this.porosity = porosity; }

    public Double getWaterAbsorption()                  { return waterAbsorption; }
    public void   setWaterAbsorption(Double waterAbsorption) { this.waterAbsorption = waterAbsorption; }

    public Double getDensity()                          { return density; }
    public void   setDensity(Double density)            { this.density = density; }

    public Double getSpecificGravity()                  { return specificGravity; }
    public void   setSpecificGravity(Double specificGravity) { this.specificGravity = specificGravity; }

    public Double getCompressiveStrength()              { return compressiveStrength; }
    public void   setCompressiveStrength(Double compressiveStrength) { this.compressiveStrength = compressiveStrength; }

    public Double getFlexuralStrength()                 { return flexuralStrength; }
    public void   setFlexuralStrength(Double flexuralStrength) { this.flexuralStrength = flexuralStrength; }

    public Double getMohsHardness()                     { return mohsHardness; }
    public void   setMohsHardness(Double mohsHardness)  { this.mohsHardness = mohsHardness; }

    public String getPrimaryColor()                     { return primaryColor; }
    public void   setPrimaryColor(String primaryColor)  { this.primaryColor = primaryColor; }

    public String getSecondaryColor()                   { return secondaryColor; }
    public void   setSecondaryColor(String secondaryColor) { this.secondaryColor = secondaryColor; }

    public String getAccentColor()                      { return accentColor; }
    public void   setAccentColor(String accentColor)    { this.accentColor = accentColor; }

    public String getBackgroundTone()                   { return backgroundTone; }
    public void   setBackgroundTone(String backgroundTone) { this.backgroundTone = backgroundTone; }

    public String getVeinColor()                        { return veinColor; }
    public void   setVeinColor(String veinColor)        { this.veinColor = veinColor; }

    public String getVeinPattern()                      { return veinPattern; }
    public void   setVeinPattern(String veinPattern)    { this.veinPattern = veinPattern; }

    public String getSurfaceTexture()                   { return surfaceTexture; }
    public void   setSurfaceTexture(String surfaceTexture) { this.surfaceTexture = surfaceTexture; }

    public String getMovement()                         { return movement; }
    public void   setMovement(String movement)          { this.movement = movement; }

    public String getTransparency()                     { return transparency; }
    public void   setTransparency(String transparency)  { this.transparency = transparency; }

    public List<String> getFinishCompatibility()        { return finishCompatibility; }
    public void   setFinishCompatibility(List<String> finishCompatibility) { this.finishCompatibility = finishCompatibility; }

    public String getFinishOthers()                     { return finishOthers; }
    public void   setFinishOthers(String finishOthers)  { this.finishOthers = finishOthers; }

    public List<String> getApplications()               { return applications; }
    public void   setApplications(List<String> applications) { this.applications = applications; }

    public String getApplicationsOthers()               { return applicationsOthers; }
    public void   setApplicationsOthers(String applicationsOthers) { this.applicationsOthers = applicationsOthers; }

    public String getBookmatch()                        { return bookmatch; }
    public void   setBookmatch(String bookmatch)        { this.bookmatch = bookmatch; }

    public String getBackNetRequired()                  { return backNetRequired; }
    public void   setBackNetRequired(String backNetRequired) { this.backNetRequired = backNetRequired; }

    public String getResinFillingRequired()             { return resinFillingRequired; }
    public void   setResinFillingRequired(String resinFillingRequired) { this.resinFillingRequired = resinFillingRequired; }

    public String getEpoxyRequired()                    { return epoxyRequired; }
    public void   setEpoxyRequired(String epoxyRequired) { this.epoxyRequired = epoxyRequired; }

    public String getFiberglassRequired()               { return fiberglassRequired; }
    public void   setFiberglassRequired(String fiberglassRequired) { this.fiberglassRequired = fiberglassRequired; }

    public List<String> getSuitableThickness()          { return suitableThickness; }
    public void   setSuitableThickness(List<String> suitableThickness) { this.suitableThickness = suitableThickness; }

    public String getSuitableThicknessOther()           { return suitableThicknessOther; }
    public void   setSuitableThicknessOther(String suitableThicknessOther) { this.suitableThicknessOther = suitableThicknessOther; }

    public List<String> getQualityIssues()              { return qualityIssues; }
    public void   setQualityIssues(List<String> qualityIssues) { this.qualityIssues = qualityIssues; }

    public String getOtherIssues()                      { return otherIssues; }
    public void   setOtherIssues(String otherIssues)    { this.otherIssues = otherIssues; }

    public String getAvailability()                     { return availability; }
    public void   setAvailability(String availability)  { this.availability = availability; }

    public String getCommercialMineStatus()             { return commercialMineStatus; }
    public void   setCommercialMineStatus(String commercialMineStatus) { this.commercialMineStatus = commercialMineStatus; }

    public String getProductionCapacity()               { return productionCapacity; }
    public void   setProductionCapacity(String productionCapacity) { this.productionCapacity = productionCapacity; }

    public String getExportAvailability()               { return exportAvailability; }
    public void   setExportAvailability(String exportAvailability) { this.exportAvailability = exportAvailability; }

    public String getApproxBlocksPerMonth()             { return approxBlocksPerMonth; }
    public void   setApproxBlocksPerMonth(String approxBlocksPerMonth) { this.approxBlocksPerMonth = approxBlocksPerMonth; }

    public String getLeadTime()                         { return leadTime; }
    public void   setLeadTime(String leadTime)          { this.leadTime = leadTime; }

    public String getRecommendedSealer()                { return recommendedSealer; }
    public void   setRecommendedSealer(String recommendedSealer) { this.recommendedSealer = recommendedSealer; }

    public String getCleaningInstructions()             { return cleaningInstructions; }
    public void   setCleaningInstructions(String cleaningInstructions) { this.cleaningInstructions = cleaningInstructions; }

    public String getOutdoorRecommendation()            { return outdoorRecommendation; }
    public void   setOutdoorRecommendation(String outdoorRecommendation) { this.outdoorRecommendation = outdoorRecommendation; }

    public String getChemicalResistance()               { return chemicalResistance; }
    public void   setChemicalResistance(String chemicalResistance) { this.chemicalResistance = chemicalResistance; }

    public String getHeatResistance()                   { return heatResistance; }
    public void   setHeatResistance(String heatResistance) { this.heatResistance = heatResistance; }

    public String getScratchResistance()                { return scratchResistance; }
    public void   setScratchResistance(String scratchResistance) { this.scratchResistance = scratchResistance; }

    public String getEcoFriendly()                      { return ecoFriendly; }
    public void   setEcoFriendly(String ecoFriendly)    { this.ecoFriendly = ecoFriendly; }

    public String getRecyclable()                       { return recyclable; }
    public void   setRecyclable(String recyclable)      { this.recyclable = recyclable; }

    public String getNaturalStoneCertification()        { return naturalStoneCertification; }
    public void   setNaturalStoneCertification(String naturalStoneCertification) { this.naturalStoneCertification = naturalStoneCertification; }

    public String getSustainabilityNotes()              { return sustainabilityNotes; }
    public void   setSustainabilityNotes(String sustainabilityNotes) { this.sustainabilityNotes = sustainabilityNotes; }

    public String getMainSlabPhotoUrl()                 { return mainSlabPhotoUrl; }
    public void   setMainSlabPhotoUrl(String mainSlabPhotoUrl) { this.mainSlabPhotoUrl = mainSlabPhotoUrl; }

    public String getBookmatchPhotoUrl()                { return bookmatchPhotoUrl; }
    public void   setBookmatchPhotoUrl(String bookmatchPhotoUrl) { this.bookmatchPhotoUrl = bookmatchPhotoUrl; }

    public String getBlockPhotoUrl()                    { return blockPhotoUrl; }
    public void   setBlockPhotoUrl(String blockPhotoUrl) { this.blockPhotoUrl = blockPhotoUrl; }

    public String getMineQuarryPhotoUrl()               { return mineQuarryPhotoUrl; }
    public void   setMineQuarryPhotoUrl(String mineQuarryPhotoUrl) { this.mineQuarryPhotoUrl = mineQuarryPhotoUrl; }

    public String getQuarryVideoUrl()                   { return quarryVideoUrl; }
    public void   setQuarryVideoUrl(String quarryVideoUrl) { this.quarryVideoUrl = quarryVideoUrl; }

    public String getView360Url()                       { return view360Url; }
    public void   setView360Url(String view360Url)      { this.view360Url = view360Url; }

    public String getShortDescription()                 { return shortDescription; }
    public void   setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    public String getLuxuryDescription()                { return luxuryDescription; }
    public void   setLuxuryDescription(String luxuryDescription) { this.luxuryDescription = luxuryDescription; }

    public String getUsp()                              { return usp; }
    public void   setUsp(String usp)                    { this.usp = usp; }

    public String getBestSellingPoints()                { return bestSellingPoints; }
    public void   setBestSellingPoints(String bestSellingPoints) { this.bestSellingPoints = bestSellingPoints; }

    public String getKeywords()                         { return keywords; }
    public void   setKeywords(String keywords)          { this.keywords = keywords; }

    public String getSuitableInteriorStyle()            { return suitableInteriorStyle; }
    public void   setSuitableInteriorStyle(String suitableInteriorStyle) { this.suitableInteriorStyle = suitableInteriorStyle; }

    public String getPreferredSupplier()                { return preferredSupplier; }
    public void   setPreferredSupplier(String preferredSupplier) { this.preferredSupplier = preferredSupplier; }

    public String getPurchaseManager()                  { return purchaseManager; }
    public void   setPurchaseManager(String purchaseManager) { this.purchaseManager = purchaseManager; }

    public String getSupplierContact()                  { return supplierContact; }
    public void   setSupplierContact(String supplierContact) { this.supplierContact = supplierContact; }

    public String getMineContact()                      { return mineContact; }
    public void   setMineContact(String mineContact)    { this.mineContact = mineContact; }

    public String getCreatedBy()                        { return createdBy; }
    public void   setCreatedBy(String createdBy)        { this.createdBy = createdBy; }

    public String getRemarks()                          { return remarks; }
    public void   setRemarks(String remarks)            { this.remarks = remarks; }

    public String getOriginMapLocation()                { return originMapLocation; }
    public void   setOriginMapLocation(String originMapLocation) { this.originMapLocation = originMapLocation; }

    public String getQuarryAge()                        { return quarryAge; }
    public void   setQuarryAge(String quarryAge)        { this.quarryAge = quarryAge; }

    public String getGeologicalFormation()              { return geologicalFormation; }
    public void   setGeologicalFormation(String geologicalFormation) { this.geologicalFormation = geologicalFormation; }

    public String getMineralComposition()               { return mineralComposition; }
    public void   setMineralComposition(String mineralComposition) { this.mineralComposition = mineralComposition; }

    public String getTypicalBlockSize()                 { return typicalBlockSize; }
    public void   setTypicalBlockSize(String typicalBlockSize) { this.typicalBlockSize = typicalBlockSize; }

    public String getAverageRecoveryPercent()           { return averageRecoveryPercent; }
    public void   setAverageRecoveryPercent(String averageRecoveryPercent) { this.averageRecoveryPercent = averageRecoveryPercent; }

    public String getAverageRecoverySqftPerTon()        { return averageRecoverySqftPerTon; }
    public void   setAverageRecoverySqftPerTon(String averageRecoverySqftPerTon) { this.averageRecoverySqftPerTon = averageRecoverySqftPerTon; }

    public String getRecommendedFinish()                { return recommendedFinish; }
    public void   setRecommendedFinish(String recommendedFinish) { this.recommendedFinish = recommendedFinish; }

    public String getPremiumGrade()                     { return premiumGrade; }
    public void   setPremiumGrade(String premiumGrade)  { this.premiumGrade = premiumGrade; }

    public String getBestMatchingMaterials()            { return bestMatchingMaterials; }
    public void   setBestMatchingMaterials(String bestMatchingMaterials) { this.bestMatchingMaterials = bestMatchingMaterials; }

    public String getSimilarStones()                    { return similarStones; }
    public void   setSimilarStones(String similarStones) { this.similarStones = similarStones; }

    public String getPriceCategory()                    { return priceCategory; }
    public void   setPriceCategory(String priceCategory) { this.priceCategory = priceCategory; }

    public Integer getRarityIndex()                     { return rarityIndex; }
    public void    setRarityIndex(Integer rarityIndex)  { this.rarityIndex = rarityIndex; }
}

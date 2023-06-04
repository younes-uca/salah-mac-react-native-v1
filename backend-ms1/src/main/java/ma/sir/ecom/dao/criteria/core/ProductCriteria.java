package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProductCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private String libelle;
    private String libelleLike;
    private String barcode;
    private String barcodeLike;
    private String description;
    private String descriptionLike;
    private String averagePurchasePrice;
    private String averagePurchasePriceMin;
    private String averagePurchasePriceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String alertThreshold;
    private String alertThresholdMin;
    private String alertThresholdMax;
    private String productPhotos;
    private String productPhotosLike;

    private ProductCategoryCriteria productCategory ;
    private List<ProductCategoryCriteria> productCategorys ;
    private MeasurementUnitCriteria measurementUnit ;
    private List<MeasurementUnitCriteria> measurementUnits ;
    private BrandCriteria brand ;
    private List<BrandCriteria> brands ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;


    public ProductCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getBarcodeLike(){
        return this.barcodeLike;
    }
    public void setBarcodeLike(String barcodeLike){
        this.barcodeLike = barcodeLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getAveragePurchasePrice(){
        return this.averagePurchasePrice;
    }
    public void setAveragePurchasePrice(String averagePurchasePrice){
        this.averagePurchasePrice = averagePurchasePrice;
    }   
    public String getAveragePurchasePriceMin(){
        return this.averagePurchasePriceMin;
    }
    public void setAveragePurchasePriceMin(String averagePurchasePriceMin){
        this.averagePurchasePriceMin = averagePurchasePriceMin;
    }
    public String getAveragePurchasePriceMax(){
        return this.averagePurchasePriceMax;
    }
    public void setAveragePurchasePriceMax(String averagePurchasePriceMax){
        this.averagePurchasePriceMax = averagePurchasePriceMax;
    }
      
    public String getQuantity(){
        return this.quantity;
    }
    public void setQuantity(String quantity){
        this.quantity = quantity;
    }   
    public String getQuantityMin(){
        return this.quantityMin;
    }
    public void setQuantityMin(String quantityMin){
        this.quantityMin = quantityMin;
    }
    public String getQuantityMax(){
        return this.quantityMax;
    }
    public void setQuantityMax(String quantityMax){
        this.quantityMax = quantityMax;
    }
      
    public String getAlertThreshold(){
        return this.alertThreshold;
    }
    public void setAlertThreshold(String alertThreshold){
        this.alertThreshold = alertThreshold;
    }   
    public String getAlertThresholdMin(){
        return this.alertThresholdMin;
    }
    public void setAlertThresholdMin(String alertThresholdMin){
        this.alertThresholdMin = alertThresholdMin;
    }
    public String getAlertThresholdMax(){
        return this.alertThresholdMax;
    }
    public void setAlertThresholdMax(String alertThresholdMax){
        this.alertThresholdMax = alertThresholdMax;
    }
      
    public String getProductPhotos(){
        return this.productPhotos;
    }
    public void setProductPhotos(String productPhotos){
        this.productPhotos = productPhotos;
    }
    public String getProductPhotosLike(){
        return this.productPhotosLike;
    }
    public void setProductPhotosLike(String productPhotosLike){
        this.productPhotosLike = productPhotosLike;
    }


    public ProductCategoryCriteria getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategoryCriteria productCategory){
        this.productCategory = productCategory;
    }
    public List<ProductCategoryCriteria> getProductCategorys(){
        return this.productCategorys;
    }

    public void setProductCategorys(List<ProductCategoryCriteria> productCategorys){
        this.productCategorys = productCategorys;
    }
    public MeasurementUnitCriteria getMeasurementUnit(){
        return this.measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnitCriteria measurementUnit){
        this.measurementUnit = measurementUnit;
    }
    public List<MeasurementUnitCriteria> getMeasurementUnits(){
        return this.measurementUnits;
    }

    public void setMeasurementUnits(List<MeasurementUnitCriteria> measurementUnits){
        this.measurementUnits = measurementUnits;
    }
    public BrandCriteria getBrand(){
        return this.brand;
    }

    public void setBrand(BrandCriteria brand){
        this.brand = brand;
    }
    public List<BrandCriteria> getBrands(){
        return this.brands;
    }

    public void setBrands(List<BrandCriteria> brands){
        this.brands = brands;
    }
    public StoreCriteria getStore(){
        return this.store;
    }

    public void setStore(StoreCriteria store){
        this.store = store;
    }
    public List<StoreCriteria> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreCriteria> stores){
        this.stores = stores;
    }
}

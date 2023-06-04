package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto  extends AuditBaseDto {

    private String reference  ;
    private String libelle  ;
    private String barcode  ;
    private String description  ;
    private BigDecimal averagePurchasePrice  ;
    private BigDecimal quantity  ;
    private BigDecimal alertThreshold  ;
    private String productPhotos  ;

    private ProductCategoryDto productCategory ;
    private MeasurementUnitDto measurementUnit ;
    private BrandDto brand ;
    private StoreDto store ;



    public ProductDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public BigDecimal getAveragePurchasePrice(){
        return this.averagePurchasePrice;
    }
    public void setAveragePurchasePrice(BigDecimal averagePurchasePrice){
        this.averagePurchasePrice = averagePurchasePrice;
    }

    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    @Log
    public BigDecimal getAlertThreshold(){
        return this.alertThreshold;
    }
    public void setAlertThreshold(BigDecimal alertThreshold){
        this.alertThreshold = alertThreshold;
    }

    @Log
    public String getProductPhotos(){
        return this.productPhotos;
    }
    public void setProductPhotos(String productPhotos){
        this.productPhotos = productPhotos;
    }


    public ProductCategoryDto getProductCategory(){
        return this.productCategory;
    }

    public void setProductCategory(ProductCategoryDto productCategory){
        this.productCategory = productCategory;
    }
    public MeasurementUnitDto getMeasurementUnit(){
        return this.measurementUnit;
    }

    public void setMeasurementUnit(MeasurementUnitDto measurementUnit){
        this.measurementUnit = measurementUnit;
    }
    public BrandDto getBrand(){
        return this.brand;
    }

    public void setBrand(BrandDto brand){
        this.brand = brand;
    }
    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }




}

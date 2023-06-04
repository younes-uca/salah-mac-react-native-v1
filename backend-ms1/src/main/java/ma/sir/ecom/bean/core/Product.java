package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "product")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_seq",sequenceName="product_seq",allocationSize=1, initialValue = 1)
public class Product   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    @Column(length = 500)
    private String libelle;
    @Column(length = 500)
    private String barcode;
    @Column(length = 500)
    private String description;
    private BigDecimal averagePurchasePrice = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal alertThreshold = BigDecimal.ZERO;
    @Column(length = 500)
    private String productPhotos;

    private ProductCategory productCategory ;
    
    private MeasurementUnit measurementUnit ;
    
    private Brand brand ;
    
    private Store store ;
    


    public Product(){
        super();
    }

    public Product(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="product_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ProductCategory getProductCategory(){
        return this.productCategory;
    }
    public void setProductCategory(ProductCategory productCategory){
        this.productCategory = productCategory;
    }
    public String getBarcode(){
        return this.barcode;
    }
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public BigDecimal getAveragePurchasePrice(){
        return this.averagePurchasePrice;
    }
    public void setAveragePurchasePrice(BigDecimal averagePurchasePrice){
        this.averagePurchasePrice = averagePurchasePrice;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    public BigDecimal getAlertThreshold(){
        return this.alertThreshold;
    }
    public void setAlertThreshold(BigDecimal alertThreshold){
        this.alertThreshold = alertThreshold;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public MeasurementUnit getMeasurementUnit(){
        return this.measurementUnit;
    }
    public void setMeasurementUnit(MeasurementUnit measurementUnit){
        this.measurementUnit = measurementUnit;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Brand getBrand(){
        return this.brand;
    }
    public void setBrand(Brand brand){
        this.brand = brand;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public String getProductPhotos(){
        return this.productPhotos;
    }
    public void setProductPhotos(String productPhotos){
        this.productPhotos = productPhotos;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id != null && id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


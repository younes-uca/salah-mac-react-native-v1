package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PurchaseCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime purchaseDate;
    private LocalDateTime purchaseDateFrom;
    private LocalDateTime purchaseDateTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaid;
    private String totalPaidMin;
    private String totalPaidMax;
    private String description;
    private String descriptionLike;

    private SupplierCriteria supplier ;
    private List<SupplierCriteria> suppliers ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private PurchaseStatusCriteria purchaseStatus ;
    private List<PurchaseStatusCriteria> purchaseStatuss ;


    public PurchaseCriteria(){}

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

    public LocalDateTime getPurchaseDate(){
        return this.purchaseDate;
    }
    public void setPurchaseDate(LocalDateTime purchaseDate){
        this.purchaseDate = purchaseDate;
    }
    public LocalDateTime getPurchaseDateFrom(){
        return this.purchaseDateFrom;
    }
    public void setPurchaseDateFrom(LocalDateTime purchaseDateFrom){
        this.purchaseDateFrom = purchaseDateFrom;
    }
    public LocalDateTime getPurchaseDateTo(){
        return this.purchaseDateTo;
    }
    public void setPurchaseDateTo(LocalDateTime purchaseDateTo){
        this.purchaseDateTo = purchaseDateTo;
    }
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(String totalPaid){
        this.totalPaid = totalPaid;
    }   
    public String getTotalPaidMin(){
        return this.totalPaidMin;
    }
    public void setTotalPaidMin(String totalPaidMin){
        this.totalPaidMin = totalPaidMin;
    }
    public String getTotalPaidMax(){
        return this.totalPaidMax;
    }
    public void setTotalPaidMax(String totalPaidMax){
        this.totalPaidMax = totalPaidMax;
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


    public SupplierCriteria getSupplier(){
        return this.supplier;
    }

    public void setSupplier(SupplierCriteria supplier){
        this.supplier = supplier;
    }
    public List<SupplierCriteria> getSuppliers(){
        return this.suppliers;
    }

    public void setSuppliers(List<SupplierCriteria> suppliers){
        this.suppliers = suppliers;
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
    public PurchaseStatusCriteria getPurchaseStatus(){
        return this.purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatusCriteria purchaseStatus){
        this.purchaseStatus = purchaseStatus;
    }
    public List<PurchaseStatusCriteria> getPurchaseStatuss(){
        return this.purchaseStatuss;
    }

    public void setPurchaseStatuss(List<PurchaseStatusCriteria> purchaseStatuss){
        this.purchaseStatuss = purchaseStatuss;
    }
}

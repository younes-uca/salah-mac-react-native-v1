package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SupplierQuoteCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime quoteDate;
    private LocalDateTime quoteDateFrom;
    private LocalDateTime quoteDateTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String description;
    private String descriptionLike;

    private SupplierCriteria supplier ;
    private List<SupplierCriteria> suppliers ;


    public SupplierQuoteCriteria(){}

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

    public LocalDateTime getQuoteDate(){
        return this.quoteDate;
    }
    public void setQuoteDate(LocalDateTime quoteDate){
        this.quoteDate = quoteDate;
    }
    public LocalDateTime getQuoteDateFrom(){
        return this.quoteDateFrom;
    }
    public void setQuoteDateFrom(LocalDateTime quoteDateFrom){
        this.quoteDateFrom = quoteDateFrom;
    }
    public LocalDateTime getQuoteDateTo(){
        return this.quoteDateTo;
    }
    public void setQuoteDateTo(LocalDateTime quoteDateTo){
        this.quoteDateTo = quoteDateTo;
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
}

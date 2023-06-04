package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SupplierQuoteItemCriteria extends  BaseCriteria  {

    private String unitPrice;
    private String unitPriceMin;
    private String unitPriceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String discount;
    private String discountMin;
    private String discountMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private SupplierQuoteCriteria supplierQuote ;
    private List<SupplierQuoteCriteria> supplierQuotes ;


    public SupplierQuoteItemCriteria(){}

    public String getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(String unitPrice){
        this.unitPrice = unitPrice;
    }   
    public String getUnitPriceMin(){
        return this.unitPriceMin;
    }
    public void setUnitPriceMin(String unitPriceMin){
        this.unitPriceMin = unitPriceMin;
    }
    public String getUnitPriceMax(){
        return this.unitPriceMax;
    }
    public void setUnitPriceMax(String unitPriceMax){
        this.unitPriceMax = unitPriceMax;
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
      
    public String getDiscount(){
        return this.discount;
    }
    public void setDiscount(String discount){
        this.discount = discount;
    }   
    public String getDiscountMin(){
        return this.discountMin;
    }
    public void setDiscountMin(String discountMin){
        this.discountMin = discountMin;
    }
    public String getDiscountMax(){
        return this.discountMax;
    }
    public void setDiscountMax(String discountMax){
        this.discountMax = discountMax;
    }
      

    public ProductCriteria getProduct(){
        return this.product;
    }

    public void setProduct(ProductCriteria product){
        this.product = product;
    }
    public List<ProductCriteria> getProducts(){
        return this.products;
    }

    public void setProducts(List<ProductCriteria> products){
        this.products = products;
    }
    public SupplierQuoteCriteria getSupplierQuote(){
        return this.supplierQuote;
    }

    public void setSupplierQuote(SupplierQuoteCriteria supplierQuote){
        this.supplierQuote = supplierQuote;
    }
    public List<SupplierQuoteCriteria> getSupplierQuotes(){
        return this.supplierQuotes;
    }

    public void setSupplierQuotes(List<SupplierQuoteCriteria> supplierQuotes){
        this.supplierQuotes = supplierQuotes;
    }
}

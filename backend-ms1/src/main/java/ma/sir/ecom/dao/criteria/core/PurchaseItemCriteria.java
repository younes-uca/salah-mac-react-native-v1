package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class PurchaseItemCriteria extends  BaseCriteria  {

    private String unitPrice;
    private String unitPriceMin;
    private String unitPriceMax;
    private String sellingPrice;
    private String sellingPriceMin;
    private String sellingPriceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String returnQuantity;
    private String returnQuantityMin;
    private String returnQuantityMax;
    private String discount;
    private String discountMin;
    private String discountMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private PurchaseCriteria purchase ;
    private List<PurchaseCriteria> purchases ;


    public PurchaseItemCriteria(){}

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
      
    public String getSellingPrice(){
        return this.sellingPrice;
    }
    public void setSellingPrice(String sellingPrice){
        this.sellingPrice = sellingPrice;
    }   
    public String getSellingPriceMin(){
        return this.sellingPriceMin;
    }
    public void setSellingPriceMin(String sellingPriceMin){
        this.sellingPriceMin = sellingPriceMin;
    }
    public String getSellingPriceMax(){
        return this.sellingPriceMax;
    }
    public void setSellingPriceMax(String sellingPriceMax){
        this.sellingPriceMax = sellingPriceMax;
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
      
    public String getReturnQuantity(){
        return this.returnQuantity;
    }
    public void setReturnQuantity(String returnQuantity){
        this.returnQuantity = returnQuantity;
    }   
    public String getReturnQuantityMin(){
        return this.returnQuantityMin;
    }
    public void setReturnQuantityMin(String returnQuantityMin){
        this.returnQuantityMin = returnQuantityMin;
    }
    public String getReturnQuantityMax(){
        return this.returnQuantityMax;
    }
    public void setReturnQuantityMax(String returnQuantityMax){
        this.returnQuantityMax = returnQuantityMax;
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
    public PurchaseCriteria getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseCriteria purchase){
        this.purchase = purchase;
    }
    public List<PurchaseCriteria> getPurchases(){
        return this.purchases;
    }

    public void setPurchases(List<PurchaseCriteria> purchases){
        this.purchases = purchases;
    }
}

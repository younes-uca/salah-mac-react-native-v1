package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SaleItemCriteria extends  BaseCriteria  {

    private String unitPrice;
    private String unitPriceMin;
    private String unitPriceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String discount;
    private String discountMin;
    private String discountMax;
    private String quantityReturned;
    private String quantityReturnedMin;
    private String quantityReturnedMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private SaleCriteria sale ;
    private List<SaleCriteria> sales ;


    public SaleItemCriteria(){}

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
      
    public String getQuantityReturned(){
        return this.quantityReturned;
    }
    public void setQuantityReturned(String quantityReturned){
        this.quantityReturned = quantityReturned;
    }   
    public String getQuantityReturnedMin(){
        return this.quantityReturnedMin;
    }
    public void setQuantityReturnedMin(String quantityReturnedMin){
        this.quantityReturnedMin = quantityReturnedMin;
    }
    public String getQuantityReturnedMax(){
        return this.quantityReturnedMax;
    }
    public void setQuantityReturnedMax(String quantityReturnedMax){
        this.quantityReturnedMax = quantityReturnedMax;
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
    public SaleCriteria getSale(){
        return this.sale;
    }

    public void setSale(SaleCriteria sale){
        this.sale = sale;
    }
    public List<SaleCriteria> getSales(){
        return this.sales;
    }

    public void setSales(List<SaleCriteria> sales){
        this.sales = sales;
    }
}

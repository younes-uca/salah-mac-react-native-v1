package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DemandItemCriteria extends  BaseCriteria  {

    private String price;
    private String priceMin;
    private String priceMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String poundQuantity;
    private String poundQuantityMin;
    private String poundQuantityMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private DemandCriteria demand ;
    private List<DemandCriteria> demands ;


    public DemandItemCriteria(){}

    public String getPrice(){
        return this.price;
    }
    public void setPrice(String price){
        this.price = price;
    }   
    public String getPriceMin(){
        return this.priceMin;
    }
    public void setPriceMin(String priceMin){
        this.priceMin = priceMin;
    }
    public String getPriceMax(){
        return this.priceMax;
    }
    public void setPriceMax(String priceMax){
        this.priceMax = priceMax;
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
      
    public String getPoundQuantity(){
        return this.poundQuantity;
    }
    public void setPoundQuantity(String poundQuantity){
        this.poundQuantity = poundQuantity;
    }   
    public String getPoundQuantityMin(){
        return this.poundQuantityMin;
    }
    public void setPoundQuantityMin(String poundQuantityMin){
        this.poundQuantityMin = poundQuantityMin;
    }
    public String getPoundQuantityMax(){
        return this.poundQuantityMax;
    }
    public void setPoundQuantityMax(String poundQuantityMax){
        this.poundQuantityMax = poundQuantityMax;
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
    public DemandCriteria getDemand(){
        return this.demand;
    }

    public void setDemand(DemandCriteria demand){
        this.demand = demand;
    }
    public List<DemandCriteria> getDemands(){
        return this.demands;
    }

    public void setDemands(List<DemandCriteria> demands){
        this.demands = demands;
    }
}

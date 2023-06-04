package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ProductStockCriteria extends  BaseCriteria  {

    private String quantity;
    private String quantityMin;
    private String quantityMax;
    private String defectiveQuantity;
    private String defectiveQuantityMin;
    private String defectiveQuantityMax;

    private ShopCriteria shop ;
    private List<ShopCriteria> shops ;
    private ProductCriteria product ;
    private List<ProductCriteria> products ;


    public ProductStockCriteria(){}

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
      
    public String getDefectiveQuantity(){
        return this.defectiveQuantity;
    }
    public void setDefectiveQuantity(String defectiveQuantity){
        this.defectiveQuantity = defectiveQuantity;
    }   
    public String getDefectiveQuantityMin(){
        return this.defectiveQuantityMin;
    }
    public void setDefectiveQuantityMin(String defectiveQuantityMin){
        this.defectiveQuantityMin = defectiveQuantityMin;
    }
    public String getDefectiveQuantityMax(){
        return this.defectiveQuantityMax;
    }
    public void setDefectiveQuantityMax(String defectiveQuantityMax){
        this.defectiveQuantityMax = defectiveQuantityMax;
    }
      

    public ShopCriteria getShop(){
        return this.shop;
    }

    public void setShop(ShopCriteria shop){
        this.shop = shop;
    }
    public List<ShopCriteria> getShops(){
        return this.shops;
    }

    public void setShops(List<ShopCriteria> shops){
        this.shops = shops;
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
}

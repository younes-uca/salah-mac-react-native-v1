package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class ReturnSaleItemCriteria extends  BaseCriteria  {

    private String returnAmount;
    private String returnAmountMin;
    private String returnAmountMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private ReturnSaleCriteria returnSale ;
    private List<ReturnSaleCriteria> returnSales ;


    public ReturnSaleItemCriteria(){}

    public String getReturnAmount(){
        return this.returnAmount;
    }
    public void setReturnAmount(String returnAmount){
        this.returnAmount = returnAmount;
    }   
    public String getReturnAmountMin(){
        return this.returnAmountMin;
    }
    public void setReturnAmountMin(String returnAmountMin){
        this.returnAmountMin = returnAmountMin;
    }
    public String getReturnAmountMax(){
        return this.returnAmountMax;
    }
    public void setReturnAmountMax(String returnAmountMax){
        this.returnAmountMax = returnAmountMax;
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
    public ReturnSaleCriteria getReturnSale(){
        return this.returnSale;
    }

    public void setReturnSale(ReturnSaleCriteria returnSale){
        this.returnSale = returnSale;
    }
    public List<ReturnSaleCriteria> getReturnSales(){
        return this.returnSales;
    }

    public void setReturnSales(List<ReturnSaleCriteria> returnSales){
        this.returnSales = returnSales;
    }
}

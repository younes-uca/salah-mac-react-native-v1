package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CreditNotePurchaseItemCriteria extends  BaseCriteria  {

    private String amount;
    private String amountMin;
    private String amountMax;
    private String quantity;
    private String quantityMin;
    private String quantityMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private CreditNotePurchaseCriteria creditNotePurchase ;
    private List<CreditNotePurchaseCriteria> creditNotePurchases ;


    public CreditNotePurchaseItemCriteria(){}

    public String getAmount(){
        return this.amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }   
    public String getAmountMin(){
        return this.amountMin;
    }
    public void setAmountMin(String amountMin){
        this.amountMin = amountMin;
    }
    public String getAmountMax(){
        return this.amountMax;
    }
    public void setAmountMax(String amountMax){
        this.amountMax = amountMax;
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
    public CreditNotePurchaseCriteria getCreditNotePurchase(){
        return this.creditNotePurchase;
    }

    public void setCreditNotePurchase(CreditNotePurchaseCriteria creditNotePurchase){
        this.creditNotePurchase = creditNotePurchase;
    }
    public List<CreditNotePurchaseCriteria> getCreditNotePurchases(){
        return this.creditNotePurchases;
    }

    public void setCreditNotePurchases(List<CreditNotePurchaseCriteria> creditNotePurchases){
        this.creditNotePurchases = creditNotePurchases;
    }
}

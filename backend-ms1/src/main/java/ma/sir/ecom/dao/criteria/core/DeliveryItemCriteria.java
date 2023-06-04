package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class DeliveryItemCriteria extends  BaseCriteria  {

    private String quantity;
    private String quantityMin;
    private String quantityMax;

    private ProductCriteria product ;
    private List<ProductCriteria> products ;
    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private DeliveryCriteria delivery ;
    private List<DeliveryCriteria> deliverys ;


    public DeliveryItemCriteria(){}

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
    public DeliveryCriteria getDelivery(){
        return this.delivery;
    }

    public void setDelivery(DeliveryCriteria delivery){
        this.delivery = delivery;
    }
    public List<DeliveryCriteria> getDeliverys(){
        return this.deliverys;
    }

    public void setDeliverys(List<DeliveryCriteria> deliverys){
        this.deliverys = deliverys;
    }
}

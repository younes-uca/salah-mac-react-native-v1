package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryItemDto  extends AuditBaseDto {

    private BigDecimal quantity  ;

    private ProductDto product ;
    private StoreDto store ;
    private DeliveryDto delivery ;



    public DeliveryItemDto(){
        super();
    }



    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }
    public DeliveryDto getDelivery(){
        return this.delivery;
    }

    public void setDelivery(DeliveryDto delivery){
        this.delivery = delivery;
    }




}

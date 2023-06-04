package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderItemDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal quantity  ;
    private BigDecimal quantityReceived  ;

    private ProductDto product ;
    private OrderDto order ;



    public OrderItemDto(){
        super();
    }



    @Log
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }

    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    @Log
    public BigDecimal getQuantityReceived(){
        return this.quantityReceived;
    }
    public void setQuantityReceived(BigDecimal quantityReceived){
        this.quantityReceived = quantityReceived;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public OrderDto getOrder(){
        return this.order;
    }

    public void setOrder(OrderDto order){
        this.order = order;
    }




}

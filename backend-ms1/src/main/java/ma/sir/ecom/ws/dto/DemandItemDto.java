package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandItemDto  extends AuditBaseDto {

    private BigDecimal price  ;
    private BigDecimal quantity  ;
    private BigDecimal poundQuantity  ;

    private ProductDto product ;
    private DemandDto demand ;



    public DemandItemDto(){
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
    public BigDecimal getPoundQuantity(){
        return this.poundQuantity;
    }
    public void setPoundQuantity(BigDecimal poundQuantity){
        this.poundQuantity = poundQuantity;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public DemandDto getDemand(){
        return this.demand;
    }

    public void setDemand(DemandDto demand){
        this.demand = demand;
    }




}

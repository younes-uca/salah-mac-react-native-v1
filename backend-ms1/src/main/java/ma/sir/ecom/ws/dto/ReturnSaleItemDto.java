package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnSaleItemDto  extends AuditBaseDto {

    private BigDecimal returnAmount  ;
    private BigDecimal quantity  ;

    private ProductDto product ;
    private ReturnSaleDto returnSale ;



    public ReturnSaleItemDto(){
        super();
    }



    @Log
    public BigDecimal getReturnAmount(){
        return this.returnAmount;
    }
    public void setReturnAmount(BigDecimal returnAmount){
        this.returnAmount = returnAmount;
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
    public ReturnSaleDto getReturnSale(){
        return this.returnSale;
    }

    public void setReturnSale(ReturnSaleDto returnSale){
        this.returnSale = returnSale;
    }




}

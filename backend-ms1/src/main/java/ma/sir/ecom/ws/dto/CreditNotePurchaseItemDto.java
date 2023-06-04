package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditNotePurchaseItemDto  extends AuditBaseDto {

    private BigDecimal amount  ;
    private BigDecimal quantity  ;

    private ProductDto product ;
    private CreditNotePurchaseDto creditNotePurchase ;



    public CreditNotePurchaseItemDto(){
        super();
    }



    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
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
    public CreditNotePurchaseDto getCreditNotePurchase(){
        return this.creditNotePurchase;
    }

    public void setCreditNotePurchase(CreditNotePurchaseDto creditNotePurchase){
        this.creditNotePurchase = creditNotePurchase;
    }




}

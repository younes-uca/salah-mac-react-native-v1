package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseItemDto  extends AuditBaseDto {

    private BigDecimal unitPrice  ;
    private BigDecimal sellingPrice  ;
    private BigDecimal quantity  ;
    private BigDecimal returnQuantity  ;
    private BigDecimal discount  ;

    private ProductDto product ;
    private PurchaseDto purchase ;



    public PurchaseItemDto(){
        super();
    }



    @Log
    public BigDecimal getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
    }

    @Log
    public BigDecimal getSellingPrice(){
        return this.sellingPrice;
    }
    public void setSellingPrice(BigDecimal sellingPrice){
        this.sellingPrice = sellingPrice;
    }

    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    @Log
    public BigDecimal getReturnQuantity(){
        return this.returnQuantity;
    }
    public void setReturnQuantity(BigDecimal returnQuantity){
        this.returnQuantity = returnQuantity;
    }

    @Log
    public BigDecimal getDiscount(){
        return this.discount;
    }
    public void setDiscount(BigDecimal discount){
        this.discount = discount;
    }


    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }
    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }




}

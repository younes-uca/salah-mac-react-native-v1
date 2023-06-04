package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SupplierQuoteItemDto  extends AuditBaseDto {

    private BigDecimal unitPrice  ;
    private BigDecimal quantity  ;
    private BigDecimal discount  ;

    private ProductDto product ;
    private SupplierQuoteDto supplierQuote ;



    public SupplierQuoteItemDto(){
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
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
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
    public SupplierQuoteDto getSupplierQuote(){
        return this.supplierQuote;
    }

    public void setSupplierQuote(SupplierQuoteDto supplierQuote){
        this.supplierQuote = supplierQuote;
    }




}

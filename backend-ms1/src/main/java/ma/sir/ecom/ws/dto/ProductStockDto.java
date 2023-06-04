package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductStockDto  extends AuditBaseDto {

    private BigDecimal quantity  ;
    private BigDecimal defectiveQuantity  ;

    private ShopDto shop ;
    private ProductDto product ;



    public ProductStockDto(){
        super();
    }



    @Log
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }

    @Log
    public BigDecimal getDefectiveQuantity(){
        return this.defectiveQuantity;
    }
    public void setDefectiveQuantity(BigDecimal defectiveQuantity){
        this.defectiveQuantity = defectiveQuantity;
    }


    public ShopDto getShop(){
        return this.shop;
    }

    public void setShop(ShopDto shop){
        this.shop = shop;
    }
    public ProductDto getProduct(){
        return this.product;
    }

    public void setProduct(ProductDto product){
        this.product = product;
    }




}

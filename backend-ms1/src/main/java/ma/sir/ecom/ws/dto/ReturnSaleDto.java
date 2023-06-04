package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReturnSaleDto  extends AuditBaseDto {

    private String returnDate ;
    private BigDecimal amount  ;

    private SaleDto sale ;
    private ReturnStatusDto returnStatus ;

    private List<ReturnSaleItemDto> returnSaleItems ;


    public ReturnSaleDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getReturnDate(){
        return this.returnDate;
    }
    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }


    public SaleDto getSale(){
        return this.sale;
    }

    public void setSale(SaleDto sale){
        this.sale = sale;
    }
    public ReturnStatusDto getReturnStatus(){
        return this.returnStatus;
    }

    public void setReturnStatus(ReturnStatusDto returnStatus){
        this.returnStatus = returnStatus;
    }



    public List<ReturnSaleItemDto> getReturnSaleItems(){
        return this.returnSaleItems;
    }

    public void setReturnSaleItems(List<ReturnSaleItemDto> returnSaleItems){
        this.returnSaleItems = returnSaleItems;
    }

}

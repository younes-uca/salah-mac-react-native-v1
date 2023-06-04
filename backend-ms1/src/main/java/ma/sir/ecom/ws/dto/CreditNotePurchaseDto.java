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
public class CreditNotePurchaseDto  extends AuditBaseDto {

    private String creditNoteDate ;
    private BigDecimal amount  ;

    private PurchaseDto purchase ;
    private CreditNotePurchaseStatusDto creditNotePurchaseStatus ;

    private List<CreditNotePurchaseItemDto> creditNotePurchaseItems ;


    public CreditNotePurchaseDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getCreditNoteDate(){
        return this.creditNoteDate;
    }
    public void setCreditNoteDate(String creditNoteDate){
        this.creditNoteDate = creditNoteDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }


    public PurchaseDto getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseDto purchase){
        this.purchase = purchase;
    }
    public CreditNotePurchaseStatusDto getCreditNotePurchaseStatus(){
        return this.creditNotePurchaseStatus;
    }

    public void setCreditNotePurchaseStatus(CreditNotePurchaseStatusDto creditNotePurchaseStatus){
        this.creditNotePurchaseStatus = creditNotePurchaseStatus;
    }



    public List<CreditNotePurchaseItemDto> getCreditNotePurchaseItems(){
        return this.creditNotePurchaseItems;
    }

    public void setCreditNotePurchaseItems(List<CreditNotePurchaseItemDto> creditNotePurchaseItems){
        this.creditNotePurchaseItems = creditNotePurchaseItems;
    }

}

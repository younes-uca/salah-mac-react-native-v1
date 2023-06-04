package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandPaymentDto  extends AuditBaseDto {

    private String reference  ;
    private String paymentDate ;
    private BigDecimal amount  ;
    private String description  ;
    private Boolean vireCheck  ;

    private DemandDto demand ;
    private PaymentModeDto paymentMode ;
    private StatusPaymentDemandDto statusPaymentDemand ;



    public DemandPaymentDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getPaymentDate(){
        return this.paymentDate;
    }
    public void setPaymentDate(String paymentDate){
        this.paymentDate = paymentDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    @Log
    public Boolean getVireCheck(){
        return this.vireCheck;
    }
    public void setVireCheck(Boolean vireCheck){
        this.vireCheck = vireCheck;
    }


    public DemandDto getDemand(){
        return this.demand;
    }

    public void setDemand(DemandDto demand){
        this.demand = demand;
    }
    public PaymentModeDto getPaymentMode(){
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentModeDto paymentMode){
        this.paymentMode = paymentMode;
    }
    public StatusPaymentDemandDto getStatusPaymentDemand(){
        return this.statusPaymentDemand;
    }

    public void setStatusPaymentDemand(StatusPaymentDemandDto statusPaymentDemand){
        this.statusPaymentDemand = statusPaymentDemand;
    }




}

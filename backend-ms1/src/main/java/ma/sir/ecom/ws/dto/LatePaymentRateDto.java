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
public class LatePaymentRateDto  extends AuditBaseDto {

    private String minApplicationDate ;
    private String maxApplicationDate ;
    private BigDecimal amount  ;




    public LatePaymentRateDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getMinApplicationDate(){
        return this.minApplicationDate;
    }
    public void setMinApplicationDate(String minApplicationDate){
        this.minApplicationDate = minApplicationDate;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getMaxApplicationDate(){
        return this.maxApplicationDate;
    }
    public void setMaxApplicationDate(String maxApplicationDate){
        this.maxApplicationDate = maxApplicationDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }






}

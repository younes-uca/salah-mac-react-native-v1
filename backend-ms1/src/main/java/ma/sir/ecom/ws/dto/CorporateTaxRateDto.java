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
public class CorporateTaxRateDto  extends AuditBaseDto {

    private BigDecimal minimumIncome  ;
    private BigDecimal maximumIncome  ;
    private String minApplicationDate ;
    private String maxApplicationDate ;
    private BigDecimal percentage  ;




    public CorporateTaxRateDto(){
        super();
    }



    @Log
    public BigDecimal getMinimumIncome(){
        return this.minimumIncome;
    }
    public void setMinimumIncome(BigDecimal minimumIncome){
        this.minimumIncome = minimumIncome;
    }

    @Log
    public BigDecimal getMaximumIncome(){
        return this.maximumIncome;
    }
    public void setMaximumIncome(BigDecimal maximumIncome){
        this.maximumIncome = maximumIncome;
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
    public BigDecimal getPercentage(){
        return this.percentage;
    }
    public void setPercentage(BigDecimal percentage){
        this.percentage = percentage;
    }






}

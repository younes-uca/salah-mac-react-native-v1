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
public class VatDeclarationDto  extends AuditBaseDto {

    private String reference  ;
    private String declarationDate ;
    private Integer quarter  = 0 ;
    private Integer year  = 0 ;
    private BigDecimal totalCollectedVat  ;
    private BigDecimal totalDueVat  ;
    private BigDecimal vatDifference  ;
    private BigDecimal vatAmount  ;

    private CompanyDto company ;
    private LatePaymentRateDto latePaymentRate ;
    private HandlingAccountantDto handlingAccountant ;
    private ValidationAccountantDto validationAccountant ;



    public VatDeclarationDto(){
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
    public String getDeclarationDate(){
        return this.declarationDate;
    }
    public void setDeclarationDate(String declarationDate){
        this.declarationDate = declarationDate;
    }

    @Log
    public Integer getQuarter(){
        return this.quarter;
    }
    public void setQuarter(Integer quarter){
        this.quarter = quarter;
    }

    @Log
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }

    @Log
    public BigDecimal getTotalCollectedVat(){
        return this.totalCollectedVat;
    }
    public void setTotalCollectedVat(BigDecimal totalCollectedVat){
        this.totalCollectedVat = totalCollectedVat;
    }

    @Log
    public BigDecimal getTotalDueVat(){
        return this.totalDueVat;
    }
    public void setTotalDueVat(BigDecimal totalDueVat){
        this.totalDueVat = totalDueVat;
    }

    @Log
    public BigDecimal getVatDifference(){
        return this.vatDifference;
    }
    public void setVatDifference(BigDecimal vatDifference){
        this.vatDifference = vatDifference;
    }

    @Log
    public BigDecimal getVatAmount(){
        return this.vatAmount;
    }
    public void setVatAmount(BigDecimal vatAmount){
        this.vatAmount = vatAmount;
    }


    public CompanyDto getCompany(){
        return this.company;
    }

    public void setCompany(CompanyDto company){
        this.company = company;
    }
    public LatePaymentRateDto getLatePaymentRate(){
        return this.latePaymentRate;
    }

    public void setLatePaymentRate(LatePaymentRateDto latePaymentRate){
        this.latePaymentRate = latePaymentRate;
    }
    public HandlingAccountantDto getHandlingAccountant(){
        return this.handlingAccountant;
    }

    public void setHandlingAccountant(HandlingAccountantDto handlingAccountant){
        this.handlingAccountant = handlingAccountant;
    }
    public ValidationAccountantDto getValidationAccountant(){
        return this.validationAccountant;
    }

    public void setValidationAccountant(ValidationAccountantDto validationAccountant){
        this.validationAccountant = validationAccountant;
    }




}

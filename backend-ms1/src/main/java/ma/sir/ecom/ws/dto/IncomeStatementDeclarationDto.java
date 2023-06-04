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
public class IncomeStatementDeclarationDto  extends AuditBaseDto {

    private String reference  ;
    private String declarationDate ;
    private Integer quarter  = 0 ;
    private Integer year  = 0 ;
    private BigDecimal totalExpense  ;
    private BigDecimal totalRevenue  ;
    private BigDecimal incomeBeforeTax  ;
    private BigDecimal taxAmount  ;
    private BigDecimal incomeAfterTax  ;

    private CompanyDto company ;
    private CorporateTaxRateDto corporateTaxRate ;
    private HandlingAccountantDto handlingAccountant ;
    private ValidationAccountantDto validationAccountant ;



    public IncomeStatementDeclarationDto(){
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
    public BigDecimal getTotalExpense(){
        return this.totalExpense;
    }
    public void setTotalExpense(BigDecimal totalExpense){
        this.totalExpense = totalExpense;
    }

    @Log
    public BigDecimal getTotalRevenue(){
        return this.totalRevenue;
    }
    public void setTotalRevenue(BigDecimal totalRevenue){
        this.totalRevenue = totalRevenue;
    }

    @Log
    public BigDecimal getIncomeBeforeTax(){
        return this.incomeBeforeTax;
    }
    public void setIncomeBeforeTax(BigDecimal incomeBeforeTax){
        this.incomeBeforeTax = incomeBeforeTax;
    }

    @Log
    public BigDecimal getTaxAmount(){
        return this.taxAmount;
    }
    public void setTaxAmount(BigDecimal taxAmount){
        this.taxAmount = taxAmount;
    }

    @Log
    public BigDecimal getIncomeAfterTax(){
        return this.incomeAfterTax;
    }
    public void setIncomeAfterTax(BigDecimal incomeAfterTax){
        this.incomeAfterTax = incomeAfterTax;
    }


    public CompanyDto getCompany(){
        return this.company;
    }

    public void setCompany(CompanyDto company){
        this.company = company;
    }
    public CorporateTaxRateDto getCorporateTaxRate(){
        return this.corporateTaxRate;
    }

    public void setCorporateTaxRate(CorporateTaxRateDto corporateTaxRate){
        this.corporateTaxRate = corporateTaxRate;
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

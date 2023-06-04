package ma.sir.ecom.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "income_statement_declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="income_statement_declaration_seq",sequenceName="income_statement_declaration_seq",allocationSize=1, initialValue = 1)
public class IncomeStatementDeclaration   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime declarationDate ;
    private Integer quarter = 0;
    private Integer year = 0;
    private BigDecimal totalExpense = BigDecimal.ZERO;
    private BigDecimal totalRevenue = BigDecimal.ZERO;
    private BigDecimal incomeBeforeTax = BigDecimal.ZERO;
    private BigDecimal taxAmount = BigDecimal.ZERO;
    private BigDecimal incomeAfterTax = BigDecimal.ZERO;

    private Company company ;
    
    private CorporateTaxRate corporateTaxRate ;
    
    private HandlingAccountant handlingAccountant ;
    
    private ValidationAccountant validationAccountant ;
    


    public IncomeStatementDeclaration(){
        super();
    }

    public IncomeStatementDeclaration(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="income_statement_declaration_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDeclarationDate(){
        return this.declarationDate;
    }
    public void setDeclarationDate(LocalDateTime declarationDate){
        this.declarationDate = declarationDate;
    }
    public Integer getQuarter(){
        return this.quarter;
    }
    public void setQuarter(Integer quarter){
        this.quarter = quarter;
    }
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public BigDecimal getTotalExpense(){
        return this.totalExpense;
    }
    public void setTotalExpense(BigDecimal totalExpense){
        this.totalExpense = totalExpense;
    }
    public BigDecimal getTotalRevenue(){
        return this.totalRevenue;
    }
    public void setTotalRevenue(BigDecimal totalRevenue){
        this.totalRevenue = totalRevenue;
    }
    public BigDecimal getIncomeBeforeTax(){
        return this.incomeBeforeTax;
    }
    public void setIncomeBeforeTax(BigDecimal incomeBeforeTax){
        this.incomeBeforeTax = incomeBeforeTax;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CorporateTaxRate getCorporateTaxRate(){
        return this.corporateTaxRate;
    }
    public void setCorporateTaxRate(CorporateTaxRate corporateTaxRate){
        this.corporateTaxRate = corporateTaxRate;
    }
    public BigDecimal getTaxAmount(){
        return this.taxAmount;
    }
    public void setTaxAmount(BigDecimal taxAmount){
        this.taxAmount = taxAmount;
    }
    public BigDecimal getIncomeAfterTax(){
        return this.incomeAfterTax;
    }
    public void setIncomeAfterTax(BigDecimal incomeAfterTax){
        this.incomeAfterTax = incomeAfterTax;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public HandlingAccountant getHandlingAccountant(){
        return this.handlingAccountant;
    }
    public void setHandlingAccountant(HandlingAccountant handlingAccountant){
        this.handlingAccountant = handlingAccountant;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ValidationAccountant getValidationAccountant(){
        return this.validationAccountant;
    }
    public void setValidationAccountant(ValidationAccountant validationAccountant){
        this.validationAccountant = validationAccountant;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeStatementDeclaration incomeStatementDeclaration = (IncomeStatementDeclaration) o;
        return id != null && id.equals(incomeStatementDeclaration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


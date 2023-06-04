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
@Table(name = "vat_declaration")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="vat_declaration_seq",sequenceName="vat_declaration_seq",allocationSize=1, initialValue = 1)
public class VatDeclaration   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime declarationDate ;
    private Integer quarter = 0;
    private Integer year = 0;
    private BigDecimal totalCollectedVat = BigDecimal.ZERO;
    private BigDecimal totalDueVat = BigDecimal.ZERO;
    private BigDecimal vatDifference = BigDecimal.ZERO;
    private BigDecimal vatAmount = BigDecimal.ZERO;

    private Company company ;
    
    private LatePaymentRate latePaymentRate ;
    
    private HandlingAccountant handlingAccountant ;
    
    private ValidationAccountant validationAccountant ;
    


    public VatDeclaration(){
        super();
    }

    public VatDeclaration(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="vat_declaration_seq")
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
    public BigDecimal getTotalCollectedVat(){
        return this.totalCollectedVat;
    }
    public void setTotalCollectedVat(BigDecimal totalCollectedVat){
        this.totalCollectedVat = totalCollectedVat;
    }
    public BigDecimal getTotalDueVat(){
        return this.totalDueVat;
    }
    public void setTotalDueVat(BigDecimal totalDueVat){
        this.totalDueVat = totalDueVat;
    }
    public BigDecimal getVatDifference(){
        return this.vatDifference;
    }
    public void setVatDifference(BigDecimal vatDifference){
        this.vatDifference = vatDifference;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public LatePaymentRate getLatePaymentRate(){
        return this.latePaymentRate;
    }
    public void setLatePaymentRate(LatePaymentRate latePaymentRate){
        this.latePaymentRate = latePaymentRate;
    }
    public BigDecimal getVatAmount(){
        return this.vatAmount;
    }
    public void setVatAmount(BigDecimal vatAmount){
        this.vatAmount = vatAmount;
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
        VatDeclaration vatDeclaration = (VatDeclaration) o;
        return id != null && id.equals(vatDeclaration.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


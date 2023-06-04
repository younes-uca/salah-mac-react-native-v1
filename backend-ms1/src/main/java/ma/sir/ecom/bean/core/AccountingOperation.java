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
@Table(name = "accounting_operation")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="accounting_operation_seq",sequenceName="accounting_operation_seq",allocationSize=1, initialValue = 1)
public class AccountingOperation   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String libelle;
    private Integer year = 0;
    private Integer month = 0;
    private LocalDateTime accountingOperationDate ;
    private BigDecimal amount = BigDecimal.ZERO;

    private Company company ;
    
    private AccountingAccount accountingAccount ;
    
    private AccountingOperationType accountingOperationType ;
    
    private AccountingOperationStatus accountingOperationStatus ;
    


    public AccountingOperation(){
        super();
    }

    public AccountingOperation(Long id,String libelle){
        this.id = id;
        this.libelle = libelle ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="accounting_operation_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    public Integer getMonth(){
        return this.month;
    }
    public void setMonth(Integer month){
        this.month = month;
    }
    public LocalDateTime getAccountingOperationDate(){
        return this.accountingOperationDate;
    }
    public void setAccountingOperationDate(LocalDateTime accountingOperationDate){
        this.accountingOperationDate = accountingOperationDate;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AccountingAccount getAccountingAccount(){
        return this.accountingAccount;
    }
    public void setAccountingAccount(AccountingAccount accountingAccount){
        this.accountingAccount = accountingAccount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AccountingOperationType getAccountingOperationType(){
        return this.accountingOperationType;
    }
    public void setAccountingOperationType(AccountingOperationType accountingOperationType){
        this.accountingOperationType = accountingOperationType;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public AccountingOperationStatus getAccountingOperationStatus(){
        return this.accountingOperationStatus;
    }
    public void setAccountingOperationStatus(AccountingOperationStatus accountingOperationStatus){
        this.accountingOperationStatus = accountingOperationStatus;
    }

    @Transient
    public String getLabel() {
        label = libelle;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountingOperation accountingOperation = (AccountingOperation) o;
        return id != null && id.equals(accountingOperation.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


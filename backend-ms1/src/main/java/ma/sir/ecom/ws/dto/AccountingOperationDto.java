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
public class AccountingOperationDto  extends AuditBaseDto {

    private String libelle  ;
    private Integer year  = 0 ;
    private Integer month  = 0 ;
    private String accountingOperationDate ;
    private BigDecimal amount  ;

    private CompanyDto company ;
    private AccountingAccountDto accountingAccount ;
    private AccountingOperationTypeDto accountingOperationType ;
    private AccountingOperationStatusDto accountingOperationStatus ;



    public AccountingOperationDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }

    @Log
    public Integer getMonth(){
        return this.month;
    }
    public void setMonth(Integer month){
        this.month = month;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getAccountingOperationDate(){
        return this.accountingOperationDate;
    }
    public void setAccountingOperationDate(String accountingOperationDate){
        this.accountingOperationDate = accountingOperationDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }


    public CompanyDto getCompany(){
        return this.company;
    }

    public void setCompany(CompanyDto company){
        this.company = company;
    }
    public AccountingAccountDto getAccountingAccount(){
        return this.accountingAccount;
    }

    public void setAccountingAccount(AccountingAccountDto accountingAccount){
        this.accountingAccount = accountingAccount;
    }
    public AccountingOperationTypeDto getAccountingOperationType(){
        return this.accountingOperationType;
    }

    public void setAccountingOperationType(AccountingOperationTypeDto accountingOperationType){
        this.accountingOperationType = accountingOperationType;
    }
    public AccountingOperationStatusDto getAccountingOperationStatus(){
        return this.accountingOperationStatus;
    }

    public void setAccountingOperationStatus(AccountingOperationStatusDto accountingOperationStatus){
        this.accountingOperationStatus = accountingOperationStatus;
    }




}

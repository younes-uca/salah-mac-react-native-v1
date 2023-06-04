package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class AccountingOperationCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String year;
    private String yearMin;
    private String yearMax;
    private String month;
    private String monthMin;
    private String monthMax;
    private LocalDateTime accountingOperationDate;
    private LocalDateTime accountingOperationDateFrom;
    private LocalDateTime accountingOperationDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;

    private CompanyCriteria company ;
    private List<CompanyCriteria> companys ;
    private AccountingAccountCriteria accountingAccount ;
    private List<AccountingAccountCriteria> accountingAccounts ;
    private AccountingOperationTypeCriteria accountingOperationType ;
    private List<AccountingOperationTypeCriteria> accountingOperationTypes ;
    private AccountingOperationStatusCriteria accountingOperationStatus ;
    private List<AccountingOperationStatusCriteria> accountingOperationStatuss ;


    public AccountingOperationCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getYear(){
        return this.year;
    }
    public void setYear(String year){
        this.year = year;
    }   
    public String getYearMin(){
        return this.yearMin;
    }
    public void setYearMin(String yearMin){
        this.yearMin = yearMin;
    }
    public String getYearMax(){
        return this.yearMax;
    }
    public void setYearMax(String yearMax){
        this.yearMax = yearMax;
    }
      
    public String getMonth(){
        return this.month;
    }
    public void setMonth(String month){
        this.month = month;
    }   
    public String getMonthMin(){
        return this.monthMin;
    }
    public void setMonthMin(String monthMin){
        this.monthMin = monthMin;
    }
    public String getMonthMax(){
        return this.monthMax;
    }
    public void setMonthMax(String monthMax){
        this.monthMax = monthMax;
    }
      
    public LocalDateTime getAccountingOperationDate(){
        return this.accountingOperationDate;
    }
    public void setAccountingOperationDate(LocalDateTime accountingOperationDate){
        this.accountingOperationDate = accountingOperationDate;
    }
    public LocalDateTime getAccountingOperationDateFrom(){
        return this.accountingOperationDateFrom;
    }
    public void setAccountingOperationDateFrom(LocalDateTime accountingOperationDateFrom){
        this.accountingOperationDateFrom = accountingOperationDateFrom;
    }
    public LocalDateTime getAccountingOperationDateTo(){
        return this.accountingOperationDateTo;
    }
    public void setAccountingOperationDateTo(LocalDateTime accountingOperationDateTo){
        this.accountingOperationDateTo = accountingOperationDateTo;
    }
    public String getAmount(){
        return this.amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }   
    public String getAmountMin(){
        return this.amountMin;
    }
    public void setAmountMin(String amountMin){
        this.amountMin = amountMin;
    }
    public String getAmountMax(){
        return this.amountMax;
    }
    public void setAmountMax(String amountMax){
        this.amountMax = amountMax;
    }
      

    public CompanyCriteria getCompany(){
        return this.company;
    }

    public void setCompany(CompanyCriteria company){
        this.company = company;
    }
    public List<CompanyCriteria> getCompanys(){
        return this.companys;
    }

    public void setCompanys(List<CompanyCriteria> companys){
        this.companys = companys;
    }
    public AccountingAccountCriteria getAccountingAccount(){
        return this.accountingAccount;
    }

    public void setAccountingAccount(AccountingAccountCriteria accountingAccount){
        this.accountingAccount = accountingAccount;
    }
    public List<AccountingAccountCriteria> getAccountingAccounts(){
        return this.accountingAccounts;
    }

    public void setAccountingAccounts(List<AccountingAccountCriteria> accountingAccounts){
        this.accountingAccounts = accountingAccounts;
    }
    public AccountingOperationTypeCriteria getAccountingOperationType(){
        return this.accountingOperationType;
    }

    public void setAccountingOperationType(AccountingOperationTypeCriteria accountingOperationType){
        this.accountingOperationType = accountingOperationType;
    }
    public List<AccountingOperationTypeCriteria> getAccountingOperationTypes(){
        return this.accountingOperationTypes;
    }

    public void setAccountingOperationTypes(List<AccountingOperationTypeCriteria> accountingOperationTypes){
        this.accountingOperationTypes = accountingOperationTypes;
    }
    public AccountingOperationStatusCriteria getAccountingOperationStatus(){
        return this.accountingOperationStatus;
    }

    public void setAccountingOperationStatus(AccountingOperationStatusCriteria accountingOperationStatus){
        this.accountingOperationStatus = accountingOperationStatus;
    }
    public List<AccountingOperationStatusCriteria> getAccountingOperationStatuss(){
        return this.accountingOperationStatuss;
    }

    public void setAccountingOperationStatuss(List<AccountingOperationStatusCriteria> accountingOperationStatuss){
        this.accountingOperationStatuss = accountingOperationStatuss;
    }
}

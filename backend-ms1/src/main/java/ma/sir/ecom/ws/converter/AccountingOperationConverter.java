package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Company;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.AccountingOperationHistory;
import ma.sir.ecom.bean.core.AccountingOperation;
import ma.sir.ecom.ws.dto.AccountingOperationDto;

@Component
public class AccountingOperationConverter extends AbstractConverter<AccountingOperation, AccountingOperationDto, AccountingOperationHistory> {

    @Autowired
    private CompanyConverter companyConverter ;
    @Autowired
    private AccountingAccountConverter accountingAccountConverter ;
    @Autowired
    private AccountingOperationStatusConverter accountingOperationStatusConverter ;
    @Autowired
    private AccountingOperationTypeConverter accountingOperationTypeConverter ;
    private boolean company;
    private boolean accountingAccount;
    private boolean accountingOperationType;
    private boolean accountingOperationStatus;

    public  AccountingOperationConverter(){
        super(AccountingOperation.class, AccountingOperationDto.class, AccountingOperationHistory.class);
    }

    @Override
    public AccountingOperation toItem(AccountingOperationDto dto) {
        if (dto == null) {
            return null;
        } else {
        AccountingOperation item = new AccountingOperation();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getYear()))
                item.setYear(dto.getYear());
            if(StringUtil.isNotEmpty(dto.getMonth()))
                item.setMonth(dto.getMonth());
            if(StringUtil.isNotEmpty(dto.getAccountingOperationDate()))
                item.setAccountingOperationDate(DateUtil.stringEnToDate(dto.getAccountingOperationDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(dto.getCompany() != null && dto.getCompany().getId() != null){
                item.setCompany(new Company());
                item.getCompany().setId(dto.getCompany().getId());
            }

            if(this.accountingAccount && dto.getAccountingAccount()!=null)
                item.setAccountingAccount(accountingAccountConverter.toItem(dto.getAccountingAccount())) ;

            if(this.accountingOperationType && dto.getAccountingOperationType()!=null)
                item.setAccountingOperationType(accountingOperationTypeConverter.toItem(dto.getAccountingOperationType())) ;

            if(this.accountingOperationStatus && dto.getAccountingOperationStatus()!=null)
                item.setAccountingOperationStatus(accountingOperationStatusConverter.toItem(dto.getAccountingOperationStatus())) ;



        return item;
        }
    }

    @Override
    public AccountingOperationDto toDto(AccountingOperation item) {
        if (item == null) {
            return null;
        } else {
            AccountingOperationDto dto = new AccountingOperationDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getYear()))
                dto.setYear(item.getYear());
            if(StringUtil.isNotEmpty(item.getMonth()))
                dto.setMonth(item.getMonth());
            if(item.getAccountingOperationDate()!=null)
                dto.setAccountingOperationDate(DateUtil.dateTimeToString(item.getAccountingOperationDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
        if(this.company && item.getCompany()!=null) {
            dto.setCompany(companyConverter.toDto(item.getCompany())) ;
        }
        if(this.accountingAccount && item.getAccountingAccount()!=null) {
            dto.setAccountingAccount(accountingAccountConverter.toDto(item.getAccountingAccount())) ;
        }
        if(this.accountingOperationType && item.getAccountingOperationType()!=null) {
            dto.setAccountingOperationType(accountingOperationTypeConverter.toDto(item.getAccountingOperationType())) ;
        }
        if(this.accountingOperationStatus && item.getAccountingOperationStatus()!=null) {
            dto.setAccountingOperationStatus(accountingOperationStatusConverter.toDto(item.getAccountingOperationStatus())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.company = value;
        this.accountingAccount = value;
        this.accountingOperationType = value;
        this.accountingOperationStatus = value;
    }


    public CompanyConverter getCompanyConverter(){
        return this.companyConverter;
    }
    public void setCompanyConverter(CompanyConverter companyConverter ){
        this.companyConverter = companyConverter;
    }
    public AccountingAccountConverter getAccountingAccountConverter(){
        return this.accountingAccountConverter;
    }
    public void setAccountingAccountConverter(AccountingAccountConverter accountingAccountConverter ){
        this.accountingAccountConverter = accountingAccountConverter;
    }
    public AccountingOperationStatusConverter getAccountingOperationStatusConverter(){
        return this.accountingOperationStatusConverter;
    }
    public void setAccountingOperationStatusConverter(AccountingOperationStatusConverter accountingOperationStatusConverter ){
        this.accountingOperationStatusConverter = accountingOperationStatusConverter;
    }
    public AccountingOperationTypeConverter getAccountingOperationTypeConverter(){
        return this.accountingOperationTypeConverter;
    }
    public void setAccountingOperationTypeConverter(AccountingOperationTypeConverter accountingOperationTypeConverter ){
        this.accountingOperationTypeConverter = accountingOperationTypeConverter;
    }
    public boolean  isCompany(){
        return this.company;
    }
    public void  setCompany(boolean company){
        this.company = company;
    }
    public boolean  isAccountingAccount(){
        return this.accountingAccount;
    }
    public void  setAccountingAccount(boolean accountingAccount){
        this.accountingAccount = accountingAccount;
    }
    public boolean  isAccountingOperationType(){
        return this.accountingOperationType;
    }
    public void  setAccountingOperationType(boolean accountingOperationType){
        this.accountingOperationType = accountingOperationType;
    }
    public boolean  isAccountingOperationStatus(){
        return this.accountingOperationStatus;
    }
    public void  setAccountingOperationStatus(boolean accountingOperationStatus){
        this.accountingOperationStatus = accountingOperationStatus;
    }
}

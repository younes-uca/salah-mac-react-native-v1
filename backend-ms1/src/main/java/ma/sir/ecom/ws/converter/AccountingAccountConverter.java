package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.AccountingAccountHistory;
import ma.sir.ecom.bean.core.AccountingAccount;
import ma.sir.ecom.ws.dto.AccountingAccountDto;

@Component
public class AccountingAccountConverter extends AbstractConverter<AccountingAccount, AccountingAccountDto, AccountingAccountHistory> {

    @Autowired
    private SubAccountingClassConverter subAccountingClassConverter ;
    private boolean subAccountingClass;

    public  AccountingAccountConverter(){
        super(AccountingAccount.class, AccountingAccountDto.class, AccountingAccountHistory.class);
    }

    @Override
    public AccountingAccount toItem(AccountingAccountDto dto) {
        if (dto == null) {
            return null;
        } else {
        AccountingAccount item = new AccountingAccount();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.subAccountingClass && dto.getSubAccountingClass()!=null)
                item.setSubAccountingClass(subAccountingClassConverter.toItem(dto.getSubAccountingClass())) ;



        return item;
        }
    }

    @Override
    public AccountingAccountDto toDto(AccountingAccount item) {
        if (item == null) {
            return null;
        } else {
            AccountingAccountDto dto = new AccountingAccountDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.subAccountingClass && item.getSubAccountingClass()!=null) {
            dto.setSubAccountingClass(subAccountingClassConverter.toDto(item.getSubAccountingClass())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.subAccountingClass = value;
    }


    public SubAccountingClassConverter getSubAccountingClassConverter(){
        return this.subAccountingClassConverter;
    }
    public void setSubAccountingClassConverter(SubAccountingClassConverter subAccountingClassConverter ){
        this.subAccountingClassConverter = subAccountingClassConverter;
    }
    public boolean  isSubAccountingClass(){
        return this.subAccountingClass;
    }
    public void  setSubAccountingClass(boolean subAccountingClass){
        this.subAccountingClass = subAccountingClass;
    }
}

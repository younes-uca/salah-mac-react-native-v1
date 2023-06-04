package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SubAccountingClassHistory;
import ma.sir.ecom.bean.core.SubAccountingClass;
import ma.sir.ecom.ws.dto.SubAccountingClassDto;

@Component
public class SubAccountingClassConverter extends AbstractConverter<SubAccountingClass, SubAccountingClassDto, SubAccountingClassHistory> {

    @Autowired
    private AccountingClassConverter accountingClassConverter ;
    private boolean accountingClass;

    public  SubAccountingClassConverter(){
        super(SubAccountingClass.class, SubAccountingClassDto.class, SubAccountingClassHistory.class);
    }

    @Override
    public SubAccountingClass toItem(SubAccountingClassDto dto) {
        if (dto == null) {
            return null;
        } else {
        SubAccountingClass item = new SubAccountingClass();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(this.accountingClass && dto.getAccountingClass()!=null)
                item.setAccountingClass(accountingClassConverter.toItem(dto.getAccountingClass())) ;



        return item;
        }
    }

    @Override
    public SubAccountingClassDto toDto(SubAccountingClass item) {
        if (item == null) {
            return null;
        } else {
            SubAccountingClassDto dto = new SubAccountingClassDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
        if(this.accountingClass && item.getAccountingClass()!=null) {
            dto.setAccountingClass(accountingClassConverter.toDto(item.getAccountingClass())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.accountingClass = value;
    }


    public AccountingClassConverter getAccountingClassConverter(){
        return this.accountingClassConverter;
    }
    public void setAccountingClassConverter(AccountingClassConverter accountingClassConverter ){
        this.accountingClassConverter = accountingClassConverter;
    }
    public boolean  isAccountingClass(){
        return this.accountingClass;
    }
    public void  setAccountingClass(boolean accountingClass){
        this.accountingClass = accountingClass;
    }
}

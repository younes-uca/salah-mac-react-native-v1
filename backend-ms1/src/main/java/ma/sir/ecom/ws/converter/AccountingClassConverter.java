package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.AccountingClassHistory;
import ma.sir.ecom.bean.core.AccountingClass;
import ma.sir.ecom.ws.dto.AccountingClassDto;

@Component
public class AccountingClassConverter extends AbstractConverter<AccountingClass, AccountingClassDto, AccountingClassHistory> {


    public  AccountingClassConverter(){
        super(AccountingClass.class, AccountingClassDto.class, AccountingClassHistory.class);
    }

    @Override
    public AccountingClass toItem(AccountingClassDto dto) {
        if (dto == null) {
            return null;
        } else {
        AccountingClass item = new AccountingClass();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public AccountingClassDto toDto(AccountingClass item) {
        if (item == null) {
            return null;
        } else {
            AccountingClassDto dto = new AccountingClassDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.AccountingOperationTypeHistory;
import ma.sir.ecom.bean.core.AccountingOperationType;
import ma.sir.ecom.ws.dto.AccountingOperationTypeDto;

@Component
public class AccountingOperationTypeConverter extends AbstractConverter<AccountingOperationType, AccountingOperationTypeDto, AccountingOperationTypeHistory> {


    public  AccountingOperationTypeConverter(){
        super(AccountingOperationType.class, AccountingOperationTypeDto.class, AccountingOperationTypeHistory.class);
    }

    @Override
    public AccountingOperationType toItem(AccountingOperationTypeDto dto) {
        if (dto == null) {
            return null;
        } else {
        AccountingOperationType item = new AccountingOperationType();
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
    public AccountingOperationTypeDto toDto(AccountingOperationType item) {
        if (item == null) {
            return null;
        } else {
            AccountingOperationTypeDto dto = new AccountingOperationTypeDto();
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

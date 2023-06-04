package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.AccountingOperationStatusHistory;
import ma.sir.ecom.bean.core.AccountingOperationStatus;
import ma.sir.ecom.ws.dto.AccountingOperationStatusDto;

@Component
public class AccountingOperationStatusConverter extends AbstractConverter<AccountingOperationStatus, AccountingOperationStatusDto, AccountingOperationStatusHistory> {


    public  AccountingOperationStatusConverter(){
        super(AccountingOperationStatus.class, AccountingOperationStatusDto.class, AccountingOperationStatusHistory.class);
    }

    @Override
    public AccountingOperationStatus toItem(AccountingOperationStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        AccountingOperationStatus item = new AccountingOperationStatus();
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
    public AccountingOperationStatusDto toDto(AccountingOperationStatus item) {
        if (item == null) {
            return null;
        } else {
            AccountingOperationStatusDto dto = new AccountingOperationStatusDto();
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

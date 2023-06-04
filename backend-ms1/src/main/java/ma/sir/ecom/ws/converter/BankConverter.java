package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.BankHistory;
import ma.sir.ecom.bean.core.Bank;
import ma.sir.ecom.ws.dto.BankDto;

@Component
public class BankConverter extends AbstractConverter<Bank, BankDto, BankHistory> {


    public  BankConverter(){
        super(Bank.class, BankDto.class, BankHistory.class);
    }

    @Override
    public Bank toItem(BankDto dto) {
        if (dto == null) {
            return null;
        } else {
        Bank item = new Bank();
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
    public BankDto toDto(Bank item) {
        if (item == null) {
            return null;
        } else {
            BankDto dto = new BankDto();
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

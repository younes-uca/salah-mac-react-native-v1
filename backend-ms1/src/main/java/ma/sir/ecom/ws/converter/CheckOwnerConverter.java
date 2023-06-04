package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CheckOwnerHistory;
import ma.sir.ecom.bean.core.CheckOwner;
import ma.sir.ecom.ws.dto.CheckOwnerDto;

@Component
public class CheckOwnerConverter extends AbstractConverter<CheckOwner, CheckOwnerDto, CheckOwnerHistory> {


    public  CheckOwnerConverter(){
        super(CheckOwner.class, CheckOwnerDto.class, CheckOwnerHistory.class);
    }

    @Override
    public CheckOwner toItem(CheckOwnerDto dto) {
        if (dto == null) {
            return null;
        } else {
        CheckOwner item = new CheckOwner();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public CheckOwnerDto toDto(CheckOwner item) {
        if (item == null) {
            return null;
        } else {
            CheckOwnerDto dto = new CheckOwnerDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

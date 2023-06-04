package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.HandlingAccountantHistory;
import ma.sir.ecom.bean.core.HandlingAccountant;
import ma.sir.ecom.ws.dto.HandlingAccountantDto;

@Component
public class HandlingAccountantConverter extends AbstractConverter<HandlingAccountant, HandlingAccountantDto, HandlingAccountantHistory> {


    public  HandlingAccountantConverter(){
        super(HandlingAccountant.class, HandlingAccountantDto.class, HandlingAccountantHistory.class);
    }

    @Override
    public HandlingAccountant toItem(HandlingAccountantDto dto) {
        if (dto == null) {
            return null;
        } else {
        HandlingAccountant item = new HandlingAccountant();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getCin()))
                item.setCin(dto.getCin());
            if(StringUtil.isNotEmpty(dto.getLastName()))
                item.setLastName(dto.getLastName());
            if(StringUtil.isNotEmpty(dto.getFirstName()))
                item.setFirstName(dto.getFirstName());


        return item;
        }
    }

    @Override
    public HandlingAccountantDto toDto(HandlingAccountant item) {
        if (item == null) {
            return null;
        } else {
            HandlingAccountantDto dto = new HandlingAccountantDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getCin()))
                dto.setCin(item.getCin());
            if(StringUtil.isNotEmpty(item.getLastName()))
                dto.setLastName(item.getLastName());
            if(StringUtil.isNotEmpty(item.getFirstName()))
                dto.setFirstName(item.getFirstName());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

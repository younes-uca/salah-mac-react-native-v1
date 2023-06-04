package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ValidationAccountantHistory;
import ma.sir.ecom.bean.core.ValidationAccountant;
import ma.sir.ecom.ws.dto.ValidationAccountantDto;

@Component
public class ValidationAccountantConverter extends AbstractConverter<ValidationAccountant, ValidationAccountantDto, ValidationAccountantHistory> {


    public  ValidationAccountantConverter(){
        super(ValidationAccountant.class, ValidationAccountantDto.class, ValidationAccountantHistory.class);
    }

    @Override
    public ValidationAccountant toItem(ValidationAccountantDto dto) {
        if (dto == null) {
            return null;
        } else {
        ValidationAccountant item = new ValidationAccountant();
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
    public ValidationAccountantDto toDto(ValidationAccountant item) {
        if (item == null) {
            return null;
        } else {
            ValidationAccountantDto dto = new ValidationAccountantDto();
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

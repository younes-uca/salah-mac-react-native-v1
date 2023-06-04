package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentModeHistory;
import ma.sir.ecom.bean.core.PaymentMode;
import ma.sir.ecom.ws.dto.PaymentModeDto;

@Component
public class PaymentModeConverter extends AbstractConverter<PaymentMode, PaymentModeDto, PaymentModeHistory> {


    public  PaymentModeConverter(){
        super(PaymentMode.class, PaymentModeDto.class, PaymentModeHistory.class);
    }

    @Override
    public PaymentMode toItem(PaymentModeDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentMode item = new PaymentMode();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());
            if(StringUtil.isNotEmpty(dto.getStyle()))
                item.setStyle(dto.getStyle());


        return item;
        }
    }

    @Override
    public PaymentModeDto toDto(PaymentMode item) {
        if (item == null) {
            return null;
        } else {
            PaymentModeDto dto = new PaymentModeDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());
            if(StringUtil.isNotEmpty(item.getStyle()))
                dto.setStyle(item.getStyle());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentMethodHistory;
import ma.sir.ecom.bean.core.PaymentMethod;
import ma.sir.ecom.ws.dto.PaymentMethodDto;

@Component
public class PaymentMethodConverter extends AbstractConverter<PaymentMethod, PaymentMethodDto, PaymentMethodHistory> {


    public  PaymentMethodConverter(){
        super(PaymentMethod.class, PaymentMethodDto.class, PaymentMethodHistory.class);
    }

    @Override
    public PaymentMethod toItem(PaymentMethodDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentMethod item = new PaymentMethod();
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
    public PaymentMethodDto toDto(PaymentMethod item) {
        if (item == null) {
            return null;
        } else {
            PaymentMethodDto dto = new PaymentMethodDto();
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

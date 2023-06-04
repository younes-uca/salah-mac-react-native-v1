package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentStatusHistory;
import ma.sir.ecom.bean.core.PaymentStatus;
import ma.sir.ecom.ws.dto.PaymentStatusDto;

@Component
public class PaymentStatusConverter extends AbstractConverter<PaymentStatus, PaymentStatusDto, PaymentStatusHistory> {


    public  PaymentStatusConverter(){
        super(PaymentStatus.class, PaymentStatusDto.class, PaymentStatusHistory.class);
    }

    @Override
    public PaymentStatus toItem(PaymentStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentStatus item = new PaymentStatus();
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
    public PaymentStatusDto toDto(PaymentStatus item) {
        if (item == null) {
            return null;
        } else {
            PaymentStatusDto dto = new PaymentStatusDto();
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

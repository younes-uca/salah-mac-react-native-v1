package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentDeliveryStatusHistory;
import ma.sir.ecom.bean.core.PaymentDeliveryStatus;
import ma.sir.ecom.ws.dto.PaymentDeliveryStatusDto;

@Component
public class PaymentDeliveryStatusConverter extends AbstractConverter<PaymentDeliveryStatus, PaymentDeliveryStatusDto, PaymentDeliveryStatusHistory> {


    public  PaymentDeliveryStatusConverter(){
        super(PaymentDeliveryStatus.class, PaymentDeliveryStatusDto.class, PaymentDeliveryStatusHistory.class);
    }

    @Override
    public PaymentDeliveryStatus toItem(PaymentDeliveryStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentDeliveryStatus item = new PaymentDeliveryStatus();
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
    public PaymentDeliveryStatusDto toDto(PaymentDeliveryStatus item) {
        if (item == null) {
            return null;
        } else {
            PaymentDeliveryStatusDto dto = new PaymentDeliveryStatusDto();
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

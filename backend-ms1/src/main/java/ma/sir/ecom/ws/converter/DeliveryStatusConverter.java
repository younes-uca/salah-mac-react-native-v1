package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DeliveryStatusHistory;
import ma.sir.ecom.bean.core.DeliveryStatus;
import ma.sir.ecom.ws.dto.DeliveryStatusDto;

@Component
public class DeliveryStatusConverter extends AbstractConverter<DeliveryStatus, DeliveryStatusDto, DeliveryStatusHistory> {


    public  DeliveryStatusConverter(){
        super(DeliveryStatus.class, DeliveryStatusDto.class, DeliveryStatusHistory.class);
    }

    @Override
    public DeliveryStatus toItem(DeliveryStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        DeliveryStatus item = new DeliveryStatus();
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
    public DeliveryStatusDto toDto(DeliveryStatus item) {
        if (item == null) {
            return null;
        } else {
            DeliveryStatusDto dto = new DeliveryStatusDto();
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

package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.StatusPaymentDemandHistory;
import ma.sir.ecom.bean.core.StatusPaymentDemand;
import ma.sir.ecom.ws.dto.StatusPaymentDemandDto;

@Component
public class StatusPaymentDemandConverter extends AbstractConverter<StatusPaymentDemand, StatusPaymentDemandDto, StatusPaymentDemandHistory> {


    public  StatusPaymentDemandConverter(){
        super(StatusPaymentDemand.class, StatusPaymentDemandDto.class, StatusPaymentDemandHistory.class);
    }

    @Override
    public StatusPaymentDemand toItem(StatusPaymentDemandDto dto) {
        if (dto == null) {
            return null;
        } else {
        StatusPaymentDemand item = new StatusPaymentDemand();
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
    public StatusPaymentDemandDto toDto(StatusPaymentDemand item) {
        if (item == null) {
            return null;
        } else {
            StatusPaymentDemandDto dto = new StatusPaymentDemandDto();
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

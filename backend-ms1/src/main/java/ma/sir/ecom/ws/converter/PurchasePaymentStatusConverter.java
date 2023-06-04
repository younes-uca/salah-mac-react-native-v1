package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PurchasePaymentStatusHistory;
import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import ma.sir.ecom.ws.dto.PurchasePaymentStatusDto;

@Component
public class PurchasePaymentStatusConverter extends AbstractConverter<PurchasePaymentStatus, PurchasePaymentStatusDto, PurchasePaymentStatusHistory> {


    public  PurchasePaymentStatusConverter(){
        super(PurchasePaymentStatus.class, PurchasePaymentStatusDto.class, PurchasePaymentStatusHistory.class);
    }

    @Override
    public PurchasePaymentStatus toItem(PurchasePaymentStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchasePaymentStatus item = new PurchasePaymentStatus();
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
    public PurchasePaymentStatusDto toDto(PurchasePaymentStatus item) {
        if (item == null) {
            return null;
        } else {
            PurchasePaymentStatusDto dto = new PurchasePaymentStatusDto();
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

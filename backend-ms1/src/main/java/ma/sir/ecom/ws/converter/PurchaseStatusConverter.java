package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PurchaseStatusHistory;
import ma.sir.ecom.bean.core.PurchaseStatus;
import ma.sir.ecom.ws.dto.PurchaseStatusDto;

@Component
public class PurchaseStatusConverter extends AbstractConverter<PurchaseStatus, PurchaseStatusDto, PurchaseStatusHistory> {


    public  PurchaseStatusConverter(){
        super(PurchaseStatus.class, PurchaseStatusDto.class, PurchaseStatusHistory.class);
    }

    @Override
    public PurchaseStatus toItem(PurchaseStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        PurchaseStatus item = new PurchaseStatus();
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
    public PurchaseStatusDto toDto(PurchaseStatus item) {
        if (item == null) {
            return null;
        } else {
            PurchaseStatusDto dto = new PurchaseStatusDto();
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

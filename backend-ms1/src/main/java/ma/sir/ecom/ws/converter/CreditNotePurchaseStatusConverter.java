package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CreditNotePurchaseStatusHistory;
import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import ma.sir.ecom.ws.dto.CreditNotePurchaseStatusDto;

@Component
public class CreditNotePurchaseStatusConverter extends AbstractConverter<CreditNotePurchaseStatus, CreditNotePurchaseStatusDto, CreditNotePurchaseStatusHistory> {


    public  CreditNotePurchaseStatusConverter(){
        super(CreditNotePurchaseStatus.class, CreditNotePurchaseStatusDto.class, CreditNotePurchaseStatusHistory.class);
    }

    @Override
    public CreditNotePurchaseStatus toItem(CreditNotePurchaseStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        CreditNotePurchaseStatus item = new CreditNotePurchaseStatus();
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
    public CreditNotePurchaseStatusDto toDto(CreditNotePurchaseStatus item) {
        if (item == null) {
            return null;
        } else {
            CreditNotePurchaseStatusDto dto = new CreditNotePurchaseStatusDto();
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

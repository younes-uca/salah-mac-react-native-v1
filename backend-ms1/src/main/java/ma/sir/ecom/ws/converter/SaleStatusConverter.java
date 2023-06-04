package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SaleStatusHistory;
import ma.sir.ecom.bean.core.SaleStatus;
import ma.sir.ecom.ws.dto.SaleStatusDto;

@Component
public class SaleStatusConverter extends AbstractConverter<SaleStatus, SaleStatusDto, SaleStatusHistory> {


    public  SaleStatusConverter(){
        super(SaleStatus.class, SaleStatusDto.class, SaleStatusHistory.class);
    }

    @Override
    public SaleStatus toItem(SaleStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        SaleStatus item = new SaleStatus();
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
    public SaleStatusDto toDto(SaleStatus item) {
        if (item == null) {
            return null;
        } else {
            SaleStatusDto dto = new SaleStatusDto();
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

package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.DemandStatusHistory;
import ma.sir.ecom.bean.core.DemandStatus;
import ma.sir.ecom.ws.dto.DemandStatusDto;

@Component
public class DemandStatusConverter extends AbstractConverter<DemandStatus, DemandStatusDto, DemandStatusHistory> {


    public  DemandStatusConverter(){
        super(DemandStatus.class, DemandStatusDto.class, DemandStatusHistory.class);
    }

    @Override
    public DemandStatus toItem(DemandStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        DemandStatus item = new DemandStatus();
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
    public DemandStatusDto toDto(DemandStatus item) {
        if (item == null) {
            return null;
        } else {
            DemandStatusDto dto = new DemandStatusDto();
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

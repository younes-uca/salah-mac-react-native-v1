package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReceptionStatusHistory;
import ma.sir.ecom.bean.core.ReceptionStatus;
import ma.sir.ecom.ws.dto.ReceptionStatusDto;

@Component
public class ReceptionStatusConverter extends AbstractConverter<ReceptionStatus, ReceptionStatusDto, ReceptionStatusHistory> {


    public  ReceptionStatusConverter(){
        super(ReceptionStatus.class, ReceptionStatusDto.class, ReceptionStatusHistory.class);
    }

    @Override
    public ReceptionStatus toItem(ReceptionStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReceptionStatus item = new ReceptionStatus();
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
    public ReceptionStatusDto toDto(ReceptionStatus item) {
        if (item == null) {
            return null;
        } else {
            ReceptionStatusDto dto = new ReceptionStatusDto();
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

package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.ReturnStatusHistory;
import ma.sir.ecom.bean.core.ReturnStatus;
import ma.sir.ecom.ws.dto.ReturnStatusDto;

@Component
public class ReturnStatusConverter extends AbstractConverter<ReturnStatus, ReturnStatusDto, ReturnStatusHistory> {


    public  ReturnStatusConverter(){
        super(ReturnStatus.class, ReturnStatusDto.class, ReturnStatusHistory.class);
    }

    @Override
    public ReturnStatus toItem(ReturnStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        ReturnStatus item = new ReturnStatus();
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
    public ReturnStatusDto toDto(ReturnStatus item) {
        if (item == null) {
            return null;
        } else {
            ReturnStatusDto dto = new ReturnStatusDto();
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

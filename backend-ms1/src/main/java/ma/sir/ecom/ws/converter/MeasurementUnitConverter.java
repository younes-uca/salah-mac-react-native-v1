package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.MeasurementUnitHistory;
import ma.sir.ecom.bean.core.MeasurementUnit;
import ma.sir.ecom.ws.dto.MeasurementUnitDto;

@Component
public class MeasurementUnitConverter extends AbstractConverter<MeasurementUnit, MeasurementUnitDto, MeasurementUnitHistory> {


    public  MeasurementUnitConverter(){
        super(MeasurementUnit.class, MeasurementUnitDto.class, MeasurementUnitHistory.class);
    }

    @Override
    public MeasurementUnit toItem(MeasurementUnitDto dto) {
        if (dto == null) {
            return null;
        } else {
        MeasurementUnit item = new MeasurementUnit();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getLibelle()))
                item.setLibelle(dto.getLibelle());
            if(StringUtil.isNotEmpty(dto.getCode()))
                item.setCode(dto.getCode());


        return item;
        }
    }

    @Override
    public MeasurementUnitDto toDto(MeasurementUnit item) {
        if (item == null) {
            return null;
        } else {
            MeasurementUnitDto dto = new MeasurementUnitDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getLibelle()))
                dto.setLibelle(item.getLibelle());
            if(StringUtil.isNotEmpty(item.getCode()))
                dto.setCode(item.getCode());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

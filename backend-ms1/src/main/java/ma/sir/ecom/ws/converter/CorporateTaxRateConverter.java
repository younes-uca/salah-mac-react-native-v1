package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.CorporateTaxRateHistory;
import ma.sir.ecom.bean.core.CorporateTaxRate;
import ma.sir.ecom.ws.dto.CorporateTaxRateDto;

@Component
public class CorporateTaxRateConverter extends AbstractConverter<CorporateTaxRate, CorporateTaxRateDto, CorporateTaxRateHistory> {


    public  CorporateTaxRateConverter(){
        super(CorporateTaxRate.class, CorporateTaxRateDto.class, CorporateTaxRateHistory.class);
    }

    @Override
    public CorporateTaxRate toItem(CorporateTaxRateDto dto) {
        if (dto == null) {
            return null;
        } else {
        CorporateTaxRate item = new CorporateTaxRate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMinimumIncome()))
                item.setMinimumIncome(dto.getMinimumIncome());
            if(StringUtil.isNotEmpty(dto.getMaximumIncome()))
                item.setMaximumIncome(dto.getMaximumIncome());
            if(StringUtil.isNotEmpty(dto.getMinApplicationDate()))
                item.setMinApplicationDate(DateUtil.stringEnToDate(dto.getMinApplicationDate()));
            if(StringUtil.isNotEmpty(dto.getMaxApplicationDate()))
                item.setMaxApplicationDate(DateUtil.stringEnToDate(dto.getMaxApplicationDate()));
            if(StringUtil.isNotEmpty(dto.getPercentage()))
                item.setPercentage(dto.getPercentage());


        return item;
        }
    }

    @Override
    public CorporateTaxRateDto toDto(CorporateTaxRate item) {
        if (item == null) {
            return null;
        } else {
            CorporateTaxRateDto dto = new CorporateTaxRateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getMinimumIncome()))
                dto.setMinimumIncome(item.getMinimumIncome());
            if(StringUtil.isNotEmpty(item.getMaximumIncome()))
                dto.setMaximumIncome(item.getMaximumIncome());
            if(item.getMinApplicationDate()!=null)
                dto.setMinApplicationDate(DateUtil.dateTimeToString(item.getMinApplicationDate()));
            if(item.getMaxApplicationDate()!=null)
                dto.setMaxApplicationDate(DateUtil.dateTimeToString(item.getMaxApplicationDate()));
            if(StringUtil.isNotEmpty(item.getPercentage()))
                dto.setPercentage(item.getPercentage());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

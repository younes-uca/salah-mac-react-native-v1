package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.LatePaymentRateHistory;
import ma.sir.ecom.bean.core.LatePaymentRate;
import ma.sir.ecom.ws.dto.LatePaymentRateDto;

@Component
public class LatePaymentRateConverter extends AbstractConverter<LatePaymentRate, LatePaymentRateDto, LatePaymentRateHistory> {


    public  LatePaymentRateConverter(){
        super(LatePaymentRate.class, LatePaymentRateDto.class, LatePaymentRateHistory.class);
    }

    @Override
    public LatePaymentRate toItem(LatePaymentRateDto dto) {
        if (dto == null) {
            return null;
        } else {
        LatePaymentRate item = new LatePaymentRate();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getMinApplicationDate()))
                item.setMinApplicationDate(DateUtil.stringEnToDate(dto.getMinApplicationDate()));
            if(StringUtil.isNotEmpty(dto.getMaxApplicationDate()))
                item.setMaxApplicationDate(DateUtil.stringEnToDate(dto.getMaxApplicationDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());


        return item;
        }
    }

    @Override
    public LatePaymentRateDto toDto(LatePaymentRate item) {
        if (item == null) {
            return null;
        } else {
            LatePaymentRateDto dto = new LatePaymentRateDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(item.getMinApplicationDate()!=null)
                dto.setMinApplicationDate(DateUtil.dateTimeToString(item.getMinApplicationDate()));
            if(item.getMaxApplicationDate()!=null)
                dto.setMaxApplicationDate(DateUtil.dateTimeToString(item.getMaxApplicationDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

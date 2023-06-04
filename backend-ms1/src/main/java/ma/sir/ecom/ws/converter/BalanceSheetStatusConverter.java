package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.BalanceSheetStatusHistory;
import ma.sir.ecom.bean.core.BalanceSheetStatus;
import ma.sir.ecom.ws.dto.BalanceSheetStatusDto;

@Component
public class BalanceSheetStatusConverter extends AbstractConverter<BalanceSheetStatus, BalanceSheetStatusDto, BalanceSheetStatusHistory> {


    public  BalanceSheetStatusConverter(){
        super(BalanceSheetStatus.class, BalanceSheetStatusDto.class, BalanceSheetStatusHistory.class);
    }

    @Override
    public BalanceSheetStatus toItem(BalanceSheetStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        BalanceSheetStatus item = new BalanceSheetStatus();
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
    public BalanceSheetStatusDto toDto(BalanceSheetStatus item) {
        if (item == null) {
            return null;
        } else {
            BalanceSheetStatusDto dto = new BalanceSheetStatusDto();
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

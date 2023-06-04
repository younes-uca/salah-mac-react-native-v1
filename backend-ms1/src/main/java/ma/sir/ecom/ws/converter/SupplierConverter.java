package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.SupplierHistory;
import ma.sir.ecom.bean.core.Supplier;
import ma.sir.ecom.ws.dto.SupplierDto;

@Component
public class SupplierConverter extends AbstractConverter<Supplier, SupplierDto, SupplierHistory> {


    public  SupplierConverter(){
        super(Supplier.class, SupplierDto.class, SupplierHistory.class);
    }

    @Override
    public Supplier toItem(SupplierDto dto) {
        if (dto == null) {
            return null;
        } else {
        Supplier item = new Supplier();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getIce()))
                item.setIce(dto.getIce());
            if(StringUtil.isNotEmpty(dto.getName()))
                item.setName(dto.getName());
            if(StringUtil.isNotEmpty(dto.getTel()))
                item.setTel(dto.getTel());
            if(StringUtil.isNotEmpty(dto.getEmail()))
                item.setEmail(dto.getEmail());
            if(StringUtil.isNotEmpty(dto.getAddress()))
                item.setAddress(dto.getAddress());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(StringUtil.isNotEmpty(dto.getDebt()))
                item.setDebt(dto.getDebt());


        return item;
        }
    }

    @Override
    public SupplierDto toDto(Supplier item) {
        if (item == null) {
            return null;
        } else {
            SupplierDto dto = new SupplierDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getIce()))
                dto.setIce(item.getIce());
            if(StringUtil.isNotEmpty(item.getName()))
                dto.setName(item.getName());
            if(StringUtil.isNotEmpty(item.getTel()))
                dto.setTel(item.getTel());
            if(StringUtil.isNotEmpty(item.getEmail()))
                dto.setEmail(item.getEmail());
            if(StringUtil.isNotEmpty(item.getAddress()))
                dto.setAddress(item.getAddress());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
            if(StringUtil.isNotEmpty(item.getDebt()))
                dto.setDebt(item.getDebt());


        return dto;
        }
    }


    public void initObject(boolean value) {
    }


}

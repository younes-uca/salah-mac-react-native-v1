package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.OrderStatusHistory;
import ma.sir.ecom.bean.core.OrderStatus;
import ma.sir.ecom.ws.dto.OrderStatusDto;

@Component
public class OrderStatusConverter extends AbstractConverter<OrderStatus, OrderStatusDto, OrderStatusHistory> {


    public  OrderStatusConverter(){
        super(OrderStatus.class, OrderStatusDto.class, OrderStatusHistory.class);
    }

    @Override
    public OrderStatus toItem(OrderStatusDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderStatus item = new OrderStatus();
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
    public OrderStatusDto toDto(OrderStatus item) {
        if (item == null) {
            return null;
        } else {
            OrderStatusDto dto = new OrderStatusDto();
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

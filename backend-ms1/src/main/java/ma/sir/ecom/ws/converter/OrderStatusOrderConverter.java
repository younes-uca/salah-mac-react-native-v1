package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.OrderStatusOrderHistory;
import ma.sir.ecom.bean.core.OrderStatusOrder;
import ma.sir.ecom.ws.dto.OrderStatusOrderDto;

@Component
public class OrderStatusOrderConverter extends AbstractConverter<OrderStatusOrder, OrderStatusOrderDto, OrderStatusOrderHistory> {


    public  OrderStatusOrderConverter(){
        super(OrderStatusOrder.class, OrderStatusOrderDto.class, OrderStatusOrderHistory.class);
    }

    @Override
    public OrderStatusOrder toItem(OrderStatusOrderDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderStatusOrder item = new OrderStatusOrder();
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
    public OrderStatusOrderDto toDto(OrderStatusOrder item) {
        if (item == null) {
            return null;
        } else {
            OrderStatusOrderDto dto = new OrderStatusOrderDto();
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

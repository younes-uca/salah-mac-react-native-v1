package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Order;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.OrderItemHistory;
import ma.sir.ecom.bean.core.OrderItem;
import ma.sir.ecom.ws.dto.OrderItemDto;

@Component
public class OrderItemConverter extends AbstractConverter<OrderItem, OrderItemDto, OrderItemHistory> {

    @Autowired
    private OrderConverter orderConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean product;
    private boolean order;

    public  OrderItemConverter(){
        super(OrderItem.class, OrderItemDto.class, OrderItemHistory.class);
    }

    @Override
    public OrderItem toItem(OrderItemDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderItem item = new OrderItem();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getPrice()))
                item.setPrice(dto.getPrice());
            if(StringUtil.isNotEmpty(dto.getQuantity()))
                item.setQuantity(dto.getQuantity());
            if(StringUtil.isNotEmpty(dto.getQuantityReceived()))
                item.setQuantityReceived(dto.getQuantityReceived());
            if(this.product && dto.getProduct()!=null)
                item.setProduct(productConverter.toItem(dto.getProduct())) ;

            if(dto.getOrder() != null && dto.getOrder().getId() != null){
                item.setOrder(new Order());
                item.getOrder().setId(dto.getOrder().getId());
            }



        return item;
        }
    }

    @Override
    public OrderItemDto toDto(OrderItem item) {
        if (item == null) {
            return null;
        } else {
            OrderItemDto dto = new OrderItemDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getPrice()))
                dto.setPrice(item.getPrice());
            if(StringUtil.isNotEmpty(item.getQuantity()))
                dto.setQuantity(item.getQuantity());
            if(StringUtil.isNotEmpty(item.getQuantityReceived()))
                dto.setQuantityReceived(item.getQuantityReceived());
        if(this.product && item.getProduct()!=null) {
            dto.setProduct(productConverter.toDto(item.getProduct())) ;
        }
        if(this.order && item.getOrder()!=null) {
            dto.setOrder(orderConverter.toDto(item.getOrder())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.product = value;
        this.order = value;
    }


    public OrderConverter getOrderConverter(){
        return this.orderConverter;
    }
    public void setOrderConverter(OrderConverter orderConverter ){
        this.orderConverter = orderConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isProduct(){
        return this.product;
    }
    public void  setProduct(boolean product){
        this.product = product;
    }
    public boolean  isOrder(){
        return this.order;
    }
    public void  setOrder(boolean order){
        this.order = order;
    }
}

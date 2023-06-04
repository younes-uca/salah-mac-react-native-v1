package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ma.sir.ecom.zynerator.util.ListUtil;


import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.OrderHistory;
import ma.sir.ecom.bean.core.Order;
import ma.sir.ecom.ws.dto.OrderDto;

@Component
public class OrderConverter extends AbstractConverter<Order, OrderDto, OrderHistory> {

    @Autowired
    private OrderItemConverter orderItemConverter ;
    @Autowired
    private ClientConverter clientConverter ;
    @Autowired
    private OrderStatusConverter orderStatusConverter ;
    @Autowired
    private ProductConverter productConverter ;
    private boolean client;
    private boolean orderStatus;
    private boolean orderItems;

    public  OrderConverter(){
        super(Order.class, OrderDto.class, OrderHistory.class);
        init(true);
    }

    @Override
    public Order toItem(OrderDto dto) {
        if (dto == null) {
            return null;
        } else {
        Order item = new Order();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getOrderDate()))
                item.setOrderDate(DateUtil.stringEnToDate(dto.getOrderDate()));
            if(StringUtil.isNotEmpty(dto.getTotal()))
                item.setTotal(dto.getTotal());
            if(StringUtil.isNotEmpty(dto.getTotalPaid()))
                item.setTotalPaid(dto.getTotalPaid());
            if(StringUtil.isNotEmpty(dto.getTotalPaidCheck()))
                item.setTotalPaidCheck(dto.getTotalPaidCheck());
            if(StringUtil.isNotEmpty(dto.getTotalPaidCash()))
                item.setTotalPaidCash(dto.getTotalPaidCash());
            if(this.client && dto.getClient()!=null)
                item.setClient(clientConverter.toItem(dto.getClient())) ;

            if(this.orderStatus && dto.getOrderStatus()!=null)
                item.setOrderStatus(orderStatusConverter.toItem(dto.getOrderStatus())) ;


            if(this.orderItems && ListUtil.isNotEmpty(dto.getOrderItems()))
                item.setOrderItems(orderItemConverter.toItem(dto.getOrderItems()));

        return item;
        }
    }

    @Override
    public OrderDto toDto(Order item) {
        if (item == null) {
            return null;
        } else {
            OrderDto dto = new OrderDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getOrderDate()!=null)
                dto.setOrderDate(DateUtil.dateTimeToString(item.getOrderDate()));
            if(StringUtil.isNotEmpty(item.getTotal()))
                dto.setTotal(item.getTotal());
            if(StringUtil.isNotEmpty(item.getTotalPaid()))
                dto.setTotalPaid(item.getTotalPaid());
            if(StringUtil.isNotEmpty(item.getTotalPaidCheck()))
                dto.setTotalPaidCheck(item.getTotalPaidCheck());
            if(StringUtil.isNotEmpty(item.getTotalPaidCash()))
                dto.setTotalPaidCash(item.getTotalPaidCash());
        if(this.client && item.getClient()!=null) {
            dto.setClient(clientConverter.toDto(item.getClient())) ;
        }
        if(this.orderStatus && item.getOrderStatus()!=null) {
            dto.setOrderStatus(orderStatusConverter.toDto(item.getOrderStatus())) ;
        }
        if(this.orderItems && ListUtil.isNotEmpty(item.getOrderItems())){
            orderItemConverter.init(true);
            orderItemConverter.setOrder(false);
            dto.setOrderItems(orderItemConverter.toDto(item.getOrderItems()));
            orderItemConverter.setOrder(true);

        }


        return dto;
        }
    }

    public void initList(boolean value) {
        this.orderItems = value;
    }

    public void initObject(boolean value) {
        this.client = value;
        this.orderStatus = value;
    }


    public OrderItemConverter getOrderItemConverter(){
        return this.orderItemConverter;
    }
    public void setOrderItemConverter(OrderItemConverter orderItemConverter ){
        this.orderItemConverter = orderItemConverter;
    }
    public ClientConverter getClientConverter(){
        return this.clientConverter;
    }
    public void setClientConverter(ClientConverter clientConverter ){
        this.clientConverter = clientConverter;
    }
    public OrderStatusConverter getOrderStatusConverter(){
        return this.orderStatusConverter;
    }
    public void setOrderStatusConverter(OrderStatusConverter orderStatusConverter ){
        this.orderStatusConverter = orderStatusConverter;
    }
    public ProductConverter getProductConverter(){
        return this.productConverter;
    }
    public void setProductConverter(ProductConverter productConverter ){
        this.productConverter = productConverter;
    }
    public boolean  isClient(){
        return this.client;
    }
    public void  setClient(boolean client){
        this.client = client;
    }
    public boolean  isOrderStatus(){
        return this.orderStatus;
    }
    public void  setOrderStatus(boolean orderStatus){
        this.orderStatus = orderStatus;
    }
    public boolean  isOrderItems(){
        return this.orderItems ;
    }
    public void  setOrderItems(boolean orderItems ){
        this.orderItems  = orderItems ;
    }
}

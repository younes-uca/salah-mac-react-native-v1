package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Order;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.OrderPaymentHistory;
import ma.sir.ecom.bean.core.OrderPayment;
import ma.sir.ecom.ws.dto.OrderPaymentDto;

@Component
public class OrderPaymentConverter extends AbstractConverter<OrderPayment, OrderPaymentDto, OrderPaymentHistory> {

    @Autowired
    private OrderConverter orderConverter ;
    @Autowired
    private PaymentModeConverter paymentModeConverter ;
    @Autowired
    private OrderStatusOrderConverter orderStatusOrderConverter ;
    private boolean order;
    private boolean paymentMode;
    private boolean orderStatusOrder;

    public  OrderPaymentConverter(){
        super(OrderPayment.class, OrderPaymentDto.class, OrderPaymentHistory.class);
    }

    @Override
    public OrderPayment toItem(OrderPaymentDto dto) {
        if (dto == null) {
            return null;
        } else {
        OrderPayment item = new OrderPayment();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getPaymentDate()))
                item.setPaymentDate(DateUtil.stringEnToDate(dto.getPaymentDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getVireCheck() != null)
                item.setVireCheck(dto.getVireCheck());
            if(dto.getOrder() != null && dto.getOrder().getId() != null){
                item.setOrder(new Order());
                item.getOrder().setId(dto.getOrder().getId());
            }

            if(this.paymentMode && dto.getPaymentMode()!=null)
                item.setPaymentMode(paymentModeConverter.toItem(dto.getPaymentMode())) ;

            if(this.orderStatusOrder && dto.getOrderStatusOrder()!=null)
                item.setOrderStatusOrder(orderStatusOrderConverter.toItem(dto.getOrderStatusOrder())) ;



        return item;
        }
    }

    @Override
    public OrderPaymentDto toDto(OrderPayment item) {
        if (item == null) {
            return null;
        } else {
            OrderPaymentDto dto = new OrderPaymentDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getPaymentDate()!=null)
                dto.setPaymentDate(DateUtil.dateTimeToString(item.getPaymentDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
                dto.setVireCheck(item.getVireCheck());
        if(this.order && item.getOrder()!=null) {
            dto.setOrder(orderConverter.toDto(item.getOrder())) ;
        }
        if(this.paymentMode && item.getPaymentMode()!=null) {
            dto.setPaymentMode(paymentModeConverter.toDto(item.getPaymentMode())) ;
        }
        if(this.orderStatusOrder && item.getOrderStatusOrder()!=null) {
            dto.setOrderStatusOrder(orderStatusOrderConverter.toDto(item.getOrderStatusOrder())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.order = value;
        this.paymentMode = value;
        this.orderStatusOrder = value;
    }


    public OrderConverter getOrderConverter(){
        return this.orderConverter;
    }
    public void setOrderConverter(OrderConverter orderConverter ){
        this.orderConverter = orderConverter;
    }
    public PaymentModeConverter getPaymentModeConverter(){
        return this.paymentModeConverter;
    }
    public void setPaymentModeConverter(PaymentModeConverter paymentModeConverter ){
        this.paymentModeConverter = paymentModeConverter;
    }
    public OrderStatusOrderConverter getOrderStatusOrderConverter(){
        return this.orderStatusOrderConverter;
    }
    public void setOrderStatusOrderConverter(OrderStatusOrderConverter orderStatusOrderConverter ){
        this.orderStatusOrderConverter = orderStatusOrderConverter;
    }
    public boolean  isOrder(){
        return this.order;
    }
    public void  setOrder(boolean order){
        this.order = order;
    }
    public boolean  isPaymentMode(){
        return this.paymentMode;
    }
    public void  setPaymentMode(boolean paymentMode){
        this.paymentMode = paymentMode;
    }
    public boolean  isOrderStatusOrder(){
        return this.orderStatusOrder;
    }
    public void  setOrderStatusOrder(boolean orderStatusOrder){
        this.orderStatusOrder = orderStatusOrder;
    }
}

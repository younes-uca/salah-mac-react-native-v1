package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Delivery;
import ma.sir.ecom.bean.core.Sale;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentDeliveryHistory;
import ma.sir.ecom.bean.core.PaymentDelivery;
import ma.sir.ecom.ws.dto.PaymentDeliveryDto;

@Component
public class PaymentDeliveryConverter extends AbstractConverter<PaymentDelivery, PaymentDeliveryDto, PaymentDeliveryHistory> {

    @Autowired
    private SaleConverter saleConverter ;
    @Autowired
    private PaymentMethodConverter paymentMethodConverter ;
    @Autowired
    private DeliveryConverter deliveryConverter ;
    @Autowired
    private PaymentDeliveryStatusConverter paymentDeliveryStatusConverter ;
    private boolean delivery;
    private boolean sale;
    private boolean paymentMethod;
    private boolean paymentDeliveryStatus;

    public  PaymentDeliveryConverter(){
        super(PaymentDelivery.class, PaymentDeliveryDto.class, PaymentDeliveryHistory.class);
    }

    @Override
    public PaymentDelivery toItem(PaymentDeliveryDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentDelivery item = new PaymentDelivery();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getReference()))
                item.setReference(dto.getReference());
            if(StringUtil.isNotEmpty(dto.getDeliveryDate()))
                item.setDeliveryDate(DateUtil.stringEnToDate(dto.getDeliveryDate()));
            if(StringUtil.isNotEmpty(dto.getAmount()))
                item.setAmount(dto.getAmount());
            if(StringUtil.isNotEmpty(dto.getDescription()))
                item.setDescription(dto.getDescription());
            if(dto.getDelivery() != null && dto.getDelivery().getId() != null){
                item.setDelivery(new Delivery());
                item.getDelivery().setId(dto.getDelivery().getId());
            }

            if(dto.getSale() != null && dto.getSale().getId() != null){
                item.setSale(new Sale());
                item.getSale().setId(dto.getSale().getId());
            }

            if(this.paymentMethod && dto.getPaymentMethod()!=null)
                item.setPaymentMethod(paymentMethodConverter.toItem(dto.getPaymentMethod())) ;

            if(this.paymentDeliveryStatus && dto.getPaymentDeliveryStatus()!=null)
                item.setPaymentDeliveryStatus(paymentDeliveryStatusConverter.toItem(dto.getPaymentDeliveryStatus())) ;



        return item;
        }
    }

    @Override
    public PaymentDeliveryDto toDto(PaymentDelivery item) {
        if (item == null) {
            return null;
        } else {
            PaymentDeliveryDto dto = new PaymentDeliveryDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getReference()))
                dto.setReference(item.getReference());
            if(item.getDeliveryDate()!=null)
                dto.setDeliveryDate(DateUtil.dateTimeToString(item.getDeliveryDate()));
            if(StringUtil.isNotEmpty(item.getAmount()))
                dto.setAmount(item.getAmount());
            if(StringUtil.isNotEmpty(item.getDescription()))
                dto.setDescription(item.getDescription());
        if(this.delivery && item.getDelivery()!=null) {
            dto.setDelivery(deliveryConverter.toDto(item.getDelivery())) ;
        }
        if(this.sale && item.getSale()!=null) {
            dto.setSale(saleConverter.toDto(item.getSale())) ;
        }
        if(this.paymentMethod && item.getPaymentMethod()!=null) {
            dto.setPaymentMethod(paymentMethodConverter.toDto(item.getPaymentMethod())) ;
        }
        if(this.paymentDeliveryStatus && item.getPaymentDeliveryStatus()!=null) {
            dto.setPaymentDeliveryStatus(paymentDeliveryStatusConverter.toDto(item.getPaymentDeliveryStatus())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.delivery = value;
        this.sale = value;
        this.paymentMethod = value;
        this.paymentDeliveryStatus = value;
    }


    public SaleConverter getSaleConverter(){
        return this.saleConverter;
    }
    public void setSaleConverter(SaleConverter saleConverter ){
        this.saleConverter = saleConverter;
    }
    public PaymentMethodConverter getPaymentMethodConverter(){
        return this.paymentMethodConverter;
    }
    public void setPaymentMethodConverter(PaymentMethodConverter paymentMethodConverter ){
        this.paymentMethodConverter = paymentMethodConverter;
    }
    public DeliveryConverter getDeliveryConverter(){
        return this.deliveryConverter;
    }
    public void setDeliveryConverter(DeliveryConverter deliveryConverter ){
        this.deliveryConverter = deliveryConverter;
    }
    public PaymentDeliveryStatusConverter getPaymentDeliveryStatusConverter(){
        return this.paymentDeliveryStatusConverter;
    }
    public void setPaymentDeliveryStatusConverter(PaymentDeliveryStatusConverter paymentDeliveryStatusConverter ){
        this.paymentDeliveryStatusConverter = paymentDeliveryStatusConverter;
    }
    public boolean  isDelivery(){
        return this.delivery;
    }
    public void  setDelivery(boolean delivery){
        this.delivery = delivery;
    }
    public boolean  isSale(){
        return this.sale;
    }
    public void  setSale(boolean sale){
        this.sale = sale;
    }
    public boolean  isPaymentMethod(){
        return this.paymentMethod;
    }
    public void  setPaymentMethod(boolean paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public boolean  isPaymentDeliveryStatus(){
        return this.paymentDeliveryStatus;
    }
    public void  setPaymentDeliveryStatus(boolean paymentDeliveryStatus){
        this.paymentDeliveryStatus = paymentDeliveryStatus;
    }
}

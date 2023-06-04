package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Sale;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentSaleHistory;
import ma.sir.ecom.bean.core.PaymentSale;
import ma.sir.ecom.ws.dto.PaymentSaleDto;

@Component
public class PaymentSaleConverter extends AbstractConverter<PaymentSale, PaymentSaleDto, PaymentSaleHistory> {

    @Autowired
    private SaleConverter saleConverter ;
    @Autowired
    private PaymentMethodConverter paymentMethodConverter ;
    @Autowired
    private PaymentStatusConverter paymentStatusConverter ;
    private boolean sale;
    private boolean paymentMethod;
    private boolean paymentStatus;

    public  PaymentSaleConverter(){
        super(PaymentSale.class, PaymentSaleDto.class, PaymentSaleHistory.class);
    }

    @Override
    public PaymentSale toItem(PaymentSaleDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentSale item = new PaymentSale();
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
            if(dto.getSale() != null && dto.getSale().getId() != null){
                item.setSale(new Sale());
                item.getSale().setId(dto.getSale().getId());
            }

            if(this.paymentMethod && dto.getPaymentMethod()!=null)
                item.setPaymentMethod(paymentMethodConverter.toItem(dto.getPaymentMethod())) ;

            if(this.paymentStatus && dto.getPaymentStatus()!=null)
                item.setPaymentStatus(paymentStatusConverter.toItem(dto.getPaymentStatus())) ;



        return item;
        }
    }

    @Override
    public PaymentSaleDto toDto(PaymentSale item) {
        if (item == null) {
            return null;
        } else {
            PaymentSaleDto dto = new PaymentSaleDto();
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
        if(this.sale && item.getSale()!=null) {
            dto.setSale(saleConverter.toDto(item.getSale())) ;
        }
        if(this.paymentMethod && item.getPaymentMethod()!=null) {
            dto.setPaymentMethod(paymentMethodConverter.toDto(item.getPaymentMethod())) ;
        }
        if(this.paymentStatus && item.getPaymentStatus()!=null) {
            dto.setPaymentStatus(paymentStatusConverter.toDto(item.getPaymentStatus())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.sale = value;
        this.paymentMethod = value;
        this.paymentStatus = value;
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
    public PaymentStatusConverter getPaymentStatusConverter(){
        return this.paymentStatusConverter;
    }
    public void setPaymentStatusConverter(PaymentStatusConverter paymentStatusConverter ){
        this.paymentStatusConverter = paymentStatusConverter;
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
    public boolean  isPaymentStatus(){
        return this.paymentStatus;
    }
    public void  setPaymentStatus(boolean paymentStatus){
        this.paymentStatus = paymentStatus;
    }
}

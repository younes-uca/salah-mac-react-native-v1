package  ma.sir.ecom.ws.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.sir.ecom.bean.core.Purchase;

import ma.sir.ecom.zynerator.util.StringUtil;
import ma.sir.ecom.zynerator.converter.AbstractConverter;
import ma.sir.ecom.zynerator.util.DateUtil;
import ma.sir.ecom.bean.history.PaymentPurchaseHistory;
import ma.sir.ecom.bean.core.PaymentPurchase;
import ma.sir.ecom.ws.dto.PaymentPurchaseDto;

@Component
public class PaymentPurchaseConverter extends AbstractConverter<PaymentPurchase, PaymentPurchaseDto, PaymentPurchaseHistory> {

    @Autowired
    private PurchaseConverter purchaseConverter ;
    @Autowired
    private PaymentModeConverter paymentModeConverter ;
    @Autowired
    private PurchasePaymentStatusConverter purchasePaymentStatusConverter ;
    private boolean purchase;
    private boolean paymentMode;
    private boolean purchasePaymentStatus;

    public  PaymentPurchaseConverter(){
        super(PaymentPurchase.class, PaymentPurchaseDto.class, PaymentPurchaseHistory.class);
    }

    @Override
    public PaymentPurchase toItem(PaymentPurchaseDto dto) {
        if (dto == null) {
            return null;
        } else {
        PaymentPurchase item = new PaymentPurchase();
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
            if(dto.getPurchase() != null && dto.getPurchase().getId() != null){
                item.setPurchase(new Purchase());
                item.getPurchase().setId(dto.getPurchase().getId());
            }

            if(this.paymentMode && dto.getPaymentMode()!=null)
                item.setPaymentMode(paymentModeConverter.toItem(dto.getPaymentMode())) ;

            if(this.purchasePaymentStatus && dto.getPurchasePaymentStatus()!=null)
                item.setPurchasePaymentStatus(purchasePaymentStatusConverter.toItem(dto.getPurchasePaymentStatus())) ;



        return item;
        }
    }

    @Override
    public PaymentPurchaseDto toDto(PaymentPurchase item) {
        if (item == null) {
            return null;
        } else {
            PaymentPurchaseDto dto = new PaymentPurchaseDto();
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
        if(this.purchase && item.getPurchase()!=null) {
            dto.setPurchase(purchaseConverter.toDto(item.getPurchase())) ;
        }
        if(this.paymentMode && item.getPaymentMode()!=null) {
            dto.setPaymentMode(paymentModeConverter.toDto(item.getPaymentMode())) ;
        }
        if(this.purchasePaymentStatus && item.getPurchasePaymentStatus()!=null) {
            dto.setPurchasePaymentStatus(purchasePaymentStatusConverter.toDto(item.getPurchasePaymentStatus())) ;
        }


        return dto;
        }
    }


    public void initObject(boolean value) {
        this.purchase = value;
        this.paymentMode = value;
        this.purchasePaymentStatus = value;
    }


    public PurchaseConverter getPurchaseConverter(){
        return this.purchaseConverter;
    }
    public void setPurchaseConverter(PurchaseConverter purchaseConverter ){
        this.purchaseConverter = purchaseConverter;
    }
    public PaymentModeConverter getPaymentModeConverter(){
        return this.paymentModeConverter;
    }
    public void setPaymentModeConverter(PaymentModeConverter paymentModeConverter ){
        this.paymentModeConverter = paymentModeConverter;
    }
    public PurchasePaymentStatusConverter getPurchasePaymentStatusConverter(){
        return this.purchasePaymentStatusConverter;
    }
    public void setPurchasePaymentStatusConverter(PurchasePaymentStatusConverter purchasePaymentStatusConverter ){
        this.purchasePaymentStatusConverter = purchasePaymentStatusConverter;
    }
    public boolean  isPurchase(){
        return this.purchase;
    }
    public void  setPurchase(boolean purchase){
        this.purchase = purchase;
    }
    public boolean  isPaymentMode(){
        return this.paymentMode;
    }
    public void  setPaymentMode(boolean paymentMode){
        this.paymentMode = paymentMode;
    }
    public boolean  isPurchasePaymentStatus(){
        return this.purchasePaymentStatus;
    }
    public void  setPurchasePaymentStatus(boolean purchasePaymentStatus){
        this.purchasePaymentStatus = purchasePaymentStatus;
    }
}

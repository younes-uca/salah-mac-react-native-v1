package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDeliveryDto  extends AuditBaseDto {

    private String reference  ;
    private String deliveryDate ;
    private BigDecimal amount  ;
    private String description  ;

    private DeliveryDto delivery ;
    private SaleDto sale ;
    private PaymentMethodDto paymentMethod ;
    private PaymentDeliveryStatusDto paymentDeliveryStatus ;



    public PaymentDeliveryDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate){
        this.deliveryDate = deliveryDate;
    }

    @Log
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public DeliveryDto getDelivery(){
        return this.delivery;
    }

    public void setDelivery(DeliveryDto delivery){
        this.delivery = delivery;
    }
    public SaleDto getSale(){
        return this.sale;
    }

    public void setSale(SaleDto sale){
        this.sale = sale;
    }
    public PaymentMethodDto getPaymentMethod(){
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodDto paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public PaymentDeliveryStatusDto getPaymentDeliveryStatus(){
        return this.paymentDeliveryStatus;
    }

    public void setPaymentDeliveryStatus(PaymentDeliveryStatusDto paymentDeliveryStatus){
        this.paymentDeliveryStatus = paymentDeliveryStatus;
    }




}

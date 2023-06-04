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
public class PaymentSaleDto  extends AuditBaseDto {

    private String reference  ;
    private String paymentDate ;
    private BigDecimal amount  ;
    private String description  ;

    private SaleDto sale ;
    private PaymentMethodDto paymentMethod ;
    private PaymentStatusDto paymentStatus ;



    public PaymentSaleDto(){
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
    public String getPaymentDate(){
        return this.paymentDate;
    }
    public void setPaymentDate(String paymentDate){
        this.paymentDate = paymentDate;
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
    public PaymentStatusDto getPaymentStatus(){
        return this.paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusDto paymentStatus){
        this.paymentStatus = paymentStatus;
    }




}

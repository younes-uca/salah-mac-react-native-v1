package ma.sir.ecom.bean.core;

import java.util.Objects;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "payment_delivery")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_delivery_seq",sequenceName="payment_delivery_seq",allocationSize=1, initialValue = 1)
public class PaymentDelivery   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime deliveryDate ;
    private BigDecimal amount = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Delivery delivery ;
    
    private Sale sale ;
    
    private PaymentMethod paymentMethod ;
    
    private PaymentDeliveryStatus paymentDeliveryStatus ;
    


    public PaymentDelivery(){
        super();
    }

    public PaymentDelivery(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_delivery_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Delivery getDelivery(){
        return this.delivery;
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Sale getSale(){
        return this.sale;
    }
    public void setSale(Sale sale){
        this.sale = sale;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }
    public void setPaymentMethod(PaymentMethod paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PaymentDeliveryStatus getPaymentDeliveryStatus(){
        return this.paymentDeliveryStatus;
    }
    public void setPaymentDeliveryStatus(PaymentDeliveryStatus paymentDeliveryStatus){
        this.paymentDeliveryStatus = paymentDeliveryStatus;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDelivery paymentDelivery = (PaymentDelivery) o;
        return id != null && id.equals(paymentDelivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


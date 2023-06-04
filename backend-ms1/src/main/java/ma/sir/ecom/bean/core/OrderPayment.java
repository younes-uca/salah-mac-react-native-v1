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
@Table(name = "order_payment")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="order_payment_seq",sequenceName="order_payment_seq",allocationSize=1, initialValue = 1)
public class OrderPayment   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime paymentDate ;
    private BigDecimal amount = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;
    @Column(columnDefinition = "boolean default false")
    private Boolean vireCheck = false;

    private Order order ;
    
    private PaymentMode paymentMode ;
    
    private OrderStatusOrder orderStatusOrder ;
    


    public OrderPayment(){
        super();
    }

    public OrderPayment(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="order_payment_seq")
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
    public LocalDateTime getPaymentDate(){
        return this.paymentDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate){
        this.paymentDate = paymentDate;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order){
        this.order = order;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public PaymentMode getPaymentMode(){
        return this.paymentMode;
    }
    public void setPaymentMode(PaymentMode paymentMode){
        this.paymentMode = paymentMode;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Boolean  getVireCheck(){
        return this.vireCheck;
    }
    public void setVireCheck(Boolean vireCheck){
        this.vireCheck = vireCheck;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public OrderStatusOrder getOrderStatusOrder(){
        return this.orderStatusOrder;
    }
    public void setOrderStatusOrder(OrderStatusOrder orderStatusOrder){
        this.orderStatusOrder = orderStatusOrder;
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
        OrderPayment orderPayment = (OrderPayment) o;
        return id != null && id.equals(orderPayment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


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
@Table(name = "payment_purchase")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_purchase_seq",sequenceName="payment_purchase_seq",allocationSize=1, initialValue = 1)
public class PaymentPurchase   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime paymentDate ;
    private BigDecimal amount = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Purchase purchase ;
    
    private PaymentMode paymentMode ;
    
    private PurchasePaymentStatus purchasePaymentStatus ;
    


    public PaymentPurchase(){
        super();
    }

    public PaymentPurchase(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_purchase_seq")
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
    public Purchase getPurchase(){
        return this.purchase;
    }
    public void setPurchase(Purchase purchase){
        this.purchase = purchase;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public PurchasePaymentStatus getPurchasePaymentStatus(){
        return this.purchasePaymentStatus;
    }
    public void setPurchasePaymentStatus(PurchasePaymentStatus purchasePaymentStatus){
        this.purchasePaymentStatus = purchasePaymentStatus;
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
        PaymentPurchase paymentPurchase = (PaymentPurchase) o;
        return id != null && id.equals(paymentPurchase.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


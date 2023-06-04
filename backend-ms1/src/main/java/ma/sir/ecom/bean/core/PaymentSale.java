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
@Table(name = "payment_sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="payment_sale_seq",sequenceName="payment_sale_seq",allocationSize=1, initialValue = 1)
public class PaymentSale   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime paymentDate ;
    private BigDecimal amount = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Sale sale ;
    
    private PaymentMethod paymentMethod ;
    
    private PaymentStatus paymentStatus ;
    


    public PaymentSale(){
        super();
    }

    public PaymentSale(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="payment_sale_seq")
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
    public PaymentStatus getPaymentStatus(){
        return this.paymentStatus;
    }
    public void setPaymentStatus(PaymentStatus paymentStatus){
        this.paymentStatus = paymentStatus;
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
        PaymentSale paymentSale = (PaymentSale) o;
        return id != null && id.equals(paymentSale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


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
@Table(name = "late_payment_rate")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="late_payment_rate_seq",sequenceName="late_payment_rate_seq",allocationSize=1, initialValue = 1)
public class LatePaymentRate   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime minApplicationDate ;
    private LocalDateTime maxApplicationDate ;
    private BigDecimal amount = BigDecimal.ZERO;



    public LatePaymentRate(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="late_payment_rate_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getMinApplicationDate(){
        return this.minApplicationDate;
    }
    public void setMinApplicationDate(LocalDateTime minApplicationDate){
        this.minApplicationDate = minApplicationDate;
    }
    public LocalDateTime getMaxApplicationDate(){
        return this.maxApplicationDate;
    }
    public void setMaxApplicationDate(LocalDateTime maxApplicationDate){
        this.maxApplicationDate = maxApplicationDate;
    }
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatePaymentRate latePaymentRate = (LatePaymentRate) o;
        return id != null && id.equals(latePaymentRate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


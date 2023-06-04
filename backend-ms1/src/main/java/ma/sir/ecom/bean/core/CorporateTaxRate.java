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
@Table(name = "corporate_tax_rate")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="corporate_tax_rate_seq",sequenceName="corporate_tax_rate_seq",allocationSize=1, initialValue = 1)
public class CorporateTaxRate   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal minimumIncome = BigDecimal.ZERO;
    private BigDecimal maximumIncome = BigDecimal.ZERO;
    private LocalDateTime minApplicationDate ;
    private LocalDateTime maxApplicationDate ;
    private BigDecimal percentage = BigDecimal.ZERO;



    public CorporateTaxRate(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="corporate_tax_rate_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getMinimumIncome(){
        return this.minimumIncome;
    }
    public void setMinimumIncome(BigDecimal minimumIncome){
        this.minimumIncome = minimumIncome;
    }
    public BigDecimal getMaximumIncome(){
        return this.maximumIncome;
    }
    public void setMaximumIncome(BigDecimal maximumIncome){
        this.maximumIncome = maximumIncome;
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
    public BigDecimal getPercentage(){
        return this.percentage;
    }
    public void setPercentage(BigDecimal percentage){
        this.percentage = percentage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CorporateTaxRate corporateTaxRate = (CorporateTaxRate) o;
        return id != null && id.equals(corporateTaxRate.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


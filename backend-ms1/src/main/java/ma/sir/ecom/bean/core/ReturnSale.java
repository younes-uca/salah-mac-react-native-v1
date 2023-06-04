package ma.sir.ecom.bean.core;

import java.util.Objects;
import java.util.List;

import java.time.LocalDateTime;


import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;



import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "return_sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="return_sale_seq",sequenceName="return_sale_seq",allocationSize=1, initialValue = 1)
public class ReturnSale   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime returnDate ;
    private BigDecimal amount = BigDecimal.ZERO;

    private Sale sale ;
    
    private ReturnStatus returnStatus ;
    

    private List<ReturnSaleItem> returnSaleItems ;

    public ReturnSale(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="return_sale_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public LocalDateTime getReturnDate(){
        return this.returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate){
        this.returnDate = returnDate;
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
    @OneToMany(mappedBy = "returnSale")
    public List<ReturnSaleItem> getReturnSaleItems(){
        return this.returnSaleItems;
    }
    public void setReturnSaleItems(List<ReturnSaleItem> returnSaleItems){
        this.returnSaleItems = returnSaleItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ReturnStatus getReturnStatus(){
        return this.returnStatus;
    }
    public void setReturnStatus(ReturnStatus returnStatus){
        this.returnStatus = returnStatus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnSale returnSale = (ReturnSale) o;
        return id != null && id.equals(returnSale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "demand_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_item_seq",sequenceName="demand_item_seq",allocationSize=1, initialValue = 1)
public class DemandItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal price = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal poundQuantity = BigDecimal.ZERO;

    private Product product ;
    
    private Demand demand ;
    


    public DemandItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public void setPrice(BigDecimal price){
        this.price = price;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    public BigDecimal getPoundQuantity(){
        return this.poundQuantity;
    }
    public void setPoundQuantity(BigDecimal poundQuantity){
        this.poundQuantity = poundQuantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Demand getDemand(){
        return this.demand;
    }
    public void setDemand(Demand demand){
        this.demand = demand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemandItem demandItem = (DemandItem) o;
        return id != null && id.equals(demandItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


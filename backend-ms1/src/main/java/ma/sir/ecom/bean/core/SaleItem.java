package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "sale_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sale_item_seq",sequenceName="sale_item_seq",allocationSize=1, initialValue = 1)
public class SaleItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal unitPrice = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;
    private BigDecimal quantityReturned = BigDecimal.ZERO;

    private Product product ;
    
    private Sale sale ;
    


    public SaleItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sale_item_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Product getProduct(){
        return this.product;
    }
    public void setProduct(Product product){
        this.product = product;
    }
    public BigDecimal getUnitPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(BigDecimal unitPrice){
        this.unitPrice = unitPrice;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    public BigDecimal getDiscount(){
        return this.discount;
    }
    public void setDiscount(BigDecimal discount){
        this.discount = discount;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Sale getSale(){
        return this.sale;
    }
    public void setSale(Sale sale){
        this.sale = sale;
    }
    public BigDecimal getQuantityReturned(){
        return this.quantityReturned;
    }
    public void setQuantityReturned(BigDecimal quantityReturned){
        this.quantityReturned = quantityReturned;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleItem saleItem = (SaleItem) o;
        return id != null && id.equals(saleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


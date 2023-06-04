package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "product_stock")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="product_stock_seq",sequenceName="product_stock_seq",allocationSize=1, initialValue = 1)
public class ProductStock   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal defectiveQuantity = BigDecimal.ZERO;

    private Shop shop ;
    
    private Product product ;
    


    public ProductStock(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="product_stock_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Shop getShop(){
        return this.shop;
    }
    public void setShop(Shop shop){
        this.shop = shop;
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
    public BigDecimal getDefectiveQuantity(){
        return this.defectiveQuantity;
    }
    public void setDefectiveQuantity(BigDecimal defectiveQuantity){
        this.defectiveQuantity = defectiveQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStock productStock = (ProductStock) o;
        return id != null && id.equals(productStock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


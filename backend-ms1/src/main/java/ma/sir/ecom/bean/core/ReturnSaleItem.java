package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "return_sale_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="return_sale_item_seq",sequenceName="return_sale_item_seq",allocationSize=1, initialValue = 1)
public class ReturnSaleItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal returnAmount = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;

    private Product product ;
    
    private ReturnSale returnSale ;
    


    public ReturnSaleItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="return_sale_item_seq")
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
    public BigDecimal getReturnAmount(){
        return this.returnAmount;
    }
    public void setReturnAmount(BigDecimal returnAmount){
        this.returnAmount = returnAmount;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ReturnSale getReturnSale(){
        return this.returnSale;
    }
    public void setReturnSale(ReturnSale returnSale){
        this.returnSale = returnSale;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnSaleItem returnSaleItem = (ReturnSaleItem) o;
        return id != null && id.equals(returnSaleItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


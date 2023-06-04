package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "delivery_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="delivery_item_seq",sequenceName="delivery_item_seq",allocationSize=1, initialValue = 1)
public class DeliveryItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal quantity = BigDecimal.ZERO;

    private Product product ;
    
    private Store store ;
    
    private Delivery delivery ;
    


    public DeliveryItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="delivery_item_seq")
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Delivery getDelivery(){
        return this.delivery;
    }
    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeliveryItem deliveryItem = (DeliveryItem) o;
        return id != null && id.equals(deliveryItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


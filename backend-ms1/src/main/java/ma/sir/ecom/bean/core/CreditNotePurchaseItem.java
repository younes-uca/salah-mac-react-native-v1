package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "credit_note_purchase_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="credit_note_purchase_item_seq",sequenceName="credit_note_purchase_item_seq",allocationSize=1, initialValue = 1)
public class CreditNotePurchaseItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal amount = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;

    private Product product ;
    
    private CreditNotePurchase creditNotePurchase ;
    


    public CreditNotePurchaseItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="credit_note_purchase_item_seq")
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
    public BigDecimal getAmount(){
        return this.amount;
    }
    public void setAmount(BigDecimal amount){
        this.amount = amount;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public void setQuantity(BigDecimal quantity){
        this.quantity = quantity;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public CreditNotePurchase getCreditNotePurchase(){
        return this.creditNotePurchase;
    }
    public void setCreditNotePurchase(CreditNotePurchase creditNotePurchase){
        this.creditNotePurchase = creditNotePurchase;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditNotePurchaseItem creditNotePurchaseItem = (CreditNotePurchaseItem) o;
        return id != null && id.equals(creditNotePurchaseItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


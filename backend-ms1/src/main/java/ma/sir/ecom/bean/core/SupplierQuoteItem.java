package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "supplier_quote_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="supplier_quote_item_seq",sequenceName="supplier_quote_item_seq",allocationSize=1, initialValue = 1)
public class SupplierQuoteItem   extends AuditBusinessObject     {

    private Long id;

    private BigDecimal unitPrice = BigDecimal.ZERO;
    private BigDecimal quantity = BigDecimal.ZERO;
    private BigDecimal discount = BigDecimal.ZERO;

    private Product product ;
    
    private SupplierQuote supplierQuote ;
    


    public SupplierQuoteItem(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="supplier_quote_item_seq")
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
    public SupplierQuote getSupplierQuote(){
        return this.supplierQuote;
    }
    public void setSupplierQuote(SupplierQuote supplierQuote){
        this.supplierQuote = supplierQuote;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierQuoteItem supplierQuoteItem = (SupplierQuoteItem) o;
        return id != null && id.equals(supplierQuoteItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


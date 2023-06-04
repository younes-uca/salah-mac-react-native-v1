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
@Table(name = "supplier_quote")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="supplier_quote_seq",sequenceName="supplier_quote_seq",allocationSize=1, initialValue = 1)
public class SupplierQuote   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime quoteDate ;
    private BigDecimal total = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Supplier supplier ;
    

    private List<SupplierQuoteItem> supplierQuoteItems ;

    public SupplierQuote(){
        super();
    }

    public SupplierQuote(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="supplier_quote_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getQuoteDate(){
        return this.quoteDate;
    }
    public void setQuoteDate(LocalDateTime quoteDate){
        this.quoteDate = quoteDate;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Supplier getSupplier(){
        return this.supplier;
    }
    public void setSupplier(Supplier supplier){
        this.supplier = supplier;
    }
    @OneToMany(mappedBy = "supplierQuote")
    public List<SupplierQuoteItem> getSupplierQuoteItems(){
        return this.supplierQuoteItems;
    }
    public void setSupplierQuoteItems(List<SupplierQuoteItem> supplierQuoteItems){
        this.supplierQuoteItems = supplierQuoteItems;
    }

    @Transient
    public String getLabel() {
        label = reference;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SupplierQuote supplierQuote = (SupplierQuote) o;
        return id != null && id.equals(supplierQuote.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


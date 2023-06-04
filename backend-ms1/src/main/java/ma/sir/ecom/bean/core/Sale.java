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
@Table(name = "sale")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="sale_seq",sequenceName="sale_seq",allocationSize=1, initialValue = 1)
public class Sale   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime saleDate ;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalPaid = BigDecimal.ZERO;
    @Column(length = 500)
    private String description;

    private Store store ;
    
    private Client client ;
    
    private SaleStatus saleStatus ;
    

    private List<SaleItem> saleItems ;

    public Sale(){
        super();
    }

    public Sale(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sale_seq")
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
    public LocalDateTime getSaleDate(){
        return this.saleDate;
    }
    public void setSaleDate(LocalDateTime saleDate){
        this.saleDate = saleDate;
    }
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }
    public BigDecimal getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(BigDecimal totalPaid){
        this.totalPaid = totalPaid;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Store getStore(){
        return this.store;
    }
    public void setStore(Store store){
        this.store = store;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "sale")
    public List<SaleItem> getSaleItems(){
        return this.saleItems;
    }
    public void setSaleItems(List<SaleItem> saleItems){
        this.saleItems = saleItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public SaleStatus getSaleStatus(){
        return this.saleStatus;
    }
    public void setSaleStatus(SaleStatus saleStatus){
        this.saleStatus = saleStatus;
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
        Sale sale = (Sale) o;
        return id != null && id.equals(sale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


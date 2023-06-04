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
@Table(name = "demand")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="demand_seq",sequenceName="demand_seq",allocationSize=1, initialValue = 1)
public class Demand   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime demandDate ;
    private BigDecimal totalCheck = BigDecimal.ZERO;
    private BigDecimal totalCash = BigDecimal.ZERO;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal totalPaid = BigDecimal.ZERO;

    private Client client ;
    
    private DemandStatus demandStatus ;
    

    private List<DemandItem> demandItems ;

    public Demand(){
        super();
    }

    public Demand(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="demand_seq")
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
    public LocalDateTime getDemandDate(){
        return this.demandDate;
    }
    public void setDemandDate(LocalDateTime demandDate){
        this.demandDate = demandDate;
    }
    public BigDecimal getTotalCheck(){
        return this.totalCheck;
    }
    public void setTotalCheck(BigDecimal totalCheck){
        this.totalCheck = totalCheck;
    }
    public BigDecimal getTotalCash(){
        return this.totalCash;
    }
    public void setTotalCash(BigDecimal totalCash){
        this.totalCash = totalCash;
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
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }
    @OneToMany(mappedBy = "demand")
    public List<DemandItem> getDemandItems(){
        return this.demandItems;
    }
    public void setDemandItems(List<DemandItem> demandItems){
        this.demandItems = demandItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DemandStatus getDemandStatus(){
        return this.demandStatus;
    }
    public void setDemandStatus(DemandStatus demandStatus){
        this.demandStatus = demandStatus;
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
        Demand demand = (Demand) o;
        return id != null && id.equals(demand.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


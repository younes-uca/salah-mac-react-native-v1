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




@Entity
@Table(name = "delivery")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="delivery_seq",sequenceName="delivery_seq",allocationSize=1, initialValue = 1)
public class Delivery   extends AuditBusinessObject     {

    private Long id;

    private LocalDateTime deliveryDate ;

    private Demand demand ;
    
    private DeliveryStatus deliveryStatus ;
    
    private Client client ;
    

    private List<DeliveryItem> deliveryItems ;

    public Delivery(){
        super();
    }





    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="delivery_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Demand getDemand(){
        return this.demand;
    }
    public void setDemand(Demand demand){
        this.demand = demand;
    }
    public LocalDateTime getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public DeliveryStatus getDeliveryStatus(){
        return this.deliveryStatus;
    }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
    @OneToMany(mappedBy = "delivery")
    public List<DeliveryItem> getDeliveryItems(){
        return this.deliveryItems;
    }
    public void setDeliveryItems(List<DeliveryItem> deliveryItems){
        this.deliveryItems = deliveryItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient(){
        return this.client;
    }
    public void setClient(Client client){
        this.client = client;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id != null && id.equals(delivery.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


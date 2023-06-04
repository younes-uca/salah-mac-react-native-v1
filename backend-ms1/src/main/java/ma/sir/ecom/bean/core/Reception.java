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
@Table(name = "reception")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="reception_seq",sequenceName="reception_seq",allocationSize=1, initialValue = 1)
public class Reception   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String reference;
    private LocalDateTime receptionDate ;
    @Column(length = 500)
    private String description;

    private Order order ;
    
    private ReceptionStatus receptionStatus ;
    

    private List<ReceptionItem> receptionItems ;

    public Reception(){
        super();
    }

    public Reception(Long id,String reference){
        this.id = id;
        this.reference = reference ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="reception_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Order getOrder(){
        return this.order;
    }
    public void setOrder(Order order){
        this.order = order;
    }
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public LocalDateTime getReceptionDate(){
        return this.receptionDate;
    }
    public void setReceptionDate(LocalDateTime receptionDate){
        this.receptionDate = receptionDate;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    @OneToMany(mappedBy = "reception")
    public List<ReceptionItem> getReceptionItems(){
        return this.receptionItems;
    }
    public void setReceptionItems(List<ReceptionItem> receptionItems){
        this.receptionItems = receptionItems;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public ReceptionStatus getReceptionStatus(){
        return this.receptionStatus;
    }
    public void setReceptionStatus(ReceptionStatus receptionStatus){
        this.receptionStatus = receptionStatus;
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
        Reception reception = (Reception) o;
        return id != null && id.equals(reception.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


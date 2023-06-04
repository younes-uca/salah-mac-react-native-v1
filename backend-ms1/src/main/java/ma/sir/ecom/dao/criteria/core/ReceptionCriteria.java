package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReceptionCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime receptionDate;
    private LocalDateTime receptionDateFrom;
    private LocalDateTime receptionDateTo;
    private String description;
    private String descriptionLike;

    private OrderCriteria order ;
    private List<OrderCriteria> orders ;
    private ReceptionStatusCriteria receptionStatus ;
    private List<ReceptionStatusCriteria> receptionStatuss ;


    public ReceptionCriteria(){}

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }

    public LocalDateTime getReceptionDate(){
        return this.receptionDate;
    }
    public void setReceptionDate(LocalDateTime receptionDate){
        this.receptionDate = receptionDate;
    }
    public LocalDateTime getReceptionDateFrom(){
        return this.receptionDateFrom;
    }
    public void setReceptionDateFrom(LocalDateTime receptionDateFrom){
        this.receptionDateFrom = receptionDateFrom;
    }
    public LocalDateTime getReceptionDateTo(){
        return this.receptionDateTo;
    }
    public void setReceptionDateTo(LocalDateTime receptionDateTo){
        this.receptionDateTo = receptionDateTo;
    }
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }


    public OrderCriteria getOrder(){
        return this.order;
    }

    public void setOrder(OrderCriteria order){
        this.order = order;
    }
    public List<OrderCriteria> getOrders(){
        return this.orders;
    }

    public void setOrders(List<OrderCriteria> orders){
        this.orders = orders;
    }
    public ReceptionStatusCriteria getReceptionStatus(){
        return this.receptionStatus;
    }

    public void setReceptionStatus(ReceptionStatusCriteria receptionStatus){
        this.receptionStatus = receptionStatus;
    }
    public List<ReceptionStatusCriteria> getReceptionStatuss(){
        return this.receptionStatuss;
    }

    public void setReceptionStatuss(List<ReceptionStatusCriteria> receptionStatuss){
        this.receptionStatuss = receptionStatuss;
    }
}

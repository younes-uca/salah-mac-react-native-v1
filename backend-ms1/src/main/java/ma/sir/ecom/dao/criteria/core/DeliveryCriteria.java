package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DeliveryCriteria extends  BaseCriteria  {

    private LocalDateTime deliveryDate;
    private LocalDateTime deliveryDateFrom;
    private LocalDateTime deliveryDateTo;

    private DemandCriteria demand ;
    private List<DemandCriteria> demands ;
    private DeliveryStatusCriteria deliveryStatus ;
    private List<DeliveryStatusCriteria> deliveryStatuss ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;


    public DeliveryCriteria(){}

    public LocalDateTime getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    public LocalDateTime getDeliveryDateFrom(){
        return this.deliveryDateFrom;
    }
    public void setDeliveryDateFrom(LocalDateTime deliveryDateFrom){
        this.deliveryDateFrom = deliveryDateFrom;
    }
    public LocalDateTime getDeliveryDateTo(){
        return this.deliveryDateTo;
    }
    public void setDeliveryDateTo(LocalDateTime deliveryDateTo){
        this.deliveryDateTo = deliveryDateTo;
    }

    public DemandCriteria getDemand(){
        return this.demand;
    }

    public void setDemand(DemandCriteria demand){
        this.demand = demand;
    }
    public List<DemandCriteria> getDemands(){
        return this.demands;
    }

    public void setDemands(List<DemandCriteria> demands){
        this.demands = demands;
    }
    public DeliveryStatusCriteria getDeliveryStatus(){
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusCriteria deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
    public List<DeliveryStatusCriteria> getDeliveryStatuss(){
        return this.deliveryStatuss;
    }

    public void setDeliveryStatuss(List<DeliveryStatusCriteria> deliveryStatuss){
        this.deliveryStatuss = deliveryStatuss;
    }
    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
}

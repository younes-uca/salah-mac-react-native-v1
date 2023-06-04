package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeliveryDto  extends AuditBaseDto {

    private String deliveryDate ;

    private DemandDto demand ;
    private DeliveryStatusDto deliveryStatus ;
    private ClientDto client ;

    private List<DeliveryItemDto> deliveryItems ;


    public DeliveryDto(){
        super();
    }



    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(String deliveryDate){
        this.deliveryDate = deliveryDate;
    }


    public DemandDto getDemand(){
        return this.demand;
    }

    public void setDemand(DemandDto demand){
        this.demand = demand;
    }
    public DeliveryStatusDto getDeliveryStatus(){
        return this.deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatusDto deliveryStatus){
        this.deliveryStatus = deliveryStatus;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }



    public List<DeliveryItemDto> getDeliveryItems(){
        return this.deliveryItems;
    }

    public void setDeliveryItems(List<DeliveryItemDto> deliveryItems){
        this.deliveryItems = deliveryItems;
    }

}

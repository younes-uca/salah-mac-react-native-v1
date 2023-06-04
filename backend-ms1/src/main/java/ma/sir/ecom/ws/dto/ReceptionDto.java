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
public class ReceptionDto  extends AuditBaseDto {

    private String reference  ;
    private String receptionDate ;
    private String description  ;

    private OrderDto order ;
    private ReceptionStatusDto receptionStatus ;

    private List<ReceptionItemDto> receptionItems ;


    public ReceptionDto(){
        super();
    }



    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }

    @Log
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm")
    public String getReceptionDate(){
        return this.receptionDate;
    }
    public void setReceptionDate(String receptionDate){
        this.receptionDate = receptionDate;
    }

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public OrderDto getOrder(){
        return this.order;
    }

    public void setOrder(OrderDto order){
        this.order = order;
    }
    public ReceptionStatusDto getReceptionStatus(){
        return this.receptionStatus;
    }

    public void setReceptionStatus(ReceptionStatusDto receptionStatus){
        this.receptionStatus = receptionStatus;
    }



    public List<ReceptionItemDto> getReceptionItems(){
        return this.receptionItems;
    }

    public void setReceptionItems(List<ReceptionItemDto> receptionItems){
        this.receptionItems = receptionItems;
    }

}

package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemandDto  extends AuditBaseDto {

    private String reference  ;
    private String demandDate ;
    private BigDecimal totalCheck  ;
    private BigDecimal totalCash  ;
    private BigDecimal total  ;
    private BigDecimal totalPaid  ;

    private ClientDto client ;
    private DemandStatusDto demandStatus ;

    private List<DemandItemDto> demandItems ;


    public DemandDto(){
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
    public String getDemandDate(){
        return this.demandDate;
    }
    public void setDemandDate(String demandDate){
        this.demandDate = demandDate;
    }

    @Log
    public BigDecimal getTotalCheck(){
        return this.totalCheck;
    }
    public void setTotalCheck(BigDecimal totalCheck){
        this.totalCheck = totalCheck;
    }

    @Log
    public BigDecimal getTotalCash(){
        return this.totalCash;
    }
    public void setTotalCash(BigDecimal totalCash){
        this.totalCash = totalCash;
    }

    @Log
    public BigDecimal getTotal(){
        return this.total;
    }
    public void setTotal(BigDecimal total){
        this.total = total;
    }

    @Log
    public BigDecimal getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(BigDecimal totalPaid){
        this.totalPaid = totalPaid;
    }


    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public DemandStatusDto getDemandStatus(){
        return this.demandStatus;
    }

    public void setDemandStatus(DemandStatusDto demandStatus){
        this.demandStatus = demandStatus;
    }



    public List<DemandItemDto> getDemandItems(){
        return this.demandItems;
    }

    public void setDemandItems(List<DemandItemDto> demandItems){
        this.demandItems = demandItems;
    }

}

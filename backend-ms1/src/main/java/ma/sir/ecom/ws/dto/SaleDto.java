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
public class SaleDto  extends AuditBaseDto {

    private String reference  ;
    private String saleDate ;
    private BigDecimal total  ;
    private BigDecimal totalPaid  ;
    private String description  ;

    private StoreDto store ;
    private ClientDto client ;
    private SaleStatusDto saleStatus ;

    private List<SaleItemDto> saleItems ;


    public SaleDto(){
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
    public String getSaleDate(){
        return this.saleDate;
    }
    public void setSaleDate(String saleDate){
        this.saleDate = saleDate;
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

    @Log
    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }


    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }
    public ClientDto getClient(){
        return this.client;
    }

    public void setClient(ClientDto client){
        this.client = client;
    }
    public SaleStatusDto getSaleStatus(){
        return this.saleStatus;
    }

    public void setSaleStatus(SaleStatusDto saleStatus){
        this.saleStatus = saleStatus;
    }



    public List<SaleItemDto> getSaleItems(){
        return this.saleItems;
    }

    public void setSaleItems(List<SaleItemDto> saleItems){
        this.saleItems = saleItems;
    }

}

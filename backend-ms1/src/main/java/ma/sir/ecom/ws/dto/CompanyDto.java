package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompanyDto  extends AuditBaseDto {

    private String ice  ;
    private String headquarters  ;
    private Integer lastPaidYearIS  = 0 ;
    private Integer lastPaidQuarterIS  = 0 ;
    private Integer lastPaidYearVAT  = 0 ;
    private Integer lastPaidQuarterVAT  = 0 ;
    private Boolean blocked  ;

    private SubscriberDto subscriber ;

    private List<StoreDto> stores ;


    public CompanyDto(){
        super();
    }



    @Log
    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }

    @Log
    public String getHeadquarters(){
        return this.headquarters;
    }
    public void setHeadquarters(String headquarters){
        this.headquarters = headquarters;
    }

    @Log
    public Integer getLastPaidYearIS(){
        return this.lastPaidYearIS;
    }
    public void setLastPaidYearIS(Integer lastPaidYearIS){
        this.lastPaidYearIS = lastPaidYearIS;
    }

    @Log
    public Integer getLastPaidQuarterIS(){
        return this.lastPaidQuarterIS;
    }
    public void setLastPaidQuarterIS(Integer lastPaidQuarterIS){
        this.lastPaidQuarterIS = lastPaidQuarterIS;
    }

    @Log
    public Integer getLastPaidYearVAT(){
        return this.lastPaidYearVAT;
    }
    public void setLastPaidYearVAT(Integer lastPaidYearVAT){
        this.lastPaidYearVAT = lastPaidYearVAT;
    }

    @Log
    public Integer getLastPaidQuarterVAT(){
        return this.lastPaidQuarterVAT;
    }
    public void setLastPaidQuarterVAT(Integer lastPaidQuarterVAT){
        this.lastPaidQuarterVAT = lastPaidQuarterVAT;
    }

    @Log
    public Boolean getBlocked(){
        return this.blocked;
    }
    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }


    public SubscriberDto getSubscriber(){
        return this.subscriber;
    }

    public void setSubscriber(SubscriberDto subscriber){
        this.subscriber = subscriber;
    }



    public List<StoreDto> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreDto> stores){
        this.stores = stores;
    }

}

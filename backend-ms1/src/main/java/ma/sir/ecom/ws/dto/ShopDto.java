package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopDto  extends AuditBaseDto {

    private String reference  ;
    private String address  ;

    private StoreDto store ;



    public ShopDto(){
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
    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }


    public StoreDto getStore(){
        return this.store;
    }

    public void setStore(StoreDto store){
        this.store = store;
    }




}

package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class StoreDto  extends AuditBaseDto {

    private String libelle  ;
    private String reference  ;

    private CompanyDto company ;



    public StoreDto(){
        super();
    }



    @Log
    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }

    @Log
    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }


    public CompanyDto getCompany(){
        return this.company;
    }

    public void setCompany(CompanyDto company){
        this.company = company;
    }




}

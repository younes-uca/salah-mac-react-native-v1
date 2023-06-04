package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountingAccountDto  extends AuditBaseDto {

    private String libelle  ;
    private String code  ;

    private SubAccountingClassDto subAccountingClass ;



    public AccountingAccountDto(){
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
    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }


    public SubAccountingClassDto getSubAccountingClass(){
        return this.subAccountingClass;
    }

    public void setSubAccountingClass(SubAccountingClassDto subAccountingClass){
        this.subAccountingClass = subAccountingClass;
    }




}

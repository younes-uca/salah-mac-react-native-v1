package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankCheckOwnerDto  extends AuditBaseDto {


    private CheckOwnerDto checkOwner ;
    private BankDto bank ;



    public BankCheckOwnerDto(){
        super();
    }




    public CheckOwnerDto getCheckOwner(){
        return this.checkOwner;
    }

    public void setCheckOwner(CheckOwnerDto checkOwner){
        this.checkOwner = checkOwner;
    }
    public BankDto getBank(){
        return this.bank;
    }

    public void setBank(BankDto bank){
        this.bank = bank;
    }




}

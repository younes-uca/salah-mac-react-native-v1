package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class BankCheckOwnerCriteria extends  BaseCriteria  {


    private CheckOwnerCriteria checkOwner ;
    private List<CheckOwnerCriteria> checkOwners ;
    private BankCriteria bank ;
    private List<BankCriteria> banks ;


    public BankCheckOwnerCriteria(){}


    public CheckOwnerCriteria getCheckOwner(){
        return this.checkOwner;
    }

    public void setCheckOwner(CheckOwnerCriteria checkOwner){
        this.checkOwner = checkOwner;
    }
    public List<CheckOwnerCriteria> getCheckOwners(){
        return this.checkOwners;
    }

    public void setCheckOwners(List<CheckOwnerCriteria> checkOwners){
        this.checkOwners = checkOwners;
    }
    public BankCriteria getBank(){
        return this.bank;
    }

    public void setBank(BankCriteria bank){
        this.bank = bank;
    }
    public List<BankCriteria> getBanks(){
        return this.banks;
    }

    public void setBanks(List<BankCriteria> banks){
        this.banks = banks;
    }
}

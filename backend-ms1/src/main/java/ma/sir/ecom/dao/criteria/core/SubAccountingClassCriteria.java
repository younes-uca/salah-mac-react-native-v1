package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SubAccountingClassCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private AccountingClassCriteria accountingClass ;
    private List<AccountingClassCriteria> accountingClasss ;


    public SubAccountingClassCriteria(){}

    public String getLibelle(){
        return this.libelle;
    }
    public void setLibelle(String libelle){
        this.libelle = libelle;
    }
    public String getLibelleLike(){
        return this.libelleLike;
    }
    public void setLibelleLike(String libelleLike){
        this.libelleLike = libelleLike;
    }

    public String getCode(){
        return this.code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCodeLike(){
        return this.codeLike;
    }
    public void setCodeLike(String codeLike){
        this.codeLike = codeLike;
    }


    public AccountingClassCriteria getAccountingClass(){
        return this.accountingClass;
    }

    public void setAccountingClass(AccountingClassCriteria accountingClass){
        this.accountingClass = accountingClass;
    }
    public List<AccountingClassCriteria> getAccountingClasss(){
        return this.accountingClasss;
    }

    public void setAccountingClasss(List<AccountingClassCriteria> accountingClasss){
        this.accountingClasss = accountingClasss;
    }
}

package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AccountingAccountCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String code;
    private String codeLike;

    private SubAccountingClassCriteria subAccountingClass ;
    private List<SubAccountingClassCriteria> subAccountingClasss ;


    public AccountingAccountCriteria(){}

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


    public SubAccountingClassCriteria getSubAccountingClass(){
        return this.subAccountingClass;
    }

    public void setSubAccountingClass(SubAccountingClassCriteria subAccountingClass){
        this.subAccountingClass = subAccountingClass;
    }
    public List<SubAccountingClassCriteria> getSubAccountingClasss(){
        return this.subAccountingClasss;
    }

    public void setSubAccountingClasss(List<SubAccountingClassCriteria> subAccountingClasss){
        this.subAccountingClasss = subAccountingClasss;
    }
}

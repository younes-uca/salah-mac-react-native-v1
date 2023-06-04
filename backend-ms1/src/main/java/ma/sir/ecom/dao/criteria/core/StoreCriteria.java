package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class StoreCriteria extends  BaseCriteria  {

    private String libelle;
    private String libelleLike;
    private String reference;
    private String referenceLike;

    private CompanyCriteria company ;
    private List<CompanyCriteria> companys ;


    public StoreCriteria(){}

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

    public String getReference(){
        return this.reference;
    }
    public void setReference(String reference){
        this.reference = reference;
    }
    public String getReferenceLike(){
        return this.referenceLike;
    }
    public void setReferenceLike(String referenceLike){
        this.referenceLike = referenceLike;
    }


    public CompanyCriteria getCompany(){
        return this.company;
    }

    public void setCompany(CompanyCriteria company){
        this.company = company;
    }
    public List<CompanyCriteria> getCompanys(){
        return this.companys;
    }

    public void setCompanys(List<CompanyCriteria> companys){
        this.companys = companys;
    }
}

package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class SupplierCriteria extends  BaseCriteria  {

    private String ice;
    private String iceLike;
    private String name;
    private String nameLike;
    private String tel;
    private String telLike;
    private String email;
    private String emailLike;
    private String address;
    private String addressLike;
    private String description;
    private String descriptionLike;
    private String debt;
    private String debtMin;
    private String debtMax;



    public SupplierCriteria(){}

    public String getIce(){
        return this.ice;
    }
    public void setIce(String ice){
        this.ice = ice;
    }
    public String getIceLike(){
        return this.iceLike;
    }
    public void setIceLike(String iceLike){
        this.iceLike = iceLike;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getNameLike(){
        return this.nameLike;
    }
    public void setNameLike(String nameLike){
        this.nameLike = nameLike;
    }

    public String getTel(){
        return this.tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getTelLike(){
        return this.telLike;
    }
    public void setTelLike(String telLike){
        this.telLike = telLike;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailLike(){
        return this.emailLike;
    }
    public void setEmailLike(String emailLike){
        this.emailLike = emailLike;
    }

    public String getAddress(){
        return this.address;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddressLike(){
        return this.addressLike;
    }
    public void setAddressLike(String addressLike){
        this.addressLike = addressLike;
    }

    public String getDescription(){
        return this.description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public String getDescriptionLike(){
        return this.descriptionLike;
    }
    public void setDescriptionLike(String descriptionLike){
        this.descriptionLike = descriptionLike;
    }

    public String getDebt(){
        return this.debt;
    }
    public void setDebt(String debt){
        this.debt = debt;
    }   
    public String getDebtMin(){
        return this.debtMin;
    }
    public void setDebtMin(String debtMin){
        this.debtMin = debtMin;
    }
    public String getDebtMax(){
        return this.debtMax;
    }
    public void setDebtMax(String debtMax){
        this.debtMax = debtMax;
    }
      

}

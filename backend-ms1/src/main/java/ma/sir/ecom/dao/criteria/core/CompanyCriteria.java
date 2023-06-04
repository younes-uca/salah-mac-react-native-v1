package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class CompanyCriteria extends  BaseCriteria  {

    private String ice;
    private String iceLike;
    private String headquarters;
    private String headquartersLike;
    private String lastPaidYearIS;
    private String lastPaidYearISMin;
    private String lastPaidYearISMax;
    private String lastPaidQuarterIS;
    private String lastPaidQuarterISMin;
    private String lastPaidQuarterISMax;
    private String lastPaidYearVAT;
    private String lastPaidYearVATMin;
    private String lastPaidYearVATMax;
    private String lastPaidQuarterVAT;
    private String lastPaidQuarterVATMin;
    private String lastPaidQuarterVATMax;
    private Boolean blocked;

    private SubscriberCriteria subscriber ;
    private List<SubscriberCriteria> subscribers ;


    public CompanyCriteria(){}

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

    public String getHeadquarters(){
        return this.headquarters;
    }
    public void setHeadquarters(String headquarters){
        this.headquarters = headquarters;
    }
    public String getHeadquartersLike(){
        return this.headquartersLike;
    }
    public void setHeadquartersLike(String headquartersLike){
        this.headquartersLike = headquartersLike;
    }

    public String getLastPaidYearIS(){
        return this.lastPaidYearIS;
    }
    public void setLastPaidYearIS(String lastPaidYearIS){
        this.lastPaidYearIS = lastPaidYearIS;
    }   
    public String getLastPaidYearISMin(){
        return this.lastPaidYearISMin;
    }
    public void setLastPaidYearISMin(String lastPaidYearISMin){
        this.lastPaidYearISMin = lastPaidYearISMin;
    }
    public String getLastPaidYearISMax(){
        return this.lastPaidYearISMax;
    }
    public void setLastPaidYearISMax(String lastPaidYearISMax){
        this.lastPaidYearISMax = lastPaidYearISMax;
    }
      
    public String getLastPaidQuarterIS(){
        return this.lastPaidQuarterIS;
    }
    public void setLastPaidQuarterIS(String lastPaidQuarterIS){
        this.lastPaidQuarterIS = lastPaidQuarterIS;
    }   
    public String getLastPaidQuarterISMin(){
        return this.lastPaidQuarterISMin;
    }
    public void setLastPaidQuarterISMin(String lastPaidQuarterISMin){
        this.lastPaidQuarterISMin = lastPaidQuarterISMin;
    }
    public String getLastPaidQuarterISMax(){
        return this.lastPaidQuarterISMax;
    }
    public void setLastPaidQuarterISMax(String lastPaidQuarterISMax){
        this.lastPaidQuarterISMax = lastPaidQuarterISMax;
    }
      
    public String getLastPaidYearVAT(){
        return this.lastPaidYearVAT;
    }
    public void setLastPaidYearVAT(String lastPaidYearVAT){
        this.lastPaidYearVAT = lastPaidYearVAT;
    }   
    public String getLastPaidYearVATMin(){
        return this.lastPaidYearVATMin;
    }
    public void setLastPaidYearVATMin(String lastPaidYearVATMin){
        this.lastPaidYearVATMin = lastPaidYearVATMin;
    }
    public String getLastPaidYearVATMax(){
        return this.lastPaidYearVATMax;
    }
    public void setLastPaidYearVATMax(String lastPaidYearVATMax){
        this.lastPaidYearVATMax = lastPaidYearVATMax;
    }
      
    public String getLastPaidQuarterVAT(){
        return this.lastPaidQuarterVAT;
    }
    public void setLastPaidQuarterVAT(String lastPaidQuarterVAT){
        this.lastPaidQuarterVAT = lastPaidQuarterVAT;
    }   
    public String getLastPaidQuarterVATMin(){
        return this.lastPaidQuarterVATMin;
    }
    public void setLastPaidQuarterVATMin(String lastPaidQuarterVATMin){
        this.lastPaidQuarterVATMin = lastPaidQuarterVATMin;
    }
    public String getLastPaidQuarterVATMax(){
        return this.lastPaidQuarterVATMax;
    }
    public void setLastPaidQuarterVATMax(String lastPaidQuarterVATMax){
        this.lastPaidQuarterVATMax = lastPaidQuarterVATMax;
    }
      
    public Boolean getBlocked(){
        return this.blocked;
    }
    public void setBlocked(Boolean blocked){
        this.blocked = blocked;
    }

    public SubscriberCriteria getSubscriber(){
        return this.subscriber;
    }

    public void setSubscriber(SubscriberCriteria subscriber){
        this.subscriber = subscriber;
    }
    public List<SubscriberCriteria> getSubscribers(){
        return this.subscribers;
    }

    public void setSubscribers(List<SubscriberCriteria> subscribers){
        this.subscribers = subscribers;
    }
}

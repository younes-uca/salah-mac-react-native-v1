package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DemandCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime demandDate;
    private LocalDateTime demandDateFrom;
    private LocalDateTime demandDateTo;
    private String totalCheck;
    private String totalCheckMin;
    private String totalCheckMax;
    private String totalCash;
    private String totalCashMin;
    private String totalCashMax;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaid;
    private String totalPaidMin;
    private String totalPaidMax;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private DemandStatusCriteria demandStatus ;
    private List<DemandStatusCriteria> demandStatuss ;


    public DemandCriteria(){}

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

    public LocalDateTime getDemandDate(){
        return this.demandDate;
    }
    public void setDemandDate(LocalDateTime demandDate){
        this.demandDate = demandDate;
    }
    public LocalDateTime getDemandDateFrom(){
        return this.demandDateFrom;
    }
    public void setDemandDateFrom(LocalDateTime demandDateFrom){
        this.demandDateFrom = demandDateFrom;
    }
    public LocalDateTime getDemandDateTo(){
        return this.demandDateTo;
    }
    public void setDemandDateTo(LocalDateTime demandDateTo){
        this.demandDateTo = demandDateTo;
    }
    public String getTotalCheck(){
        return this.totalCheck;
    }
    public void setTotalCheck(String totalCheck){
        this.totalCheck = totalCheck;
    }   
    public String getTotalCheckMin(){
        return this.totalCheckMin;
    }
    public void setTotalCheckMin(String totalCheckMin){
        this.totalCheckMin = totalCheckMin;
    }
    public String getTotalCheckMax(){
        return this.totalCheckMax;
    }
    public void setTotalCheckMax(String totalCheckMax){
        this.totalCheckMax = totalCheckMax;
    }
      
    public String getTotalCash(){
        return this.totalCash;
    }
    public void setTotalCash(String totalCash){
        this.totalCash = totalCash;
    }   
    public String getTotalCashMin(){
        return this.totalCashMin;
    }
    public void setTotalCashMin(String totalCashMin){
        this.totalCashMin = totalCashMin;
    }
    public String getTotalCashMax(){
        return this.totalCashMax;
    }
    public void setTotalCashMax(String totalCashMax){
        this.totalCashMax = totalCashMax;
    }
      
    public String getTotal(){
        return this.total;
    }
    public void setTotal(String total){
        this.total = total;
    }   
    public String getTotalMin(){
        return this.totalMin;
    }
    public void setTotalMin(String totalMin){
        this.totalMin = totalMin;
    }
    public String getTotalMax(){
        return this.totalMax;
    }
    public void setTotalMax(String totalMax){
        this.totalMax = totalMax;
    }
      
    public String getTotalPaid(){
        return this.totalPaid;
    }
    public void setTotalPaid(String totalPaid){
        this.totalPaid = totalPaid;
    }   
    public String getTotalPaidMin(){
        return this.totalPaidMin;
    }
    public void setTotalPaidMin(String totalPaidMin){
        this.totalPaidMin = totalPaidMin;
    }
    public String getTotalPaidMax(){
        return this.totalPaidMax;
    }
    public void setTotalPaidMax(String totalPaidMax){
        this.totalPaidMax = totalPaidMax;
    }
      

    public ClientCriteria getClient(){
        return this.client;
    }

    public void setClient(ClientCriteria client){
        this.client = client;
    }
    public List<ClientCriteria> getClients(){
        return this.clients;
    }

    public void setClients(List<ClientCriteria> clients){
        this.clients = clients;
    }
    public DemandStatusCriteria getDemandStatus(){
        return this.demandStatus;
    }

    public void setDemandStatus(DemandStatusCriteria demandStatus){
        this.demandStatus = demandStatus;
    }
    public List<DemandStatusCriteria> getDemandStatuss(){
        return this.demandStatuss;
    }

    public void setDemandStatuss(List<DemandStatusCriteria> demandStatuss){
        this.demandStatuss = demandStatuss;
    }
}

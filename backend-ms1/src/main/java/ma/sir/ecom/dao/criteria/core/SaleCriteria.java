package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class SaleCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime saleDate;
    private LocalDateTime saleDateFrom;
    private LocalDateTime saleDateTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaid;
    private String totalPaidMin;
    private String totalPaidMax;
    private String description;
    private String descriptionLike;

    private StoreCriteria store ;
    private List<StoreCriteria> stores ;
    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private SaleStatusCriteria saleStatus ;
    private List<SaleStatusCriteria> saleStatuss ;


    public SaleCriteria(){}

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

    public LocalDateTime getSaleDate(){
        return this.saleDate;
    }
    public void setSaleDate(LocalDateTime saleDate){
        this.saleDate = saleDate;
    }
    public LocalDateTime getSaleDateFrom(){
        return this.saleDateFrom;
    }
    public void setSaleDateFrom(LocalDateTime saleDateFrom){
        this.saleDateFrom = saleDateFrom;
    }
    public LocalDateTime getSaleDateTo(){
        return this.saleDateTo;
    }
    public void setSaleDateTo(LocalDateTime saleDateTo){
        this.saleDateTo = saleDateTo;
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


    public StoreCriteria getStore(){
        return this.store;
    }

    public void setStore(StoreCriteria store){
        this.store = store;
    }
    public List<StoreCriteria> getStores(){
        return this.stores;
    }

    public void setStores(List<StoreCriteria> stores){
        this.stores = stores;
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
    public SaleStatusCriteria getSaleStatus(){
        return this.saleStatus;
    }

    public void setSaleStatus(SaleStatusCriteria saleStatus){
        this.saleStatus = saleStatus;
    }
    public List<SaleStatusCriteria> getSaleStatuss(){
        return this.saleStatuss;
    }

    public void setSaleStatuss(List<SaleStatusCriteria> saleStatuss){
        this.saleStatuss = saleStatuss;
    }
}

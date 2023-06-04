package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OrderCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime orderDate;
    private LocalDateTime orderDateFrom;
    private LocalDateTime orderDateTo;
    private String total;
    private String totalMin;
    private String totalMax;
    private String totalPaid;
    private String totalPaidMin;
    private String totalPaidMax;
    private String totalPaidCheck;
    private String totalPaidCheckMin;
    private String totalPaidCheckMax;
    private String totalPaidCash;
    private String totalPaidCashMin;
    private String totalPaidCashMax;

    private ClientCriteria client ;
    private List<ClientCriteria> clients ;
    private OrderStatusCriteria orderStatus ;
    private List<OrderStatusCriteria> orderStatuss ;


    public OrderCriteria(){}

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

    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate){
        this.orderDate = orderDate;
    }
    public LocalDateTime getOrderDateFrom(){
        return this.orderDateFrom;
    }
    public void setOrderDateFrom(LocalDateTime orderDateFrom){
        this.orderDateFrom = orderDateFrom;
    }
    public LocalDateTime getOrderDateTo(){
        return this.orderDateTo;
    }
    public void setOrderDateTo(LocalDateTime orderDateTo){
        this.orderDateTo = orderDateTo;
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
      
    public String getTotalPaidCheck(){
        return this.totalPaidCheck;
    }
    public void setTotalPaidCheck(String totalPaidCheck){
        this.totalPaidCheck = totalPaidCheck;
    }   
    public String getTotalPaidCheckMin(){
        return this.totalPaidCheckMin;
    }
    public void setTotalPaidCheckMin(String totalPaidCheckMin){
        this.totalPaidCheckMin = totalPaidCheckMin;
    }
    public String getTotalPaidCheckMax(){
        return this.totalPaidCheckMax;
    }
    public void setTotalPaidCheckMax(String totalPaidCheckMax){
        this.totalPaidCheckMax = totalPaidCheckMax;
    }
      
    public String getTotalPaidCash(){
        return this.totalPaidCash;
    }
    public void setTotalPaidCash(String totalPaidCash){
        this.totalPaidCash = totalPaidCash;
    }   
    public String getTotalPaidCashMin(){
        return this.totalPaidCashMin;
    }
    public void setTotalPaidCashMin(String totalPaidCashMin){
        this.totalPaidCashMin = totalPaidCashMin;
    }
    public String getTotalPaidCashMax(){
        return this.totalPaidCashMax;
    }
    public void setTotalPaidCashMax(String totalPaidCashMax){
        this.totalPaidCashMax = totalPaidCashMax;
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
    public OrderStatusCriteria getOrderStatus(){
        return this.orderStatus;
    }

    public void setOrderStatus(OrderStatusCriteria orderStatus){
        this.orderStatus = orderStatus;
    }
    public List<OrderStatusCriteria> getOrderStatuss(){
        return this.orderStatuss;
    }

    public void setOrderStatuss(List<OrderStatusCriteria> orderStatuss){
        this.orderStatuss = orderStatuss;
    }
}

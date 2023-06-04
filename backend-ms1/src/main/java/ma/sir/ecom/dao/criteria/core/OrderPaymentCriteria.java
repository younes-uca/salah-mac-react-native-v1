package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class OrderPaymentCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime paymentDate;
    private LocalDateTime paymentDateFrom;
    private LocalDateTime paymentDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;
    private String description;
    private String descriptionLike;
    private Boolean vireCheck;

    private OrderCriteria order ;
    private List<OrderCriteria> orders ;
    private PaymentModeCriteria paymentMode ;
    private List<PaymentModeCriteria> paymentModes ;
    private OrderStatusOrderCriteria orderStatusOrder ;
    private List<OrderStatusOrderCriteria> orderStatusOrders ;


    public OrderPaymentCriteria(){}

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

    public LocalDateTime getPaymentDate(){
        return this.paymentDate;
    }
    public void setPaymentDate(LocalDateTime paymentDate){
        this.paymentDate = paymentDate;
    }
    public LocalDateTime getPaymentDateFrom(){
        return this.paymentDateFrom;
    }
    public void setPaymentDateFrom(LocalDateTime paymentDateFrom){
        this.paymentDateFrom = paymentDateFrom;
    }
    public LocalDateTime getPaymentDateTo(){
        return this.paymentDateTo;
    }
    public void setPaymentDateTo(LocalDateTime paymentDateTo){
        this.paymentDateTo = paymentDateTo;
    }
    public String getAmount(){
        return this.amount;
    }
    public void setAmount(String amount){
        this.amount = amount;
    }   
    public String getAmountMin(){
        return this.amountMin;
    }
    public void setAmountMin(String amountMin){
        this.amountMin = amountMin;
    }
    public String getAmountMax(){
        return this.amountMax;
    }
    public void setAmountMax(String amountMax){
        this.amountMax = amountMax;
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

    public Boolean getVireCheck(){
        return this.vireCheck;
    }
    public void setVireCheck(Boolean vireCheck){
        this.vireCheck = vireCheck;
    }

    public OrderCriteria getOrder(){
        return this.order;
    }

    public void setOrder(OrderCriteria order){
        this.order = order;
    }
    public List<OrderCriteria> getOrders(){
        return this.orders;
    }

    public void setOrders(List<OrderCriteria> orders){
        this.orders = orders;
    }
    public PaymentModeCriteria getPaymentMode(){
        return this.paymentMode;
    }

    public void setPaymentMode(PaymentModeCriteria paymentMode){
        this.paymentMode = paymentMode;
    }
    public List<PaymentModeCriteria> getPaymentModes(){
        return this.paymentModes;
    }

    public void setPaymentModes(List<PaymentModeCriteria> paymentModes){
        this.paymentModes = paymentModes;
    }
    public OrderStatusOrderCriteria getOrderStatusOrder(){
        return this.orderStatusOrder;
    }

    public void setOrderStatusOrder(OrderStatusOrderCriteria orderStatusOrder){
        this.orderStatusOrder = orderStatusOrder;
    }
    public List<OrderStatusOrderCriteria> getOrderStatusOrders(){
        return this.orderStatusOrders;
    }

    public void setOrderStatusOrders(List<OrderStatusOrderCriteria> orderStatusOrders){
        this.orderStatusOrders = orderStatusOrders;
    }
}

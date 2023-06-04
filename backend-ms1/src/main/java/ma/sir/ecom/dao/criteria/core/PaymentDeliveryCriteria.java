package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaymentDeliveryCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime deliveryDate;
    private LocalDateTime deliveryDateFrom;
    private LocalDateTime deliveryDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;
    private String description;
    private String descriptionLike;

    private DeliveryCriteria delivery ;
    private List<DeliveryCriteria> deliverys ;
    private SaleCriteria sale ;
    private List<SaleCriteria> sales ;
    private PaymentMethodCriteria paymentMethod ;
    private List<PaymentMethodCriteria> paymentMethods ;
    private PaymentDeliveryStatusCriteria paymentDeliveryStatus ;
    private List<PaymentDeliveryStatusCriteria> paymentDeliveryStatuss ;


    public PaymentDeliveryCriteria(){}

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

    public LocalDateTime getDeliveryDate(){
        return this.deliveryDate;
    }
    public void setDeliveryDate(LocalDateTime deliveryDate){
        this.deliveryDate = deliveryDate;
    }
    public LocalDateTime getDeliveryDateFrom(){
        return this.deliveryDateFrom;
    }
    public void setDeliveryDateFrom(LocalDateTime deliveryDateFrom){
        this.deliveryDateFrom = deliveryDateFrom;
    }
    public LocalDateTime getDeliveryDateTo(){
        return this.deliveryDateTo;
    }
    public void setDeliveryDateTo(LocalDateTime deliveryDateTo){
        this.deliveryDateTo = deliveryDateTo;
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


    public DeliveryCriteria getDelivery(){
        return this.delivery;
    }

    public void setDelivery(DeliveryCriteria delivery){
        this.delivery = delivery;
    }
    public List<DeliveryCriteria> getDeliverys(){
        return this.deliverys;
    }

    public void setDeliverys(List<DeliveryCriteria> deliverys){
        this.deliverys = deliverys;
    }
    public SaleCriteria getSale(){
        return this.sale;
    }

    public void setSale(SaleCriteria sale){
        this.sale = sale;
    }
    public List<SaleCriteria> getSales(){
        return this.sales;
    }

    public void setSales(List<SaleCriteria> sales){
        this.sales = sales;
    }
    public PaymentMethodCriteria getPaymentMethod(){
        return this.paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodCriteria paymentMethod){
        this.paymentMethod = paymentMethod;
    }
    public List<PaymentMethodCriteria> getPaymentMethods(){
        return this.paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethodCriteria> paymentMethods){
        this.paymentMethods = paymentMethods;
    }
    public PaymentDeliveryStatusCriteria getPaymentDeliveryStatus(){
        return this.paymentDeliveryStatus;
    }

    public void setPaymentDeliveryStatus(PaymentDeliveryStatusCriteria paymentDeliveryStatus){
        this.paymentDeliveryStatus = paymentDeliveryStatus;
    }
    public List<PaymentDeliveryStatusCriteria> getPaymentDeliveryStatuss(){
        return this.paymentDeliveryStatuss;
    }

    public void setPaymentDeliveryStatuss(List<PaymentDeliveryStatusCriteria> paymentDeliveryStatuss){
        this.paymentDeliveryStatuss = paymentDeliveryStatuss;
    }
}

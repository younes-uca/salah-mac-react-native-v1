package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaymentSaleCriteria extends  BaseCriteria  {

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

    private SaleCriteria sale ;
    private List<SaleCriteria> sales ;
    private PaymentMethodCriteria paymentMethod ;
    private List<PaymentMethodCriteria> paymentMethods ;
    private PaymentStatusCriteria paymentStatus ;
    private List<PaymentStatusCriteria> paymentStatuss ;


    public PaymentSaleCriteria(){}

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
    public PaymentStatusCriteria getPaymentStatus(){
        return this.paymentStatus;
    }

    public void setPaymentStatus(PaymentStatusCriteria paymentStatus){
        this.paymentStatus = paymentStatus;
    }
    public List<PaymentStatusCriteria> getPaymentStatuss(){
        return this.paymentStatuss;
    }

    public void setPaymentStatuss(List<PaymentStatusCriteria> paymentStatuss){
        this.paymentStatuss = paymentStatuss;
    }
}

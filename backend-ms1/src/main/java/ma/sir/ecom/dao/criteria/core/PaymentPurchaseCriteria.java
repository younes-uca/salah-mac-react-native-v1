package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class PaymentPurchaseCriteria extends  BaseCriteria  {

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

    private PurchaseCriteria purchase ;
    private List<PurchaseCriteria> purchases ;
    private PaymentModeCriteria paymentMode ;
    private List<PaymentModeCriteria> paymentModes ;
    private PurchasePaymentStatusCriteria purchasePaymentStatus ;
    private List<PurchasePaymentStatusCriteria> purchasePaymentStatuss ;


    public PaymentPurchaseCriteria(){}

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


    public PurchaseCriteria getPurchase(){
        return this.purchase;
    }

    public void setPurchase(PurchaseCriteria purchase){
        this.purchase = purchase;
    }
    public List<PurchaseCriteria> getPurchases(){
        return this.purchases;
    }

    public void setPurchases(List<PurchaseCriteria> purchases){
        this.purchases = purchases;
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
    public PurchasePaymentStatusCriteria getPurchasePaymentStatus(){
        return this.purchasePaymentStatus;
    }

    public void setPurchasePaymentStatus(PurchasePaymentStatusCriteria purchasePaymentStatus){
        this.purchasePaymentStatus = purchasePaymentStatus;
    }
    public List<PurchasePaymentStatusCriteria> getPurchasePaymentStatuss(){
        return this.purchasePaymentStatuss;
    }

    public void setPurchasePaymentStatuss(List<PurchasePaymentStatusCriteria> purchasePaymentStatuss){
        this.purchasePaymentStatuss = purchasePaymentStatuss;
    }
}

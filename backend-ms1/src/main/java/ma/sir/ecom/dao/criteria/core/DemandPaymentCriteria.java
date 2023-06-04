package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class DemandPaymentCriteria extends  BaseCriteria  {

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

    private DemandCriteria demand ;
    private List<DemandCriteria> demands ;
    private PaymentModeCriteria paymentMode ;
    private List<PaymentModeCriteria> paymentModes ;
    private StatusPaymentDemandCriteria statusPaymentDemand ;
    private List<StatusPaymentDemandCriteria> statusPaymentDemands ;


    public DemandPaymentCriteria(){}

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

    public DemandCriteria getDemand(){
        return this.demand;
    }

    public void setDemand(DemandCriteria demand){
        this.demand = demand;
    }
    public List<DemandCriteria> getDemands(){
        return this.demands;
    }

    public void setDemands(List<DemandCriteria> demands){
        this.demands = demands;
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
    public StatusPaymentDemandCriteria getStatusPaymentDemand(){
        return this.statusPaymentDemand;
    }

    public void setStatusPaymentDemand(StatusPaymentDemandCriteria statusPaymentDemand){
        this.statusPaymentDemand = statusPaymentDemand;
    }
    public List<StatusPaymentDemandCriteria> getStatusPaymentDemands(){
        return this.statusPaymentDemands;
    }

    public void setStatusPaymentDemands(List<StatusPaymentDemandCriteria> statusPaymentDemands){
        this.statusPaymentDemands = statusPaymentDemands;
    }
}

package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CreditNotePurchaseCriteria extends  BaseCriteria  {

    private LocalDateTime creditNoteDate;
    private LocalDateTime creditNoteDateFrom;
    private LocalDateTime creditNoteDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;

    private PurchaseCriteria purchase ;
    private List<PurchaseCriteria> purchases ;
    private CreditNotePurchaseStatusCriteria creditNotePurchaseStatus ;
    private List<CreditNotePurchaseStatusCriteria> creditNotePurchaseStatuss ;


    public CreditNotePurchaseCriteria(){}

    public LocalDateTime getCreditNoteDate(){
        return this.creditNoteDate;
    }
    public void setCreditNoteDate(LocalDateTime creditNoteDate){
        this.creditNoteDate = creditNoteDate;
    }
    public LocalDateTime getCreditNoteDateFrom(){
        return this.creditNoteDateFrom;
    }
    public void setCreditNoteDateFrom(LocalDateTime creditNoteDateFrom){
        this.creditNoteDateFrom = creditNoteDateFrom;
    }
    public LocalDateTime getCreditNoteDateTo(){
        return this.creditNoteDateTo;
    }
    public void setCreditNoteDateTo(LocalDateTime creditNoteDateTo){
        this.creditNoteDateTo = creditNoteDateTo;
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
    public CreditNotePurchaseStatusCriteria getCreditNotePurchaseStatus(){
        return this.creditNotePurchaseStatus;
    }

    public void setCreditNotePurchaseStatus(CreditNotePurchaseStatusCriteria creditNotePurchaseStatus){
        this.creditNotePurchaseStatus = creditNotePurchaseStatus;
    }
    public List<CreditNotePurchaseStatusCriteria> getCreditNotePurchaseStatuss(){
        return this.creditNotePurchaseStatuss;
    }

    public void setCreditNotePurchaseStatuss(List<CreditNotePurchaseStatusCriteria> creditNotePurchaseStatuss){
        this.creditNotePurchaseStatuss = creditNotePurchaseStatuss;
    }
}

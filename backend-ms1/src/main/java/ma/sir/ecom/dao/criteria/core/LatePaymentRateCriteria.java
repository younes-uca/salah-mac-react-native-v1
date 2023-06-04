package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class LatePaymentRateCriteria extends  BaseCriteria  {

    private LocalDateTime minApplicationDate;
    private LocalDateTime minApplicationDateFrom;
    private LocalDateTime minApplicationDateTo;
    private LocalDateTime maxApplicationDate;
    private LocalDateTime maxApplicationDateFrom;
    private LocalDateTime maxApplicationDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;



    public LatePaymentRateCriteria(){}

    public LocalDateTime getMinApplicationDate(){
        return this.minApplicationDate;
    }
    public void setMinApplicationDate(LocalDateTime minApplicationDate){
        this.minApplicationDate = minApplicationDate;
    }
    public LocalDateTime getMinApplicationDateFrom(){
        return this.minApplicationDateFrom;
    }
    public void setMinApplicationDateFrom(LocalDateTime minApplicationDateFrom){
        this.minApplicationDateFrom = minApplicationDateFrom;
    }
    public LocalDateTime getMinApplicationDateTo(){
        return this.minApplicationDateTo;
    }
    public void setMinApplicationDateTo(LocalDateTime minApplicationDateTo){
        this.minApplicationDateTo = minApplicationDateTo;
    }
    public LocalDateTime getMaxApplicationDate(){
        return this.maxApplicationDate;
    }
    public void setMaxApplicationDate(LocalDateTime maxApplicationDate){
        this.maxApplicationDate = maxApplicationDate;
    }
    public LocalDateTime getMaxApplicationDateFrom(){
        return this.maxApplicationDateFrom;
    }
    public void setMaxApplicationDateFrom(LocalDateTime maxApplicationDateFrom){
        this.maxApplicationDateFrom = maxApplicationDateFrom;
    }
    public LocalDateTime getMaxApplicationDateTo(){
        return this.maxApplicationDateTo;
    }
    public void setMaxApplicationDateTo(LocalDateTime maxApplicationDateTo){
        this.maxApplicationDateTo = maxApplicationDateTo;
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
      

}

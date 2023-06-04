package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class ReturnSaleCriteria extends  BaseCriteria  {

    private LocalDateTime returnDate;
    private LocalDateTime returnDateFrom;
    private LocalDateTime returnDateTo;
    private String amount;
    private String amountMin;
    private String amountMax;

    private SaleCriteria sale ;
    private List<SaleCriteria> sales ;
    private ReturnStatusCriteria returnStatus ;
    private List<ReturnStatusCriteria> returnStatuss ;


    public ReturnSaleCriteria(){}

    public LocalDateTime getReturnDate(){
        return this.returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate){
        this.returnDate = returnDate;
    }
    public LocalDateTime getReturnDateFrom(){
        return this.returnDateFrom;
    }
    public void setReturnDateFrom(LocalDateTime returnDateFrom){
        this.returnDateFrom = returnDateFrom;
    }
    public LocalDateTime getReturnDateTo(){
        return this.returnDateTo;
    }
    public void setReturnDateTo(LocalDateTime returnDateTo){
        this.returnDateTo = returnDateTo;
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
    public ReturnStatusCriteria getReturnStatus(){
        return this.returnStatus;
    }

    public void setReturnStatus(ReturnStatusCriteria returnStatus){
        this.returnStatus = returnStatus;
    }
    public List<ReturnStatusCriteria> getReturnStatuss(){
        return this.returnStatuss;
    }

    public void setReturnStatuss(List<ReturnStatusCriteria> returnStatuss){
        this.returnStatuss = returnStatuss;
    }
}

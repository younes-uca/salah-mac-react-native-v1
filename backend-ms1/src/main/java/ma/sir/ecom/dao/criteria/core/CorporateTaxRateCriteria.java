package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class CorporateTaxRateCriteria extends  BaseCriteria  {

    private String minimumIncome;
    private String minimumIncomeMin;
    private String minimumIncomeMax;
    private String maximumIncome;
    private String maximumIncomeMin;
    private String maximumIncomeMax;
    private LocalDateTime minApplicationDate;
    private LocalDateTime minApplicationDateFrom;
    private LocalDateTime minApplicationDateTo;
    private LocalDateTime maxApplicationDate;
    private LocalDateTime maxApplicationDateFrom;
    private LocalDateTime maxApplicationDateTo;
    private String percentage;
    private String percentageMin;
    private String percentageMax;



    public CorporateTaxRateCriteria(){}

    public String getMinimumIncome(){
        return this.minimumIncome;
    }
    public void setMinimumIncome(String minimumIncome){
        this.minimumIncome = minimumIncome;
    }   
    public String getMinimumIncomeMin(){
        return this.minimumIncomeMin;
    }
    public void setMinimumIncomeMin(String minimumIncomeMin){
        this.minimumIncomeMin = minimumIncomeMin;
    }
    public String getMinimumIncomeMax(){
        return this.minimumIncomeMax;
    }
    public void setMinimumIncomeMax(String minimumIncomeMax){
        this.minimumIncomeMax = minimumIncomeMax;
    }
      
    public String getMaximumIncome(){
        return this.maximumIncome;
    }
    public void setMaximumIncome(String maximumIncome){
        this.maximumIncome = maximumIncome;
    }   
    public String getMaximumIncomeMin(){
        return this.maximumIncomeMin;
    }
    public void setMaximumIncomeMin(String maximumIncomeMin){
        this.maximumIncomeMin = maximumIncomeMin;
    }
    public String getMaximumIncomeMax(){
        return this.maximumIncomeMax;
    }
    public void setMaximumIncomeMax(String maximumIncomeMax){
        this.maximumIncomeMax = maximumIncomeMax;
    }
      
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
    public String getPercentage(){
        return this.percentage;
    }
    public void setPercentage(String percentage){
        this.percentage = percentage;
    }   
    public String getPercentageMin(){
        return this.percentageMin;
    }
    public void setPercentageMin(String percentageMin){
        this.percentageMin = percentageMin;
    }
    public String getPercentageMax(){
        return this.percentageMax;
    }
    public void setPercentageMax(String percentageMax){
        this.percentageMax = percentageMax;
    }
      

}

package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class IncomeStatementDeclarationCriteria extends  BaseCriteria  {

    private String reference;
    private String referenceLike;
    private LocalDateTime declarationDate;
    private LocalDateTime declarationDateFrom;
    private LocalDateTime declarationDateTo;
    private String quarter;
    private String quarterMin;
    private String quarterMax;
    private String year;
    private String yearMin;
    private String yearMax;
    private String totalExpense;
    private String totalExpenseMin;
    private String totalExpenseMax;
    private String totalRevenue;
    private String totalRevenueMin;
    private String totalRevenueMax;
    private String incomeBeforeTax;
    private String incomeBeforeTaxMin;
    private String incomeBeforeTaxMax;
    private String taxAmount;
    private String taxAmountMin;
    private String taxAmountMax;
    private String incomeAfterTax;
    private String incomeAfterTaxMin;
    private String incomeAfterTaxMax;

    private CompanyCriteria company ;
    private List<CompanyCriteria> companys ;
    private CorporateTaxRateCriteria corporateTaxRate ;
    private List<CorporateTaxRateCriteria> corporateTaxRates ;
    private HandlingAccountantCriteria handlingAccountant ;
    private List<HandlingAccountantCriteria> handlingAccountants ;
    private ValidationAccountantCriteria validationAccountant ;
    private List<ValidationAccountantCriteria> validationAccountants ;


    public IncomeStatementDeclarationCriteria(){}

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

    public LocalDateTime getDeclarationDate(){
        return this.declarationDate;
    }
    public void setDeclarationDate(LocalDateTime declarationDate){
        this.declarationDate = declarationDate;
    }
    public LocalDateTime getDeclarationDateFrom(){
        return this.declarationDateFrom;
    }
    public void setDeclarationDateFrom(LocalDateTime declarationDateFrom){
        this.declarationDateFrom = declarationDateFrom;
    }
    public LocalDateTime getDeclarationDateTo(){
        return this.declarationDateTo;
    }
    public void setDeclarationDateTo(LocalDateTime declarationDateTo){
        this.declarationDateTo = declarationDateTo;
    }
    public String getQuarter(){
        return this.quarter;
    }
    public void setQuarter(String quarter){
        this.quarter = quarter;
    }   
    public String getQuarterMin(){
        return this.quarterMin;
    }
    public void setQuarterMin(String quarterMin){
        this.quarterMin = quarterMin;
    }
    public String getQuarterMax(){
        return this.quarterMax;
    }
    public void setQuarterMax(String quarterMax){
        this.quarterMax = quarterMax;
    }
      
    public String getYear(){
        return this.year;
    }
    public void setYear(String year){
        this.year = year;
    }   
    public String getYearMin(){
        return this.yearMin;
    }
    public void setYearMin(String yearMin){
        this.yearMin = yearMin;
    }
    public String getYearMax(){
        return this.yearMax;
    }
    public void setYearMax(String yearMax){
        this.yearMax = yearMax;
    }
      
    public String getTotalExpense(){
        return this.totalExpense;
    }
    public void setTotalExpense(String totalExpense){
        this.totalExpense = totalExpense;
    }   
    public String getTotalExpenseMin(){
        return this.totalExpenseMin;
    }
    public void setTotalExpenseMin(String totalExpenseMin){
        this.totalExpenseMin = totalExpenseMin;
    }
    public String getTotalExpenseMax(){
        return this.totalExpenseMax;
    }
    public void setTotalExpenseMax(String totalExpenseMax){
        this.totalExpenseMax = totalExpenseMax;
    }
      
    public String getTotalRevenue(){
        return this.totalRevenue;
    }
    public void setTotalRevenue(String totalRevenue){
        this.totalRevenue = totalRevenue;
    }   
    public String getTotalRevenueMin(){
        return this.totalRevenueMin;
    }
    public void setTotalRevenueMin(String totalRevenueMin){
        this.totalRevenueMin = totalRevenueMin;
    }
    public String getTotalRevenueMax(){
        return this.totalRevenueMax;
    }
    public void setTotalRevenueMax(String totalRevenueMax){
        this.totalRevenueMax = totalRevenueMax;
    }
      
    public String getIncomeBeforeTax(){
        return this.incomeBeforeTax;
    }
    public void setIncomeBeforeTax(String incomeBeforeTax){
        this.incomeBeforeTax = incomeBeforeTax;
    }   
    public String getIncomeBeforeTaxMin(){
        return this.incomeBeforeTaxMin;
    }
    public void setIncomeBeforeTaxMin(String incomeBeforeTaxMin){
        this.incomeBeforeTaxMin = incomeBeforeTaxMin;
    }
    public String getIncomeBeforeTaxMax(){
        return this.incomeBeforeTaxMax;
    }
    public void setIncomeBeforeTaxMax(String incomeBeforeTaxMax){
        this.incomeBeforeTaxMax = incomeBeforeTaxMax;
    }
      
    public String getTaxAmount(){
        return this.taxAmount;
    }
    public void setTaxAmount(String taxAmount){
        this.taxAmount = taxAmount;
    }   
    public String getTaxAmountMin(){
        return this.taxAmountMin;
    }
    public void setTaxAmountMin(String taxAmountMin){
        this.taxAmountMin = taxAmountMin;
    }
    public String getTaxAmountMax(){
        return this.taxAmountMax;
    }
    public void setTaxAmountMax(String taxAmountMax){
        this.taxAmountMax = taxAmountMax;
    }
      
    public String getIncomeAfterTax(){
        return this.incomeAfterTax;
    }
    public void setIncomeAfterTax(String incomeAfterTax){
        this.incomeAfterTax = incomeAfterTax;
    }   
    public String getIncomeAfterTaxMin(){
        return this.incomeAfterTaxMin;
    }
    public void setIncomeAfterTaxMin(String incomeAfterTaxMin){
        this.incomeAfterTaxMin = incomeAfterTaxMin;
    }
    public String getIncomeAfterTaxMax(){
        return this.incomeAfterTaxMax;
    }
    public void setIncomeAfterTaxMax(String incomeAfterTaxMax){
        this.incomeAfterTaxMax = incomeAfterTaxMax;
    }
      

    public CompanyCriteria getCompany(){
        return this.company;
    }

    public void setCompany(CompanyCriteria company){
        this.company = company;
    }
    public List<CompanyCriteria> getCompanys(){
        return this.companys;
    }

    public void setCompanys(List<CompanyCriteria> companys){
        this.companys = companys;
    }
    public CorporateTaxRateCriteria getCorporateTaxRate(){
        return this.corporateTaxRate;
    }

    public void setCorporateTaxRate(CorporateTaxRateCriteria corporateTaxRate){
        this.corporateTaxRate = corporateTaxRate;
    }
    public List<CorporateTaxRateCriteria> getCorporateTaxRates(){
        return this.corporateTaxRates;
    }

    public void setCorporateTaxRates(List<CorporateTaxRateCriteria> corporateTaxRates){
        this.corporateTaxRates = corporateTaxRates;
    }
    public HandlingAccountantCriteria getHandlingAccountant(){
        return this.handlingAccountant;
    }

    public void setHandlingAccountant(HandlingAccountantCriteria handlingAccountant){
        this.handlingAccountant = handlingAccountant;
    }
    public List<HandlingAccountantCriteria> getHandlingAccountants(){
        return this.handlingAccountants;
    }

    public void setHandlingAccountants(List<HandlingAccountantCriteria> handlingAccountants){
        this.handlingAccountants = handlingAccountants;
    }
    public ValidationAccountantCriteria getValidationAccountant(){
        return this.validationAccountant;
    }

    public void setValidationAccountant(ValidationAccountantCriteria validationAccountant){
        this.validationAccountant = validationAccountant;
    }
    public List<ValidationAccountantCriteria> getValidationAccountants(){
        return this.validationAccountants;
    }

    public void setValidationAccountants(List<ValidationAccountantCriteria> validationAccountants){
        this.validationAccountants = validationAccountants;
    }
}

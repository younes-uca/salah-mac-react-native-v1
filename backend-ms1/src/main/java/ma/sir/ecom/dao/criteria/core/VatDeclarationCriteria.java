package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;
import java.time.LocalDateTime;
import java.time.LocalDate;

public class VatDeclarationCriteria extends  BaseCriteria  {

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
    private String totalCollectedVat;
    private String totalCollectedVatMin;
    private String totalCollectedVatMax;
    private String totalDueVat;
    private String totalDueVatMin;
    private String totalDueVatMax;
    private String vatDifference;
    private String vatDifferenceMin;
    private String vatDifferenceMax;
    private String vatAmount;
    private String vatAmountMin;
    private String vatAmountMax;

    private CompanyCriteria company ;
    private List<CompanyCriteria> companys ;
    private LatePaymentRateCriteria latePaymentRate ;
    private List<LatePaymentRateCriteria> latePaymentRates ;
    private HandlingAccountantCriteria handlingAccountant ;
    private List<HandlingAccountantCriteria> handlingAccountants ;
    private ValidationAccountantCriteria validationAccountant ;
    private List<ValidationAccountantCriteria> validationAccountants ;


    public VatDeclarationCriteria(){}

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
      
    public String getTotalCollectedVat(){
        return this.totalCollectedVat;
    }
    public void setTotalCollectedVat(String totalCollectedVat){
        this.totalCollectedVat = totalCollectedVat;
    }   
    public String getTotalCollectedVatMin(){
        return this.totalCollectedVatMin;
    }
    public void setTotalCollectedVatMin(String totalCollectedVatMin){
        this.totalCollectedVatMin = totalCollectedVatMin;
    }
    public String getTotalCollectedVatMax(){
        return this.totalCollectedVatMax;
    }
    public void setTotalCollectedVatMax(String totalCollectedVatMax){
        this.totalCollectedVatMax = totalCollectedVatMax;
    }
      
    public String getTotalDueVat(){
        return this.totalDueVat;
    }
    public void setTotalDueVat(String totalDueVat){
        this.totalDueVat = totalDueVat;
    }   
    public String getTotalDueVatMin(){
        return this.totalDueVatMin;
    }
    public void setTotalDueVatMin(String totalDueVatMin){
        this.totalDueVatMin = totalDueVatMin;
    }
    public String getTotalDueVatMax(){
        return this.totalDueVatMax;
    }
    public void setTotalDueVatMax(String totalDueVatMax){
        this.totalDueVatMax = totalDueVatMax;
    }
      
    public String getVatDifference(){
        return this.vatDifference;
    }
    public void setVatDifference(String vatDifference){
        this.vatDifference = vatDifference;
    }   
    public String getVatDifferenceMin(){
        return this.vatDifferenceMin;
    }
    public void setVatDifferenceMin(String vatDifferenceMin){
        this.vatDifferenceMin = vatDifferenceMin;
    }
    public String getVatDifferenceMax(){
        return this.vatDifferenceMax;
    }
    public void setVatDifferenceMax(String vatDifferenceMax){
        this.vatDifferenceMax = vatDifferenceMax;
    }
      
    public String getVatAmount(){
        return this.vatAmount;
    }
    public void setVatAmount(String vatAmount){
        this.vatAmount = vatAmount;
    }   
    public String getVatAmountMin(){
        return this.vatAmountMin;
    }
    public void setVatAmountMin(String vatAmountMin){
        this.vatAmountMin = vatAmountMin;
    }
    public String getVatAmountMax(){
        return this.vatAmountMax;
    }
    public void setVatAmountMax(String vatAmountMax){
        this.vatAmountMax = vatAmountMax;
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
    public LatePaymentRateCriteria getLatePaymentRate(){
        return this.latePaymentRate;
    }

    public void setLatePaymentRate(LatePaymentRateCriteria latePaymentRate){
        this.latePaymentRate = latePaymentRate;
    }
    public List<LatePaymentRateCriteria> getLatePaymentRates(){
        return this.latePaymentRates;
    }

    public void setLatePaymentRates(List<LatePaymentRateCriteria> latePaymentRates){
        this.latePaymentRates = latePaymentRates;
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

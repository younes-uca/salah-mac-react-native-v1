package  ma.sir.ecom.dao.criteria.core;


import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import java.util.List;

public class BalanceSheetCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String year;
    private String yearMin;
    private String yearMax;
    private String intangibleAssets;
    private String intangibleAssetsMin;
    private String intangibleAssetsMax;
    private String tangibleAssets;
    private String tangibleAssetsMin;
    private String tangibleAssetsMax;
    private String financialAssets;
    private String financialAssetsMin;
    private String financialAssetsMax;
    private String totalFixedAssets;
    private String totalFixedAssetsMin;
    private String totalFixedAssetsMax;
    private String inventories;
    private String inventoriesMin;
    private String inventoriesMax;
    private String accountsReceivable;
    private String accountsReceivableMin;
    private String accountsReceivableMax;
    private String totalCurrentAssets;
    private String totalCurrentAssetsMin;
    private String totalCurrentAssetsMax;
    private String bankDeposits;
    private String bankDepositsMin;
    private String bankDepositsMax;
    private String cashInHand;
    private String cashInHandMin;
    private String cashInHandMax;
    private String totalTreasuryAssets;
    private String totalTreasuryAssetsMin;
    private String totalTreasuryAssetsMax;
    private String totalAssets;
    private String totalAssetsMin;
    private String totalAssetsMax;
    private String equity;
    private String equityMin;
    private String equityMax;
    private String loans;
    private String loansMin;
    private String loansMax;
    private String profit;
    private String profitMin;
    private String profitMax;
    private String totalPermanentFinancing;
    private String totalPermanentFinancingMin;
    private String totalPermanentFinancingMax;
    private String accountsPayable;
    private String accountsPayableMin;
    private String accountsPayableMax;
    private String otherCurrentLiabilities;
    private String otherCurrentLiabilitiesMin;
    private String otherCurrentLiabilitiesMax;
    private String totalCurrentLiabilities;
    private String totalCurrentLiabilitiesMin;
    private String totalCurrentLiabilitiesMax;
    private String totalLiabilities;
    private String totalLiabilitiesMin;
    private String totalLiabilitiesMax;

    private CompanyCriteria company ;
    private List<CompanyCriteria> companys ;
    private BalanceSheetStatusCriteria balanceSheetStatus ;
    private List<BalanceSheetStatusCriteria> balanceSheetStatuss ;


    public BalanceSheetCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
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
      
    public String getIntangibleAssets(){
        return this.intangibleAssets;
    }
    public void setIntangibleAssets(String intangibleAssets){
        this.intangibleAssets = intangibleAssets;
    }   
    public String getIntangibleAssetsMin(){
        return this.intangibleAssetsMin;
    }
    public void setIntangibleAssetsMin(String intangibleAssetsMin){
        this.intangibleAssetsMin = intangibleAssetsMin;
    }
    public String getIntangibleAssetsMax(){
        return this.intangibleAssetsMax;
    }
    public void setIntangibleAssetsMax(String intangibleAssetsMax){
        this.intangibleAssetsMax = intangibleAssetsMax;
    }
      
    public String getTangibleAssets(){
        return this.tangibleAssets;
    }
    public void setTangibleAssets(String tangibleAssets){
        this.tangibleAssets = tangibleAssets;
    }   
    public String getTangibleAssetsMin(){
        return this.tangibleAssetsMin;
    }
    public void setTangibleAssetsMin(String tangibleAssetsMin){
        this.tangibleAssetsMin = tangibleAssetsMin;
    }
    public String getTangibleAssetsMax(){
        return this.tangibleAssetsMax;
    }
    public void setTangibleAssetsMax(String tangibleAssetsMax){
        this.tangibleAssetsMax = tangibleAssetsMax;
    }
      
    public String getFinancialAssets(){
        return this.financialAssets;
    }
    public void setFinancialAssets(String financialAssets){
        this.financialAssets = financialAssets;
    }   
    public String getFinancialAssetsMin(){
        return this.financialAssetsMin;
    }
    public void setFinancialAssetsMin(String financialAssetsMin){
        this.financialAssetsMin = financialAssetsMin;
    }
    public String getFinancialAssetsMax(){
        return this.financialAssetsMax;
    }
    public void setFinancialAssetsMax(String financialAssetsMax){
        this.financialAssetsMax = financialAssetsMax;
    }
      
    public String getTotalFixedAssets(){
        return this.totalFixedAssets;
    }
    public void setTotalFixedAssets(String totalFixedAssets){
        this.totalFixedAssets = totalFixedAssets;
    }   
    public String getTotalFixedAssetsMin(){
        return this.totalFixedAssetsMin;
    }
    public void setTotalFixedAssetsMin(String totalFixedAssetsMin){
        this.totalFixedAssetsMin = totalFixedAssetsMin;
    }
    public String getTotalFixedAssetsMax(){
        return this.totalFixedAssetsMax;
    }
    public void setTotalFixedAssetsMax(String totalFixedAssetsMax){
        this.totalFixedAssetsMax = totalFixedAssetsMax;
    }
      
    public String getInventories(){
        return this.inventories;
    }
    public void setInventories(String inventories){
        this.inventories = inventories;
    }   
    public String getInventoriesMin(){
        return this.inventoriesMin;
    }
    public void setInventoriesMin(String inventoriesMin){
        this.inventoriesMin = inventoriesMin;
    }
    public String getInventoriesMax(){
        return this.inventoriesMax;
    }
    public void setInventoriesMax(String inventoriesMax){
        this.inventoriesMax = inventoriesMax;
    }
      
    public String getAccountsReceivable(){
        return this.accountsReceivable;
    }
    public void setAccountsReceivable(String accountsReceivable){
        this.accountsReceivable = accountsReceivable;
    }   
    public String getAccountsReceivableMin(){
        return this.accountsReceivableMin;
    }
    public void setAccountsReceivableMin(String accountsReceivableMin){
        this.accountsReceivableMin = accountsReceivableMin;
    }
    public String getAccountsReceivableMax(){
        return this.accountsReceivableMax;
    }
    public void setAccountsReceivableMax(String accountsReceivableMax){
        this.accountsReceivableMax = accountsReceivableMax;
    }
      
    public String getTotalCurrentAssets(){
        return this.totalCurrentAssets;
    }
    public void setTotalCurrentAssets(String totalCurrentAssets){
        this.totalCurrentAssets = totalCurrentAssets;
    }   
    public String getTotalCurrentAssetsMin(){
        return this.totalCurrentAssetsMin;
    }
    public void setTotalCurrentAssetsMin(String totalCurrentAssetsMin){
        this.totalCurrentAssetsMin = totalCurrentAssetsMin;
    }
    public String getTotalCurrentAssetsMax(){
        return this.totalCurrentAssetsMax;
    }
    public void setTotalCurrentAssetsMax(String totalCurrentAssetsMax){
        this.totalCurrentAssetsMax = totalCurrentAssetsMax;
    }
      
    public String getBankDeposits(){
        return this.bankDeposits;
    }
    public void setBankDeposits(String bankDeposits){
        this.bankDeposits = bankDeposits;
    }   
    public String getBankDepositsMin(){
        return this.bankDepositsMin;
    }
    public void setBankDepositsMin(String bankDepositsMin){
        this.bankDepositsMin = bankDepositsMin;
    }
    public String getBankDepositsMax(){
        return this.bankDepositsMax;
    }
    public void setBankDepositsMax(String bankDepositsMax){
        this.bankDepositsMax = bankDepositsMax;
    }
      
    public String getCashInHand(){
        return this.cashInHand;
    }
    public void setCashInHand(String cashInHand){
        this.cashInHand = cashInHand;
    }   
    public String getCashInHandMin(){
        return this.cashInHandMin;
    }
    public void setCashInHandMin(String cashInHandMin){
        this.cashInHandMin = cashInHandMin;
    }
    public String getCashInHandMax(){
        return this.cashInHandMax;
    }
    public void setCashInHandMax(String cashInHandMax){
        this.cashInHandMax = cashInHandMax;
    }
      
    public String getTotalTreasuryAssets(){
        return this.totalTreasuryAssets;
    }
    public void setTotalTreasuryAssets(String totalTreasuryAssets){
        this.totalTreasuryAssets = totalTreasuryAssets;
    }   
    public String getTotalTreasuryAssetsMin(){
        return this.totalTreasuryAssetsMin;
    }
    public void setTotalTreasuryAssetsMin(String totalTreasuryAssetsMin){
        this.totalTreasuryAssetsMin = totalTreasuryAssetsMin;
    }
    public String getTotalTreasuryAssetsMax(){
        return this.totalTreasuryAssetsMax;
    }
    public void setTotalTreasuryAssetsMax(String totalTreasuryAssetsMax){
        this.totalTreasuryAssetsMax = totalTreasuryAssetsMax;
    }
      
    public String getTotalAssets(){
        return this.totalAssets;
    }
    public void setTotalAssets(String totalAssets){
        this.totalAssets = totalAssets;
    }   
    public String getTotalAssetsMin(){
        return this.totalAssetsMin;
    }
    public void setTotalAssetsMin(String totalAssetsMin){
        this.totalAssetsMin = totalAssetsMin;
    }
    public String getTotalAssetsMax(){
        return this.totalAssetsMax;
    }
    public void setTotalAssetsMax(String totalAssetsMax){
        this.totalAssetsMax = totalAssetsMax;
    }
      
    public String getEquity(){
        return this.equity;
    }
    public void setEquity(String equity){
        this.equity = equity;
    }   
    public String getEquityMin(){
        return this.equityMin;
    }
    public void setEquityMin(String equityMin){
        this.equityMin = equityMin;
    }
    public String getEquityMax(){
        return this.equityMax;
    }
    public void setEquityMax(String equityMax){
        this.equityMax = equityMax;
    }
      
    public String getLoans(){
        return this.loans;
    }
    public void setLoans(String loans){
        this.loans = loans;
    }   
    public String getLoansMin(){
        return this.loansMin;
    }
    public void setLoansMin(String loansMin){
        this.loansMin = loansMin;
    }
    public String getLoansMax(){
        return this.loansMax;
    }
    public void setLoansMax(String loansMax){
        this.loansMax = loansMax;
    }
      
    public String getProfit(){
        return this.profit;
    }
    public void setProfit(String profit){
        this.profit = profit;
    }   
    public String getProfitMin(){
        return this.profitMin;
    }
    public void setProfitMin(String profitMin){
        this.profitMin = profitMin;
    }
    public String getProfitMax(){
        return this.profitMax;
    }
    public void setProfitMax(String profitMax){
        this.profitMax = profitMax;
    }
      
    public String getTotalPermanentFinancing(){
        return this.totalPermanentFinancing;
    }
    public void setTotalPermanentFinancing(String totalPermanentFinancing){
        this.totalPermanentFinancing = totalPermanentFinancing;
    }   
    public String getTotalPermanentFinancingMin(){
        return this.totalPermanentFinancingMin;
    }
    public void setTotalPermanentFinancingMin(String totalPermanentFinancingMin){
        this.totalPermanentFinancingMin = totalPermanentFinancingMin;
    }
    public String getTotalPermanentFinancingMax(){
        return this.totalPermanentFinancingMax;
    }
    public void setTotalPermanentFinancingMax(String totalPermanentFinancingMax){
        this.totalPermanentFinancingMax = totalPermanentFinancingMax;
    }
      
    public String getAccountsPayable(){
        return this.accountsPayable;
    }
    public void setAccountsPayable(String accountsPayable){
        this.accountsPayable = accountsPayable;
    }   
    public String getAccountsPayableMin(){
        return this.accountsPayableMin;
    }
    public void setAccountsPayableMin(String accountsPayableMin){
        this.accountsPayableMin = accountsPayableMin;
    }
    public String getAccountsPayableMax(){
        return this.accountsPayableMax;
    }
    public void setAccountsPayableMax(String accountsPayableMax){
        this.accountsPayableMax = accountsPayableMax;
    }
      
    public String getOtherCurrentLiabilities(){
        return this.otherCurrentLiabilities;
    }
    public void setOtherCurrentLiabilities(String otherCurrentLiabilities){
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    }   
    public String getOtherCurrentLiabilitiesMin(){
        return this.otherCurrentLiabilitiesMin;
    }
    public void setOtherCurrentLiabilitiesMin(String otherCurrentLiabilitiesMin){
        this.otherCurrentLiabilitiesMin = otherCurrentLiabilitiesMin;
    }
    public String getOtherCurrentLiabilitiesMax(){
        return this.otherCurrentLiabilitiesMax;
    }
    public void setOtherCurrentLiabilitiesMax(String otherCurrentLiabilitiesMax){
        this.otherCurrentLiabilitiesMax = otherCurrentLiabilitiesMax;
    }
      
    public String getTotalCurrentLiabilities(){
        return this.totalCurrentLiabilities;
    }
    public void setTotalCurrentLiabilities(String totalCurrentLiabilities){
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    }   
    public String getTotalCurrentLiabilitiesMin(){
        return this.totalCurrentLiabilitiesMin;
    }
    public void setTotalCurrentLiabilitiesMin(String totalCurrentLiabilitiesMin){
        this.totalCurrentLiabilitiesMin = totalCurrentLiabilitiesMin;
    }
    public String getTotalCurrentLiabilitiesMax(){
        return this.totalCurrentLiabilitiesMax;
    }
    public void setTotalCurrentLiabilitiesMax(String totalCurrentLiabilitiesMax){
        this.totalCurrentLiabilitiesMax = totalCurrentLiabilitiesMax;
    }
      
    public String getTotalLiabilities(){
        return this.totalLiabilities;
    }
    public void setTotalLiabilities(String totalLiabilities){
        this.totalLiabilities = totalLiabilities;
    }   
    public String getTotalLiabilitiesMin(){
        return this.totalLiabilitiesMin;
    }
    public void setTotalLiabilitiesMin(String totalLiabilitiesMin){
        this.totalLiabilitiesMin = totalLiabilitiesMin;
    }
    public String getTotalLiabilitiesMax(){
        return this.totalLiabilitiesMax;
    }
    public void setTotalLiabilitiesMax(String totalLiabilitiesMax){
        this.totalLiabilitiesMax = totalLiabilitiesMax;
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
    public BalanceSheetStatusCriteria getBalanceSheetStatus(){
        return this.balanceSheetStatus;
    }

    public void setBalanceSheetStatus(BalanceSheetStatusCriteria balanceSheetStatus){
        this.balanceSheetStatus = balanceSheetStatus;
    }
    public List<BalanceSheetStatusCriteria> getBalanceSheetStatuss(){
        return this.balanceSheetStatuss;
    }

    public void setBalanceSheetStatuss(List<BalanceSheetStatusCriteria> balanceSheetStatuss){
        this.balanceSheetStatuss = balanceSheetStatuss;
    }
}

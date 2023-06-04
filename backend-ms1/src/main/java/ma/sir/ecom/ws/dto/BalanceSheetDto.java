package  ma.sir.ecom.ws.dto;

import ma.sir.ecom.zynerator.audit.Log;
import ma.sir.ecom.zynerator.dto.AuditBaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BalanceSheetDto  extends AuditBaseDto {

    private String ref  ;
    private Integer year  = 0 ;
    private BigDecimal intangibleAssets  ;
    private BigDecimal tangibleAssets  ;
    private BigDecimal financialAssets  ;
    private BigDecimal totalFixedAssets  ;
    private BigDecimal inventories  ;
    private BigDecimal accountsReceivable  ;
    private BigDecimal totalCurrentAssets  ;
    private BigDecimal bankDeposits  ;
    private BigDecimal cashInHand  ;
    private BigDecimal totalTreasuryAssets  ;
    private BigDecimal totalAssets  ;
    private BigDecimal equity  ;
    private BigDecimal loans  ;
    private BigDecimal profit  ;
    private BigDecimal totalPermanentFinancing  ;
    private BigDecimal accountsPayable  ;
    private BigDecimal otherCurrentLiabilities  ;
    private BigDecimal totalCurrentLiabilities  ;
    private BigDecimal totalLiabilities  ;

    private CompanyDto company ;
    private BalanceSheetStatusDto balanceSheetStatus ;



    public BalanceSheetDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }

    @Log
    public BigDecimal getIntangibleAssets(){
        return this.intangibleAssets;
    }
    public void setIntangibleAssets(BigDecimal intangibleAssets){
        this.intangibleAssets = intangibleAssets;
    }

    @Log
    public BigDecimal getTangibleAssets(){
        return this.tangibleAssets;
    }
    public void setTangibleAssets(BigDecimal tangibleAssets){
        this.tangibleAssets = tangibleAssets;
    }

    @Log
    public BigDecimal getFinancialAssets(){
        return this.financialAssets;
    }
    public void setFinancialAssets(BigDecimal financialAssets){
        this.financialAssets = financialAssets;
    }

    @Log
    public BigDecimal getTotalFixedAssets(){
        return this.totalFixedAssets;
    }
    public void setTotalFixedAssets(BigDecimal totalFixedAssets){
        this.totalFixedAssets = totalFixedAssets;
    }

    @Log
    public BigDecimal getInventories(){
        return this.inventories;
    }
    public void setInventories(BigDecimal inventories){
        this.inventories = inventories;
    }

    @Log
    public BigDecimal getAccountsReceivable(){
        return this.accountsReceivable;
    }
    public void setAccountsReceivable(BigDecimal accountsReceivable){
        this.accountsReceivable = accountsReceivable;
    }

    @Log
    public BigDecimal getTotalCurrentAssets(){
        return this.totalCurrentAssets;
    }
    public void setTotalCurrentAssets(BigDecimal totalCurrentAssets){
        this.totalCurrentAssets = totalCurrentAssets;
    }

    @Log
    public BigDecimal getBankDeposits(){
        return this.bankDeposits;
    }
    public void setBankDeposits(BigDecimal bankDeposits){
        this.bankDeposits = bankDeposits;
    }

    @Log
    public BigDecimal getCashInHand(){
        return this.cashInHand;
    }
    public void setCashInHand(BigDecimal cashInHand){
        this.cashInHand = cashInHand;
    }

    @Log
    public BigDecimal getTotalTreasuryAssets(){
        return this.totalTreasuryAssets;
    }
    public void setTotalTreasuryAssets(BigDecimal totalTreasuryAssets){
        this.totalTreasuryAssets = totalTreasuryAssets;
    }

    @Log
    public BigDecimal getTotalAssets(){
        return this.totalAssets;
    }
    public void setTotalAssets(BigDecimal totalAssets){
        this.totalAssets = totalAssets;
    }

    @Log
    public BigDecimal getEquity(){
        return this.equity;
    }
    public void setEquity(BigDecimal equity){
        this.equity = equity;
    }

    @Log
    public BigDecimal getLoans(){
        return this.loans;
    }
    public void setLoans(BigDecimal loans){
        this.loans = loans;
    }

    @Log
    public BigDecimal getProfit(){
        return this.profit;
    }
    public void setProfit(BigDecimal profit){
        this.profit = profit;
    }

    @Log
    public BigDecimal getTotalPermanentFinancing(){
        return this.totalPermanentFinancing;
    }
    public void setTotalPermanentFinancing(BigDecimal totalPermanentFinancing){
        this.totalPermanentFinancing = totalPermanentFinancing;
    }

    @Log
    public BigDecimal getAccountsPayable(){
        return this.accountsPayable;
    }
    public void setAccountsPayable(BigDecimal accountsPayable){
        this.accountsPayable = accountsPayable;
    }

    @Log
    public BigDecimal getOtherCurrentLiabilities(){
        return this.otherCurrentLiabilities;
    }
    public void setOtherCurrentLiabilities(BigDecimal otherCurrentLiabilities){
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    }

    @Log
    public BigDecimal getTotalCurrentLiabilities(){
        return this.totalCurrentLiabilities;
    }
    public void setTotalCurrentLiabilities(BigDecimal totalCurrentLiabilities){
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    }

    @Log
    public BigDecimal getTotalLiabilities(){
        return this.totalLiabilities;
    }
    public void setTotalLiabilities(BigDecimal totalLiabilities){
        this.totalLiabilities = totalLiabilities;
    }


    public CompanyDto getCompany(){
        return this.company;
    }

    public void setCompany(CompanyDto company){
        this.company = company;
    }
    public BalanceSheetStatusDto getBalanceSheetStatus(){
        return this.balanceSheetStatus;
    }

    public void setBalanceSheetStatus(BalanceSheetStatusDto balanceSheetStatus){
        this.balanceSheetStatus = balanceSheetStatus;
    }




}

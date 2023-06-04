package ma.sir.ecom.bean.core;

import java.util.Objects;






import com.fasterxml.jackson.annotation.JsonInclude;
import ma.sir.ecom.zynerator.audit.AuditBusinessObject;
import javax.persistence.*;
import java.util.Objects;


import java.math.BigDecimal;


@Entity
@Table(name = "balance_sheet")
@JsonInclude(JsonInclude.Include.NON_NULL)
@SequenceGenerator(name="balance_sheet_seq",sequenceName="balance_sheet_seq",allocationSize=1, initialValue = 1)
public class BalanceSheet   extends AuditBusinessObject     {

    private Long id;

    @Column(length = 500)
    private String ref;
    private Integer year = 0;
    private BigDecimal intangibleAssets = BigDecimal.ZERO;
    private BigDecimal tangibleAssets = BigDecimal.ZERO;
    private BigDecimal financialAssets = BigDecimal.ZERO;
    private BigDecimal totalFixedAssets = BigDecimal.ZERO;
    private BigDecimal inventories = BigDecimal.ZERO;
    private BigDecimal accountsReceivable = BigDecimal.ZERO;
    private BigDecimal totalCurrentAssets = BigDecimal.ZERO;
    private BigDecimal bankDeposits = BigDecimal.ZERO;
    private BigDecimal cashInHand = BigDecimal.ZERO;
    private BigDecimal totalTreasuryAssets = BigDecimal.ZERO;
    private BigDecimal totalAssets = BigDecimal.ZERO;
    private BigDecimal equity = BigDecimal.ZERO;
    private BigDecimal loans = BigDecimal.ZERO;
    private BigDecimal profit = BigDecimal.ZERO;
    private BigDecimal totalPermanentFinancing = BigDecimal.ZERO;
    private BigDecimal accountsPayable = BigDecimal.ZERO;
    private BigDecimal otherCurrentLiabilities = BigDecimal.ZERO;
    private BigDecimal totalCurrentLiabilities = BigDecimal.ZERO;
    private BigDecimal totalLiabilities = BigDecimal.ZERO;

    private Company company ;
    
    private BalanceSheetStatus balanceSheetStatus ;
    


    public BalanceSheet(){
        super();
    }

    public BalanceSheet(Long id,String ref){
        this.id = id;
        this.ref = ref ;
    }




    @Id
    @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="balance_sheet_seq")
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public Integer getYear(){
        return this.year;
    }
    public void setYear(Integer year){
        this.year = year;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public Company getCompany(){
        return this.company;
    }
    public void setCompany(Company company){
        this.company = company;
    }
    public BigDecimal getIntangibleAssets(){
        return this.intangibleAssets;
    }
    public void setIntangibleAssets(BigDecimal intangibleAssets){
        this.intangibleAssets = intangibleAssets;
    }
    public BigDecimal getTangibleAssets(){
        return this.tangibleAssets;
    }
    public void setTangibleAssets(BigDecimal tangibleAssets){
        this.tangibleAssets = tangibleAssets;
    }
    public BigDecimal getFinancialAssets(){
        return this.financialAssets;
    }
    public void setFinancialAssets(BigDecimal financialAssets){
        this.financialAssets = financialAssets;
    }
    public BigDecimal getTotalFixedAssets(){
        return this.totalFixedAssets;
    }
    public void setTotalFixedAssets(BigDecimal totalFixedAssets){
        this.totalFixedAssets = totalFixedAssets;
    }
    public BigDecimal getInventories(){
        return this.inventories;
    }
    public void setInventories(BigDecimal inventories){
        this.inventories = inventories;
    }
    public BigDecimal getAccountsReceivable(){
        return this.accountsReceivable;
    }
    public void setAccountsReceivable(BigDecimal accountsReceivable){
        this.accountsReceivable = accountsReceivable;
    }
    public BigDecimal getTotalCurrentAssets(){
        return this.totalCurrentAssets;
    }
    public void setTotalCurrentAssets(BigDecimal totalCurrentAssets){
        this.totalCurrentAssets = totalCurrentAssets;
    }
    public BigDecimal getBankDeposits(){
        return this.bankDeposits;
    }
    public void setBankDeposits(BigDecimal bankDeposits){
        this.bankDeposits = bankDeposits;
    }
    public BigDecimal getCashInHand(){
        return this.cashInHand;
    }
    public void setCashInHand(BigDecimal cashInHand){
        this.cashInHand = cashInHand;
    }
    public BigDecimal getTotalTreasuryAssets(){
        return this.totalTreasuryAssets;
    }
    public void setTotalTreasuryAssets(BigDecimal totalTreasuryAssets){
        this.totalTreasuryAssets = totalTreasuryAssets;
    }
    public BigDecimal getTotalAssets(){
        return this.totalAssets;
    }
    public void setTotalAssets(BigDecimal totalAssets){
        this.totalAssets = totalAssets;
    }
    public BigDecimal getEquity(){
        return this.equity;
    }
    public void setEquity(BigDecimal equity){
        this.equity = equity;
    }
    public BigDecimal getLoans(){
        return this.loans;
    }
    public void setLoans(BigDecimal loans){
        this.loans = loans;
    }
    public BigDecimal getProfit(){
        return this.profit;
    }
    public void setProfit(BigDecimal profit){
        this.profit = profit;
    }
    public BigDecimal getTotalPermanentFinancing(){
        return this.totalPermanentFinancing;
    }
    public void setTotalPermanentFinancing(BigDecimal totalPermanentFinancing){
        this.totalPermanentFinancing = totalPermanentFinancing;
    }
    public BigDecimal getAccountsPayable(){
        return this.accountsPayable;
    }
    public void setAccountsPayable(BigDecimal accountsPayable){
        this.accountsPayable = accountsPayable;
    }
    public BigDecimal getOtherCurrentLiabilities(){
        return this.otherCurrentLiabilities;
    }
    public void setOtherCurrentLiabilities(BigDecimal otherCurrentLiabilities){
        this.otherCurrentLiabilities = otherCurrentLiabilities;
    }
    public BigDecimal getTotalCurrentLiabilities(){
        return this.totalCurrentLiabilities;
    }
    public void setTotalCurrentLiabilities(BigDecimal totalCurrentLiabilities){
        this.totalCurrentLiabilities = totalCurrentLiabilities;
    }
    public BigDecimal getTotalLiabilities(){
        return this.totalLiabilities;
    }
    public void setTotalLiabilities(BigDecimal totalLiabilities){
        this.totalLiabilities = totalLiabilities;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    public BalanceSheetStatus getBalanceSheetStatus(){
        return this.balanceSheetStatus;
    }
    public void setBalanceSheetStatus(BalanceSheetStatus balanceSheetStatus){
        this.balanceSheetStatus = balanceSheetStatus;
    }

    @Transient
    public String getLabel() {
        label = ref;
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceSheet balanceSheet = (BalanceSheet) o;
        return id != null && id.equals(balanceSheet.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


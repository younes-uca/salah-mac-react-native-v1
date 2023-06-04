package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.BalanceSheetCriteria;
import ma.sir.ecom.bean.core.BalanceSheet;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BalanceSheetSpecification extends  AbstractSpecification<BalanceSheetCriteria, BalanceSheet>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateInt("year", criteria.getYear(), criteria.getYearMin(), criteria.getYearMax());
        addPredicateBigDecimal("intangibleAssets", criteria.getIntangibleAssets(), criteria.getIntangibleAssetsMin(), criteria.getIntangibleAssetsMax());
        addPredicateBigDecimal("tangibleAssets", criteria.getTangibleAssets(), criteria.getTangibleAssetsMin(), criteria.getTangibleAssetsMax());
        addPredicateBigDecimal("financialAssets", criteria.getFinancialAssets(), criteria.getFinancialAssetsMin(), criteria.getFinancialAssetsMax());
        addPredicateBigDecimal("totalFixedAssets", criteria.getTotalFixedAssets(), criteria.getTotalFixedAssetsMin(), criteria.getTotalFixedAssetsMax());
        addPredicateBigDecimal("inventories", criteria.getInventories(), criteria.getInventoriesMin(), criteria.getInventoriesMax());
        addPredicateBigDecimal("accountsReceivable", criteria.getAccountsReceivable(), criteria.getAccountsReceivableMin(), criteria.getAccountsReceivableMax());
        addPredicateBigDecimal("totalCurrentAssets", criteria.getTotalCurrentAssets(), criteria.getTotalCurrentAssetsMin(), criteria.getTotalCurrentAssetsMax());
        addPredicateBigDecimal("bankDeposits", criteria.getBankDeposits(), criteria.getBankDepositsMin(), criteria.getBankDepositsMax());
        addPredicateBigDecimal("cashInHand", criteria.getCashInHand(), criteria.getCashInHandMin(), criteria.getCashInHandMax());
        addPredicateBigDecimal("totalTreasuryAssets", criteria.getTotalTreasuryAssets(), criteria.getTotalTreasuryAssetsMin(), criteria.getTotalTreasuryAssetsMax());
        addPredicateBigDecimal("totalAssets", criteria.getTotalAssets(), criteria.getTotalAssetsMin(), criteria.getTotalAssetsMax());
        addPredicateBigDecimal("equity", criteria.getEquity(), criteria.getEquityMin(), criteria.getEquityMax());
        addPredicateBigDecimal("loans", criteria.getLoans(), criteria.getLoansMin(), criteria.getLoansMax());
        addPredicateBigDecimal("profit", criteria.getProfit(), criteria.getProfitMin(), criteria.getProfitMax());
        addPredicateBigDecimal("totalPermanentFinancing", criteria.getTotalPermanentFinancing(), criteria.getTotalPermanentFinancingMin(), criteria.getTotalPermanentFinancingMax());
        addPredicateBigDecimal("accountsPayable", criteria.getAccountsPayable(), criteria.getAccountsPayableMin(), criteria.getAccountsPayableMax());
        addPredicateBigDecimal("otherCurrentLiabilities", criteria.getOtherCurrentLiabilities(), criteria.getOtherCurrentLiabilitiesMin(), criteria.getOtherCurrentLiabilitiesMax());
        addPredicateBigDecimal("totalCurrentLiabilities", criteria.getTotalCurrentLiabilities(), criteria.getTotalCurrentLiabilitiesMin(), criteria.getTotalCurrentLiabilitiesMax());
        addPredicateBigDecimal("totalLiabilities", criteria.getTotalLiabilities(), criteria.getTotalLiabilitiesMin(), criteria.getTotalLiabilitiesMax());
        addPredicateFk("company","id", criteria.getCompany()==null?null:criteria.getCompany().getId());
        addPredicateFk("company","id", criteria.getCompanys());
        addPredicateFk("company","ice", criteria.getCompany()==null?null:criteria.getCompany().getIce());
        addPredicateFk("balanceSheetStatus","id", criteria.getBalanceSheetStatus()==null?null:criteria.getBalanceSheetStatus().getId());
        addPredicateFk("balanceSheetStatus","id", criteria.getBalanceSheetStatuss());
        addPredicateFk("balanceSheetStatus","code", criteria.getBalanceSheetStatus()==null?null:criteria.getBalanceSheetStatus().getCode());
    }

    public BalanceSheetSpecification(BalanceSheetCriteria criteria) {
        super(criteria);
    }

    public BalanceSheetSpecification(BalanceSheetCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

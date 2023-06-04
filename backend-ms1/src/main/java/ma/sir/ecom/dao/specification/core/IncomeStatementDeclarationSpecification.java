package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.IncomeStatementDeclarationCriteria;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class IncomeStatementDeclarationSpecification extends  AbstractSpecification<IncomeStatementDeclarationCriteria, IncomeStatementDeclaration>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("declarationDate", criteria.getDeclarationDate(), criteria.getDeclarationDateFrom(), criteria.getDeclarationDateTo());
        addPredicateInt("quarter", criteria.getQuarter(), criteria.getQuarterMin(), criteria.getQuarterMax());
        addPredicateInt("year", criteria.getYear(), criteria.getYearMin(), criteria.getYearMax());
        addPredicateBigDecimal("totalExpense", criteria.getTotalExpense(), criteria.getTotalExpenseMin(), criteria.getTotalExpenseMax());
        addPredicateBigDecimal("totalRevenue", criteria.getTotalRevenue(), criteria.getTotalRevenueMin(), criteria.getTotalRevenueMax());
        addPredicateBigDecimal("incomeBeforeTax", criteria.getIncomeBeforeTax(), criteria.getIncomeBeforeTaxMin(), criteria.getIncomeBeforeTaxMax());
        addPredicateBigDecimal("taxAmount", criteria.getTaxAmount(), criteria.getTaxAmountMin(), criteria.getTaxAmountMax());
        addPredicateBigDecimal("incomeAfterTax", criteria.getIncomeAfterTax(), criteria.getIncomeAfterTaxMin(), criteria.getIncomeAfterTaxMax());
        addPredicateFk("company","id", criteria.getCompany()==null?null:criteria.getCompany().getId());
        addPredicateFk("company","id", criteria.getCompanys());
        addPredicateFk("company","ice", criteria.getCompany()==null?null:criteria.getCompany().getIce());
        addPredicateFk("corporateTaxRate","id", criteria.getCorporateTaxRate()==null?null:criteria.getCorporateTaxRate().getId());
        addPredicateFk("corporateTaxRate","id", criteria.getCorporateTaxRates());
        addPredicateFk("handlingAccountant","id", criteria.getHandlingAccountant()==null?null:criteria.getHandlingAccountant().getId());
        addPredicateFk("handlingAccountant","id", criteria.getHandlingAccountants());
        addPredicateFk("handlingAccountant","cin", criteria.getHandlingAccountant()==null?null:criteria.getHandlingAccountant().getCin());
        addPredicateFk("validationAccountant","id", criteria.getValidationAccountant()==null?null:criteria.getValidationAccountant().getId());
        addPredicateFk("validationAccountant","id", criteria.getValidationAccountants());
        addPredicateFk("validationAccountant","cin", criteria.getValidationAccountant()==null?null:criteria.getValidationAccountant().getCin());
    }

    public IncomeStatementDeclarationSpecification(IncomeStatementDeclarationCriteria criteria) {
        super(criteria);
    }

    public IncomeStatementDeclarationSpecification(IncomeStatementDeclarationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

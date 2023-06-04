package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.VatDeclarationCriteria;
import ma.sir.ecom.bean.core.VatDeclaration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class VatDeclarationSpecification extends  AbstractSpecification<VatDeclarationCriteria, VatDeclaration>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("declarationDate", criteria.getDeclarationDate(), criteria.getDeclarationDateFrom(), criteria.getDeclarationDateTo());
        addPredicateInt("quarter", criteria.getQuarter(), criteria.getQuarterMin(), criteria.getQuarterMax());
        addPredicateInt("year", criteria.getYear(), criteria.getYearMin(), criteria.getYearMax());
        addPredicateBigDecimal("totalCollectedVat", criteria.getTotalCollectedVat(), criteria.getTotalCollectedVatMin(), criteria.getTotalCollectedVatMax());
        addPredicateBigDecimal("totalDueVat", criteria.getTotalDueVat(), criteria.getTotalDueVatMin(), criteria.getTotalDueVatMax());
        addPredicateBigDecimal("vatDifference", criteria.getVatDifference(), criteria.getVatDifferenceMin(), criteria.getVatDifferenceMax());
        addPredicateBigDecimal("vatAmount", criteria.getVatAmount(), criteria.getVatAmountMin(), criteria.getVatAmountMax());
        addPredicateFk("company","id", criteria.getCompany()==null?null:criteria.getCompany().getId());
        addPredicateFk("company","id", criteria.getCompanys());
        addPredicateFk("company","ice", criteria.getCompany()==null?null:criteria.getCompany().getIce());
        addPredicateFk("latePaymentRate","id", criteria.getLatePaymentRate()==null?null:criteria.getLatePaymentRate().getId());
        addPredicateFk("latePaymentRate","id", criteria.getLatePaymentRates());
        addPredicateFk("handlingAccountant","id", criteria.getHandlingAccountant()==null?null:criteria.getHandlingAccountant().getId());
        addPredicateFk("handlingAccountant","id", criteria.getHandlingAccountants());
        addPredicateFk("handlingAccountant","cin", criteria.getHandlingAccountant()==null?null:criteria.getHandlingAccountant().getCin());
        addPredicateFk("validationAccountant","id", criteria.getValidationAccountant()==null?null:criteria.getValidationAccountant().getId());
        addPredicateFk("validationAccountant","id", criteria.getValidationAccountants());
        addPredicateFk("validationAccountant","cin", criteria.getValidationAccountant()==null?null:criteria.getValidationAccountant().getCin());
    }

    public VatDeclarationSpecification(VatDeclarationCriteria criteria) {
        super(criteria);
    }

    public VatDeclarationSpecification(VatDeclarationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

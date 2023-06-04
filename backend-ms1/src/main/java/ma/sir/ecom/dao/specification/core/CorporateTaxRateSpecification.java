package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.CorporateTaxRateCriteria;
import ma.sir.ecom.bean.core.CorporateTaxRate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CorporateTaxRateSpecification extends  AbstractSpecification<CorporateTaxRateCriteria, CorporateTaxRate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("minimumIncome", criteria.getMinimumIncome(), criteria.getMinimumIncomeMin(), criteria.getMinimumIncomeMax());
        addPredicateBigDecimal("maximumIncome", criteria.getMaximumIncome(), criteria.getMaximumIncomeMin(), criteria.getMaximumIncomeMax());
        addPredicate("minApplicationDate", criteria.getMinApplicationDate(), criteria.getMinApplicationDateFrom(), criteria.getMinApplicationDateTo());
        addPredicate("maxApplicationDate", criteria.getMaxApplicationDate(), criteria.getMaxApplicationDateFrom(), criteria.getMaxApplicationDateTo());
        addPredicateBigDecimal("percentage", criteria.getPercentage(), criteria.getPercentageMin(), criteria.getPercentageMax());
    }

    public CorporateTaxRateSpecification(CorporateTaxRateCriteria criteria) {
        super(criteria);
    }

    public CorporateTaxRateSpecification(CorporateTaxRateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

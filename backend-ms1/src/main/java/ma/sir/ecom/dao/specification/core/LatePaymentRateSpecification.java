package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.LatePaymentRateCriteria;
import ma.sir.ecom.bean.core.LatePaymentRate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class LatePaymentRateSpecification extends  AbstractSpecification<LatePaymentRateCriteria, LatePaymentRate>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("minApplicationDate", criteria.getMinApplicationDate(), criteria.getMinApplicationDateFrom(), criteria.getMinApplicationDateTo());
        addPredicate("maxApplicationDate", criteria.getMaxApplicationDate(), criteria.getMaxApplicationDateFrom(), criteria.getMaxApplicationDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
    }

    public LatePaymentRateSpecification(LatePaymentRateCriteria criteria) {
        super(criteria);
    }

    public LatePaymentRateSpecification(LatePaymentRateCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

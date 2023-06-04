package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.DemandPaymentCriteria;
import ma.sir.ecom.bean.core.DemandPayment;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DemandPaymentSpecification extends  AbstractSpecification<DemandPaymentCriteria, DemandPayment>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("paymentDate", criteria.getPaymentDate(), criteria.getPaymentDateFrom(), criteria.getPaymentDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateBool("vireCheck", criteria.getVireCheck());
        addPredicateFk("demand","id", criteria.getDemand()==null?null:criteria.getDemand().getId());
        addPredicateFk("demand","id", criteria.getDemands());
        addPredicateFk("demand","reference", criteria.getDemand()==null?null:criteria.getDemand().getReference());
        addPredicateFk("paymentMode","id", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getId());
        addPredicateFk("paymentMode","id", criteria.getPaymentModes());
        addPredicateFk("paymentMode","code", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getCode());
        addPredicateFk("statusPaymentDemand","id", criteria.getStatusPaymentDemand()==null?null:criteria.getStatusPaymentDemand().getId());
        addPredicateFk("statusPaymentDemand","id", criteria.getStatusPaymentDemands());
        addPredicateFk("statusPaymentDemand","code", criteria.getStatusPaymentDemand()==null?null:criteria.getStatusPaymentDemand().getCode());
    }

    public DemandPaymentSpecification(DemandPaymentCriteria criteria) {
        super(criteria);
    }

    public DemandPaymentSpecification(DemandPaymentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

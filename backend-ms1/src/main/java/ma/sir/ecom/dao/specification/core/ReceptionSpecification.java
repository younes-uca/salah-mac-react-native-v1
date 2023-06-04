package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ReceptionCriteria;
import ma.sir.ecom.bean.core.Reception;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReceptionSpecification extends  AbstractSpecification<ReceptionCriteria, Reception>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("receptionDate", criteria.getReceptionDate(), criteria.getReceptionDateFrom(), criteria.getReceptionDateTo());
        addPredicateFk("order","id", criteria.getOrder()==null?null:criteria.getOrder().getId());
        addPredicateFk("order","id", criteria.getOrders());
        addPredicateFk("order","reference", criteria.getOrder()==null?null:criteria.getOrder().getReference());
        addPredicateFk("receptionStatus","id", criteria.getReceptionStatus()==null?null:criteria.getReceptionStatus().getId());
        addPredicateFk("receptionStatus","id", criteria.getReceptionStatuss());
        addPredicateFk("receptionStatus","code", criteria.getReceptionStatus()==null?null:criteria.getReceptionStatus().getCode());
    }

    public ReceptionSpecification(ReceptionCriteria criteria) {
        super(criteria);
    }

    public ReceptionSpecification(ReceptionCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

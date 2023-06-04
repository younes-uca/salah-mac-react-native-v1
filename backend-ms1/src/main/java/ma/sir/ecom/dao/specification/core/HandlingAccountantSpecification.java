package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.HandlingAccountantCriteria;
import ma.sir.ecom.bean.core.HandlingAccountant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class HandlingAccountantSpecification extends  AbstractSpecification<HandlingAccountantCriteria, HandlingAccountant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
    }

    public HandlingAccountantSpecification(HandlingAccountantCriteria criteria) {
        super(criteria);
    }

    public HandlingAccountantSpecification(HandlingAccountantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

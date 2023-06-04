package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ValidationAccountantCriteria;
import ma.sir.ecom.bean.core.ValidationAccountant;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ValidationAccountantSpecification extends  AbstractSpecification<ValidationAccountantCriteria, ValidationAccountant>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("cin", criteria.getCin(),criteria.getCinLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
    }

    public ValidationAccountantSpecification(ValidationAccountantCriteria criteria) {
        super(criteria);
    }

    public ValidationAccountantSpecification(ValidationAccountantCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

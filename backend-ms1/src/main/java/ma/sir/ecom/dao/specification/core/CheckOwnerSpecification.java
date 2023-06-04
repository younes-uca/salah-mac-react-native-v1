package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.CheckOwnerCriteria;
import ma.sir.ecom.bean.core.CheckOwner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CheckOwnerSpecification extends  AbstractSpecification<CheckOwnerCriteria, CheckOwner>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public CheckOwnerSpecification(CheckOwnerCriteria criteria) {
        super(criteria);
    }

    public CheckOwnerSpecification(CheckOwnerCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

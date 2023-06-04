package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PurchaseStatusCriteria;
import ma.sir.ecom.bean.core.PurchaseStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PurchaseStatusSpecification extends  AbstractSpecification<PurchaseStatusCriteria, PurchaseStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public PurchaseStatusSpecification(PurchaseStatusCriteria criteria) {
        super(criteria);
    }

    public PurchaseStatusSpecification(PurchaseStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

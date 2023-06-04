package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SaleStatusCriteria;
import ma.sir.ecom.bean.core.SaleStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SaleStatusSpecification extends  AbstractSpecification<SaleStatusCriteria, SaleStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public SaleStatusSpecification(SaleStatusCriteria criteria) {
        super(criteria);
    }

    public SaleStatusSpecification(SaleStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

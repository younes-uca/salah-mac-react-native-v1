package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ReceptionStatusCriteria;
import ma.sir.ecom.bean.core.ReceptionStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReceptionStatusSpecification extends  AbstractSpecification<ReceptionStatusCriteria, ReceptionStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public ReceptionStatusSpecification(ReceptionStatusCriteria criteria) {
        super(criteria);
    }

    public ReceptionStatusSpecification(ReceptionStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

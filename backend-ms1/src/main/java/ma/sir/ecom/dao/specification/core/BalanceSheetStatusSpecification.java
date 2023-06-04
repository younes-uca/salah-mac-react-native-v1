package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.BalanceSheetStatusCriteria;
import ma.sir.ecom.bean.core.BalanceSheetStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BalanceSheetStatusSpecification extends  AbstractSpecification<BalanceSheetStatusCriteria, BalanceSheetStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public BalanceSheetStatusSpecification(BalanceSheetStatusCriteria criteria) {
        super(criteria);
    }

    public BalanceSheetStatusSpecification(BalanceSheetStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SubAccountingClassCriteria;
import ma.sir.ecom.bean.core.SubAccountingClass;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubAccountingClassSpecification extends  AbstractSpecification<SubAccountingClassCriteria, SubAccountingClass>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("accountingClass","id", criteria.getAccountingClass()==null?null:criteria.getAccountingClass().getId());
        addPredicateFk("accountingClass","id", criteria.getAccountingClasss());
        addPredicateFk("accountingClass","code", criteria.getAccountingClass()==null?null:criteria.getAccountingClass().getCode());
    }

    public SubAccountingClassSpecification(SubAccountingClassCriteria criteria) {
        super(criteria);
    }

    public SubAccountingClassSpecification(SubAccountingClassCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.StoreCriteria;
import ma.sir.ecom.bean.core.Store;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StoreSpecification extends  AbstractSpecification<StoreCriteria, Store>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicateFk("company","id", criteria.getCompany()==null?null:criteria.getCompany().getId());
        addPredicateFk("company","id", criteria.getCompanys());
        addPredicateFk("company","ice", criteria.getCompany()==null?null:criteria.getCompany().getIce());
    }

    public StoreSpecification(StoreCriteria criteria) {
        super(criteria);
    }

    public StoreSpecification(StoreCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SupplierCriteria;
import ma.sir.ecom.bean.core.Supplier;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SupplierSpecification extends  AbstractSpecification<SupplierCriteria, Supplier>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
        addPredicate("name", criteria.getName(),criteria.getNameLike());
        addPredicate("tel", criteria.getTel(),criteria.getTelLike());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("address", criteria.getAddress(),criteria.getAddressLike());
        addPredicateBigDecimal("debt", criteria.getDebt(), criteria.getDebtMin(), criteria.getDebtMax());
    }

    public SupplierSpecification(SupplierCriteria criteria) {
        super(criteria);
    }

    public SupplierSpecification(SupplierCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

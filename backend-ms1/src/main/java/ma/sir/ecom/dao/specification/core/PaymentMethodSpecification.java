package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PaymentMethodCriteria;
import ma.sir.ecom.bean.core.PaymentMethod;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentMethodSpecification extends  AbstractSpecification<PaymentMethodCriteria, PaymentMethod>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public PaymentMethodSpecification(PaymentMethodCriteria criteria) {
        super(criteria);
    }

    public PaymentMethodSpecification(PaymentMethodCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

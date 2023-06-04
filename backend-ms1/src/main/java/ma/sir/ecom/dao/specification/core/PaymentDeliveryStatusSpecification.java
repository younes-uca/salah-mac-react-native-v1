package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryStatusCriteria;
import ma.sir.ecom.bean.core.PaymentDeliveryStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentDeliveryStatusSpecification extends  AbstractSpecification<PaymentDeliveryStatusCriteria, PaymentDeliveryStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public PaymentDeliveryStatusSpecification(PaymentDeliveryStatusCriteria criteria) {
        super(criteria);
    }

    public PaymentDeliveryStatusSpecification(PaymentDeliveryStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

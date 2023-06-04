package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PaymentDeliveryCriteria;
import ma.sir.ecom.bean.core.PaymentDelivery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentDeliverySpecification extends  AbstractSpecification<PaymentDeliveryCriteria, PaymentDelivery>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("deliveryDate", criteria.getDeliveryDate(), criteria.getDeliveryDateFrom(), criteria.getDeliveryDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("delivery","id", criteria.getDelivery()==null?null:criteria.getDelivery().getId());
        addPredicateFk("delivery","id", criteria.getDeliverys());
        addPredicateFk("sale","id", criteria.getSale()==null?null:criteria.getSale().getId());
        addPredicateFk("sale","id", criteria.getSales());
        addPredicateFk("sale","reference", criteria.getSale()==null?null:criteria.getSale().getReference());
        addPredicateFk("paymentMethod","id", criteria.getPaymentMethod()==null?null:criteria.getPaymentMethod().getId());
        addPredicateFk("paymentMethod","id", criteria.getPaymentMethods());
        addPredicateFk("paymentMethod","code", criteria.getPaymentMethod()==null?null:criteria.getPaymentMethod().getCode());
        addPredicateFk("paymentDeliveryStatus","id", criteria.getPaymentDeliveryStatus()==null?null:criteria.getPaymentDeliveryStatus().getId());
        addPredicateFk("paymentDeliveryStatus","id", criteria.getPaymentDeliveryStatuss());
        addPredicateFk("paymentDeliveryStatus","code", criteria.getPaymentDeliveryStatus()==null?null:criteria.getPaymentDeliveryStatus().getCode());
    }

    public PaymentDeliverySpecification(PaymentDeliveryCriteria criteria) {
        super(criteria);
    }

    public PaymentDeliverySpecification(PaymentDeliveryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

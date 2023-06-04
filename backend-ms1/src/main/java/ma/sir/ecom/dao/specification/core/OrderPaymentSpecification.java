package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.OrderPaymentCriteria;
import ma.sir.ecom.bean.core.OrderPayment;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderPaymentSpecification extends  AbstractSpecification<OrderPaymentCriteria, OrderPayment>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("paymentDate", criteria.getPaymentDate(), criteria.getPaymentDateFrom(), criteria.getPaymentDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateBool("vireCheck", criteria.getVireCheck());
        addPredicateFk("order","id", criteria.getOrder()==null?null:criteria.getOrder().getId());
        addPredicateFk("order","id", criteria.getOrders());
        addPredicateFk("order","reference", criteria.getOrder()==null?null:criteria.getOrder().getReference());
        addPredicateFk("paymentMode","id", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getId());
        addPredicateFk("paymentMode","id", criteria.getPaymentModes());
        addPredicateFk("paymentMode","code", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getCode());
        addPredicateFk("orderStatusOrder","id", criteria.getOrderStatusOrder()==null?null:criteria.getOrderStatusOrder().getId());
        addPredicateFk("orderStatusOrder","id", criteria.getOrderStatusOrders());
        addPredicateFk("orderStatusOrder","code", criteria.getOrderStatusOrder()==null?null:criteria.getOrderStatusOrder().getCode());
    }

    public OrderPaymentSpecification(OrderPaymentCriteria criteria) {
        super(criteria);
    }

    public OrderPaymentSpecification(OrderPaymentCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

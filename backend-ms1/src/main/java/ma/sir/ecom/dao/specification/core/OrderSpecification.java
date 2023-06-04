package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.OrderCriteria;
import ma.sir.ecom.bean.core.Order;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderSpecification extends  AbstractSpecification<OrderCriteria, Order>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("orderDate", criteria.getOrderDate(), criteria.getOrderDateFrom(), criteria.getOrderDateTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalPaid", criteria.getTotalPaid(), criteria.getTotalPaidMin(), criteria.getTotalPaidMax());
        addPredicateBigDecimal("totalPaidCheck", criteria.getTotalPaidCheck(), criteria.getTotalPaidCheckMin(), criteria.getTotalPaidCheckMax());
        addPredicateBigDecimal("totalPaidCash", criteria.getTotalPaidCash(), criteria.getTotalPaidCashMin(), criteria.getTotalPaidCashMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("orderStatus","id", criteria.getOrderStatus()==null?null:criteria.getOrderStatus().getId());
        addPredicateFk("orderStatus","id", criteria.getOrderStatuss());
        addPredicateFk("orderStatus","code", criteria.getOrderStatus()==null?null:criteria.getOrderStatus().getCode());
    }

    public OrderSpecification(OrderCriteria criteria) {
        super(criteria);
    }

    public OrderSpecification(OrderCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

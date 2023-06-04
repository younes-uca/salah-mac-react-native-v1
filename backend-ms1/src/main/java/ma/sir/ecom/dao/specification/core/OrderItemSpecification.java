package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.OrderItemCriteria;
import ma.sir.ecom.bean.core.OrderItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderItemSpecification extends  AbstractSpecification<OrderItemCriteria, OrderItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("quantityReceived", criteria.getQuantityReceived(), criteria.getQuantityReceivedMin(), criteria.getQuantityReceivedMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("order","id", criteria.getOrder()==null?null:criteria.getOrder().getId());
        addPredicateFk("order","id", criteria.getOrders());
        addPredicateFk("order","reference", criteria.getOrder()==null?null:criteria.getOrder().getReference());
    }

    public OrderItemSpecification(OrderItemCriteria criteria) {
        super(criteria);
    }

    public OrderItemSpecification(OrderItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

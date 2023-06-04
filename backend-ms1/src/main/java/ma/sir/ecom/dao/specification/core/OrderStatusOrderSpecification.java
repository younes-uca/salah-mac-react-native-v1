package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.OrderStatusOrderCriteria;
import ma.sir.ecom.bean.core.OrderStatusOrder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusOrderSpecification extends  AbstractSpecification<OrderStatusOrderCriteria, OrderStatusOrder>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("style", criteria.getStyle(),criteria.getStyleLike());
    }

    public OrderStatusOrderSpecification(OrderStatusOrderCriteria criteria) {
        super(criteria);
    }

    public OrderStatusOrderSpecification(OrderStatusOrderCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

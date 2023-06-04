package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.OrderItemHistoryCriteria;
import ma.sir.ecom.bean.history.OrderItemHistory;


public class OrderItemHistorySpecification extends AbstractHistorySpecification<OrderItemHistoryCriteria, OrderItemHistory> {

    public OrderItemHistorySpecification(OrderItemHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderItemHistorySpecification(OrderItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

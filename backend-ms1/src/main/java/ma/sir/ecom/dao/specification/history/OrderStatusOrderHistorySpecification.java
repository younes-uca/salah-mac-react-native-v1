package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.OrderStatusOrderHistoryCriteria;
import ma.sir.ecom.bean.history.OrderStatusOrderHistory;


public class OrderStatusOrderHistorySpecification extends AbstractHistorySpecification<OrderStatusOrderHistoryCriteria, OrderStatusOrderHistory> {

    public OrderStatusOrderHistorySpecification(OrderStatusOrderHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderStatusOrderHistorySpecification(OrderStatusOrderHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

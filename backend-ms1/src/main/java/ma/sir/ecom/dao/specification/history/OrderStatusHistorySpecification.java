package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.OrderStatusHistoryCriteria;
import ma.sir.ecom.bean.history.OrderStatusHistory;


public class OrderStatusHistorySpecification extends AbstractHistorySpecification<OrderStatusHistoryCriteria, OrderStatusHistory> {

    public OrderStatusHistorySpecification(OrderStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderStatusHistorySpecification(OrderStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

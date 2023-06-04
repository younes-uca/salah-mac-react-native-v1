package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.OrderHistoryCriteria;
import ma.sir.ecom.bean.history.OrderHistory;


public class OrderHistorySpecification extends AbstractHistorySpecification<OrderHistoryCriteria, OrderHistory> {

    public OrderHistorySpecification(OrderHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderHistorySpecification(OrderHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

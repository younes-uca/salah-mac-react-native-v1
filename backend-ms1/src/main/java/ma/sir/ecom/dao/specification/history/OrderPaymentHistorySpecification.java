package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.OrderPaymentHistoryCriteria;
import ma.sir.ecom.bean.history.OrderPaymentHistory;


public class OrderPaymentHistorySpecification extends AbstractHistorySpecification<OrderPaymentHistoryCriteria, OrderPaymentHistory> {

    public OrderPaymentHistorySpecification(OrderPaymentHistoryCriteria criteria) {
        super(criteria);
    }

    public OrderPaymentHistorySpecification(OrderPaymentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

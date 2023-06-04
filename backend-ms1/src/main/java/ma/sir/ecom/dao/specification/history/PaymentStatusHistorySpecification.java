package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentStatusHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentStatusHistory;


public class PaymentStatusHistorySpecification extends AbstractHistorySpecification<PaymentStatusHistoryCriteria, PaymentStatusHistory> {

    public PaymentStatusHistorySpecification(PaymentStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentStatusHistorySpecification(PaymentStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

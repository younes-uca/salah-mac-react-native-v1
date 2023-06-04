package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentMethodHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentMethodHistory;


public class PaymentMethodHistorySpecification extends AbstractHistorySpecification<PaymentMethodHistoryCriteria, PaymentMethodHistory> {

    public PaymentMethodHistorySpecification(PaymentMethodHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentMethodHistorySpecification(PaymentMethodHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

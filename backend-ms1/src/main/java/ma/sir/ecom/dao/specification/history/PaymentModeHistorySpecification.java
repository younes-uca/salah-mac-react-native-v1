package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentModeHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentModeHistory;


public class PaymentModeHistorySpecification extends AbstractHistorySpecification<PaymentModeHistoryCriteria, PaymentModeHistory> {

    public PaymentModeHistorySpecification(PaymentModeHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentModeHistorySpecification(PaymentModeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

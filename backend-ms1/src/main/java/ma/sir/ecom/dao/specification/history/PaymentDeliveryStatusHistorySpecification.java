package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryStatusHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentDeliveryStatusHistory;


public class PaymentDeliveryStatusHistorySpecification extends AbstractHistorySpecification<PaymentDeliveryStatusHistoryCriteria, PaymentDeliveryStatusHistory> {

    public PaymentDeliveryStatusHistorySpecification(PaymentDeliveryStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentDeliveryStatusHistorySpecification(PaymentDeliveryStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

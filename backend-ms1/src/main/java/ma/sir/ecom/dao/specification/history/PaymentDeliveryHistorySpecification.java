package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentDeliveryHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentDeliveryHistory;


public class PaymentDeliveryHistorySpecification extends AbstractHistorySpecification<PaymentDeliveryHistoryCriteria, PaymentDeliveryHistory> {

    public PaymentDeliveryHistorySpecification(PaymentDeliveryHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentDeliveryHistorySpecification(PaymentDeliveryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

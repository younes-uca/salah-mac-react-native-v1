package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentPurchaseHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentPurchaseHistory;


public class PaymentPurchaseHistorySpecification extends AbstractHistorySpecification<PaymentPurchaseHistoryCriteria, PaymentPurchaseHistory> {

    public PaymentPurchaseHistorySpecification(PaymentPurchaseHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentPurchaseHistorySpecification(PaymentPurchaseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

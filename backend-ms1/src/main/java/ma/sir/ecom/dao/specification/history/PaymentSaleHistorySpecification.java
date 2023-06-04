package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PaymentSaleHistoryCriteria;
import ma.sir.ecom.bean.history.PaymentSaleHistory;


public class PaymentSaleHistorySpecification extends AbstractHistorySpecification<PaymentSaleHistoryCriteria, PaymentSaleHistory> {

    public PaymentSaleHistorySpecification(PaymentSaleHistoryCriteria criteria) {
        super(criteria);
    }

    public PaymentSaleHistorySpecification(PaymentSaleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

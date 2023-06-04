package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PurchasePaymentStatusHistoryCriteria;
import ma.sir.ecom.bean.history.PurchasePaymentStatusHistory;


public class PurchasePaymentStatusHistorySpecification extends AbstractHistorySpecification<PurchasePaymentStatusHistoryCriteria, PurchasePaymentStatusHistory> {

    public PurchasePaymentStatusHistorySpecification(PurchasePaymentStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchasePaymentStatusHistorySpecification(PurchasePaymentStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

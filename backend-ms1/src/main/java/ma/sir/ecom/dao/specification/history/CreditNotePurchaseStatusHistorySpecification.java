package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseStatusHistoryCriteria;
import ma.sir.ecom.bean.history.CreditNotePurchaseStatusHistory;


public class CreditNotePurchaseStatusHistorySpecification extends AbstractHistorySpecification<CreditNotePurchaseStatusHistoryCriteria, CreditNotePurchaseStatusHistory> {

    public CreditNotePurchaseStatusHistorySpecification(CreditNotePurchaseStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public CreditNotePurchaseStatusHistorySpecification(CreditNotePurchaseStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

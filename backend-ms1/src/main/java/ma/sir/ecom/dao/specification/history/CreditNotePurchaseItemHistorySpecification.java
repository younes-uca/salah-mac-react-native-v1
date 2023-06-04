package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseItemHistoryCriteria;
import ma.sir.ecom.bean.history.CreditNotePurchaseItemHistory;


public class CreditNotePurchaseItemHistorySpecification extends AbstractHistorySpecification<CreditNotePurchaseItemHistoryCriteria, CreditNotePurchaseItemHistory> {

    public CreditNotePurchaseItemHistorySpecification(CreditNotePurchaseItemHistoryCriteria criteria) {
        super(criteria);
    }

    public CreditNotePurchaseItemHistorySpecification(CreditNotePurchaseItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

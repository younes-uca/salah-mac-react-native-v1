package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseHistoryCriteria;
import ma.sir.ecom.bean.history.CreditNotePurchaseHistory;


public class CreditNotePurchaseHistorySpecification extends AbstractHistorySpecification<CreditNotePurchaseHistoryCriteria, CreditNotePurchaseHistory> {

    public CreditNotePurchaseHistorySpecification(CreditNotePurchaseHistoryCriteria criteria) {
        super(criteria);
    }

    public CreditNotePurchaseHistorySpecification(CreditNotePurchaseHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

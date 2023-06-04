package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.PurchaseStatusHistoryCriteria;
import ma.sir.ecom.bean.history.PurchaseStatusHistory;


public class PurchaseStatusHistorySpecification extends AbstractHistorySpecification<PurchaseStatusHistoryCriteria, PurchaseStatusHistory> {

    public PurchaseStatusHistorySpecification(PurchaseStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public PurchaseStatusHistorySpecification(PurchaseStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

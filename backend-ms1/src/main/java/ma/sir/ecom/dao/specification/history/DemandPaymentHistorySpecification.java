package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DemandPaymentHistoryCriteria;
import ma.sir.ecom.bean.history.DemandPaymentHistory;


public class DemandPaymentHistorySpecification extends AbstractHistorySpecification<DemandPaymentHistoryCriteria, DemandPaymentHistory> {

    public DemandPaymentHistorySpecification(DemandPaymentHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandPaymentHistorySpecification(DemandPaymentHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

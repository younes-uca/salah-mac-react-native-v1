package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.StatusPaymentDemandHistoryCriteria;
import ma.sir.ecom.bean.history.StatusPaymentDemandHistory;


public class StatusPaymentDemandHistorySpecification extends AbstractHistorySpecification<StatusPaymentDemandHistoryCriteria, StatusPaymentDemandHistory> {

    public StatusPaymentDemandHistorySpecification(StatusPaymentDemandHistoryCriteria criteria) {
        super(criteria);
    }

    public StatusPaymentDemandHistorySpecification(StatusPaymentDemandHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

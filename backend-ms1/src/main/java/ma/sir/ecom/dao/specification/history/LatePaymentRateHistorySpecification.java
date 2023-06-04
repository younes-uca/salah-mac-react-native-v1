package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.LatePaymentRateHistoryCriteria;
import ma.sir.ecom.bean.history.LatePaymentRateHistory;


public class LatePaymentRateHistorySpecification extends AbstractHistorySpecification<LatePaymentRateHistoryCriteria, LatePaymentRateHistory> {

    public LatePaymentRateHistorySpecification(LatePaymentRateHistoryCriteria criteria) {
        super(criteria);
    }

    public LatePaymentRateHistorySpecification(LatePaymentRateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

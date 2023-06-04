package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SubscriberHistoryCriteria;
import ma.sir.ecom.bean.history.SubscriberHistory;


public class SubscriberHistorySpecification extends AbstractHistorySpecification<SubscriberHistoryCriteria, SubscriberHistory> {

    public SubscriberHistorySpecification(SubscriberHistoryCriteria criteria) {
        super(criteria);
    }

    public SubscriberHistorySpecification(SubscriberHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

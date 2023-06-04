package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.HandlingAccountantHistoryCriteria;
import ma.sir.ecom.bean.history.HandlingAccountantHistory;


public class HandlingAccountantHistorySpecification extends AbstractHistorySpecification<HandlingAccountantHistoryCriteria, HandlingAccountantHistory> {

    public HandlingAccountantHistorySpecification(HandlingAccountantHistoryCriteria criteria) {
        super(criteria);
    }

    public HandlingAccountantHistorySpecification(HandlingAccountantHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.StoreHistoryCriteria;
import ma.sir.ecom.bean.history.StoreHistory;


public class StoreHistorySpecification extends AbstractHistorySpecification<StoreHistoryCriteria, StoreHistory> {

    public StoreHistorySpecification(StoreHistoryCriteria criteria) {
        super(criteria);
    }

    public StoreHistorySpecification(StoreHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

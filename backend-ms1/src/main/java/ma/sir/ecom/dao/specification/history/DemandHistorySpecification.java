package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DemandHistoryCriteria;
import ma.sir.ecom.bean.history.DemandHistory;


public class DemandHistorySpecification extends AbstractHistorySpecification<DemandHistoryCriteria, DemandHistory> {

    public DemandHistorySpecification(DemandHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandHistorySpecification(DemandHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

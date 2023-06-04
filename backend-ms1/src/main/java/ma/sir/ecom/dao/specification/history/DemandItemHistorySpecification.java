package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DemandItemHistoryCriteria;
import ma.sir.ecom.bean.history.DemandItemHistory;


public class DemandItemHistorySpecification extends AbstractHistorySpecification<DemandItemHistoryCriteria, DemandItemHistory> {

    public DemandItemHistorySpecification(DemandItemHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandItemHistorySpecification(DemandItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DemandStatusHistoryCriteria;
import ma.sir.ecom.bean.history.DemandStatusHistory;


public class DemandStatusHistorySpecification extends AbstractHistorySpecification<DemandStatusHistoryCriteria, DemandStatusHistory> {

    public DemandStatusHistorySpecification(DemandStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public DemandStatusHistorySpecification(DemandStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

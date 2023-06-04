package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReceptionStatusHistoryCriteria;
import ma.sir.ecom.bean.history.ReceptionStatusHistory;


public class ReceptionStatusHistorySpecification extends AbstractHistorySpecification<ReceptionStatusHistoryCriteria, ReceptionStatusHistory> {

    public ReceptionStatusHistorySpecification(ReceptionStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public ReceptionStatusHistorySpecification(ReceptionStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

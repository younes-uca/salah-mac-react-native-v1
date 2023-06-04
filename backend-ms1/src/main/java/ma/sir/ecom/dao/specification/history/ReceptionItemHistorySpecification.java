package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.ecom.bean.history.ReceptionItemHistory;


public class ReceptionItemHistorySpecification extends AbstractHistorySpecification<ReceptionItemHistoryCriteria, ReceptionItemHistory> {

    public ReceptionItemHistorySpecification(ReceptionItemHistoryCriteria criteria) {
        super(criteria);
    }

    public ReceptionItemHistorySpecification(ReceptionItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

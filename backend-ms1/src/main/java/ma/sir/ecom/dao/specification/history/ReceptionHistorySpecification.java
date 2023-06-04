package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.ecom.bean.history.ReceptionHistory;


public class ReceptionHistorySpecification extends AbstractHistorySpecification<ReceptionHistoryCriteria, ReceptionHistory> {

    public ReceptionHistorySpecification(ReceptionHistoryCriteria criteria) {
        super(criteria);
    }

    public ReceptionHistorySpecification(ReceptionHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

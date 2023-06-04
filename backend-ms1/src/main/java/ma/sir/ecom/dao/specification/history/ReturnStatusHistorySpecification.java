package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReturnStatusHistoryCriteria;
import ma.sir.ecom.bean.history.ReturnStatusHistory;


public class ReturnStatusHistorySpecification extends AbstractHistorySpecification<ReturnStatusHistoryCriteria, ReturnStatusHistory> {

    public ReturnStatusHistorySpecification(ReturnStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public ReturnStatusHistorySpecification(ReturnStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CheckOwnerHistoryCriteria;
import ma.sir.ecom.bean.history.CheckOwnerHistory;


public class CheckOwnerHistorySpecification extends AbstractHistorySpecification<CheckOwnerHistoryCriteria, CheckOwnerHistory> {

    public CheckOwnerHistorySpecification(CheckOwnerHistoryCriteria criteria) {
        super(criteria);
    }

    public CheckOwnerHistorySpecification(CheckOwnerHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SubAccountingClassHistoryCriteria;
import ma.sir.ecom.bean.history.SubAccountingClassHistory;


public class SubAccountingClassHistorySpecification extends AbstractHistorySpecification<SubAccountingClassHistoryCriteria, SubAccountingClassHistory> {

    public SubAccountingClassHistorySpecification(SubAccountingClassHistoryCriteria criteria) {
        super(criteria);
    }

    public SubAccountingClassHistorySpecification(SubAccountingClassHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

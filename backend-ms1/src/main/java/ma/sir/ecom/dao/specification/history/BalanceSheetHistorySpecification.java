package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.BalanceSheetHistoryCriteria;
import ma.sir.ecom.bean.history.BalanceSheetHistory;


public class BalanceSheetHistorySpecification extends AbstractHistorySpecification<BalanceSheetHistoryCriteria, BalanceSheetHistory> {

    public BalanceSheetHistorySpecification(BalanceSheetHistoryCriteria criteria) {
        super(criteria);
    }

    public BalanceSheetHistorySpecification(BalanceSheetHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

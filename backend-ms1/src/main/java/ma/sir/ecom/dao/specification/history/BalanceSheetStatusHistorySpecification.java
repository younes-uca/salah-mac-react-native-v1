package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.BalanceSheetStatusHistoryCriteria;
import ma.sir.ecom.bean.history.BalanceSheetStatusHistory;


public class BalanceSheetStatusHistorySpecification extends AbstractHistorySpecification<BalanceSheetStatusHistoryCriteria, BalanceSheetStatusHistory> {

    public BalanceSheetStatusHistorySpecification(BalanceSheetStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public BalanceSheetStatusHistorySpecification(BalanceSheetStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

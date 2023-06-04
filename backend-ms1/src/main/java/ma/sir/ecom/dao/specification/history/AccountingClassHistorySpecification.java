package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.AccountingClassHistoryCriteria;
import ma.sir.ecom.bean.history.AccountingClassHistory;


public class AccountingClassHistorySpecification extends AbstractHistorySpecification<AccountingClassHistoryCriteria, AccountingClassHistory> {

    public AccountingClassHistorySpecification(AccountingClassHistoryCriteria criteria) {
        super(criteria);
    }

    public AccountingClassHistorySpecification(AccountingClassHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

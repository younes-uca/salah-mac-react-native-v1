package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.AccountingAccountHistoryCriteria;
import ma.sir.ecom.bean.history.AccountingAccountHistory;


public class AccountingAccountHistorySpecification extends AbstractHistorySpecification<AccountingAccountHistoryCriteria, AccountingAccountHistory> {

    public AccountingAccountHistorySpecification(AccountingAccountHistoryCriteria criteria) {
        super(criteria);
    }

    public AccountingAccountHistorySpecification(AccountingAccountHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

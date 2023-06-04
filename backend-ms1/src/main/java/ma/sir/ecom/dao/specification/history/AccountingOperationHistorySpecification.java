package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.AccountingOperationHistoryCriteria;
import ma.sir.ecom.bean.history.AccountingOperationHistory;


public class AccountingOperationHistorySpecification extends AbstractHistorySpecification<AccountingOperationHistoryCriteria, AccountingOperationHistory> {

    public AccountingOperationHistorySpecification(AccountingOperationHistoryCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationHistorySpecification(AccountingOperationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

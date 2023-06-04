package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.AccountingOperationStatusHistoryCriteria;
import ma.sir.ecom.bean.history.AccountingOperationStatusHistory;


public class AccountingOperationStatusHistorySpecification extends AbstractHistorySpecification<AccountingOperationStatusHistoryCriteria, AccountingOperationStatusHistory> {

    public AccountingOperationStatusHistorySpecification(AccountingOperationStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationStatusHistorySpecification(AccountingOperationStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

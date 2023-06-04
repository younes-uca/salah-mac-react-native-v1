package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.AccountingOperationTypeHistoryCriteria;
import ma.sir.ecom.bean.history.AccountingOperationTypeHistory;


public class AccountingOperationTypeHistorySpecification extends AbstractHistorySpecification<AccountingOperationTypeHistoryCriteria, AccountingOperationTypeHistory> {

    public AccountingOperationTypeHistorySpecification(AccountingOperationTypeHistoryCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationTypeHistorySpecification(AccountingOperationTypeHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.BankHistoryCriteria;
import ma.sir.ecom.bean.history.BankHistory;


public class BankHistorySpecification extends AbstractHistorySpecification<BankHistoryCriteria, BankHistory> {

    public BankHistorySpecification(BankHistoryCriteria criteria) {
        super(criteria);
    }

    public BankHistorySpecification(BankHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

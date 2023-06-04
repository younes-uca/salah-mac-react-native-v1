package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.BankCheckOwnerHistoryCriteria;
import ma.sir.ecom.bean.history.BankCheckOwnerHistory;


public class BankCheckOwnerHistorySpecification extends AbstractHistorySpecification<BankCheckOwnerHistoryCriteria, BankCheckOwnerHistory> {

    public BankCheckOwnerHistorySpecification(BankCheckOwnerHistoryCriteria criteria) {
        super(criteria);
    }

    public BankCheckOwnerHistorySpecification(BankCheckOwnerHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

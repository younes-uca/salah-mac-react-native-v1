package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SaleHistoryCriteria;
import ma.sir.ecom.bean.history.SaleHistory;


public class SaleHistorySpecification extends AbstractHistorySpecification<SaleHistoryCriteria, SaleHistory> {

    public SaleHistorySpecification(SaleHistoryCriteria criteria) {
        super(criteria);
    }

    public SaleHistorySpecification(SaleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SaleItemHistoryCriteria;
import ma.sir.ecom.bean.history.SaleItemHistory;


public class SaleItemHistorySpecification extends AbstractHistorySpecification<SaleItemHistoryCriteria, SaleItemHistory> {

    public SaleItemHistorySpecification(SaleItemHistoryCriteria criteria) {
        super(criteria);
    }

    public SaleItemHistorySpecification(SaleItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

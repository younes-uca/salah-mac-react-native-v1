package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SaleStatusHistoryCriteria;
import ma.sir.ecom.bean.history.SaleStatusHistory;


public class SaleStatusHistorySpecification extends AbstractHistorySpecification<SaleStatusHistoryCriteria, SaleStatusHistory> {

    public SaleStatusHistorySpecification(SaleStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public SaleStatusHistorySpecification(SaleStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

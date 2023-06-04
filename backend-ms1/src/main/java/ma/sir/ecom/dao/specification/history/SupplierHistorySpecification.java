package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SupplierHistoryCriteria;
import ma.sir.ecom.bean.history.SupplierHistory;


public class SupplierHistorySpecification extends AbstractHistorySpecification<SupplierHistoryCriteria, SupplierHistory> {

    public SupplierHistorySpecification(SupplierHistoryCriteria criteria) {
        super(criteria);
    }

    public SupplierHistorySpecification(SupplierHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

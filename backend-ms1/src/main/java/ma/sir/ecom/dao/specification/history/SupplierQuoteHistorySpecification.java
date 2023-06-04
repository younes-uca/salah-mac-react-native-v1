package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteHistoryCriteria;
import ma.sir.ecom.bean.history.SupplierQuoteHistory;


public class SupplierQuoteHistorySpecification extends AbstractHistorySpecification<SupplierQuoteHistoryCriteria, SupplierQuoteHistory> {

    public SupplierQuoteHistorySpecification(SupplierQuoteHistoryCriteria criteria) {
        super(criteria);
    }

    public SupplierQuoteHistorySpecification(SupplierQuoteHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

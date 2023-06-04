package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteItemHistoryCriteria;
import ma.sir.ecom.bean.history.SupplierQuoteItemHistory;


public class SupplierQuoteItemHistorySpecification extends AbstractHistorySpecification<SupplierQuoteItemHistoryCriteria, SupplierQuoteItemHistory> {

    public SupplierQuoteItemHistorySpecification(SupplierQuoteItemHistoryCriteria criteria) {
        super(criteria);
    }

    public SupplierQuoteItemHistorySpecification(SupplierQuoteItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

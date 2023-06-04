package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.BrandHistoryCriteria;
import ma.sir.ecom.bean.history.BrandHistory;


public class BrandHistorySpecification extends AbstractHistorySpecification<BrandHistoryCriteria, BrandHistory> {

    public BrandHistorySpecification(BrandHistoryCriteria criteria) {
        super(criteria);
    }

    public BrandHistorySpecification(BrandHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

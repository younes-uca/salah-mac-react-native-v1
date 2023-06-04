package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ProductCategoryHistoryCriteria;
import ma.sir.ecom.bean.history.ProductCategoryHistory;


public class ProductCategoryHistorySpecification extends AbstractHistorySpecification<ProductCategoryHistoryCriteria, ProductCategoryHistory> {

    public ProductCategoryHistorySpecification(ProductCategoryHistoryCriteria criteria) {
        super(criteria);
    }

    public ProductCategoryHistorySpecification(ProductCategoryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

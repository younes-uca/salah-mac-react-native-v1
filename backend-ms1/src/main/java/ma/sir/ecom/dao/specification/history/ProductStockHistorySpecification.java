package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ProductStockHistoryCriteria;
import ma.sir.ecom.bean.history.ProductStockHistory;


public class ProductStockHistorySpecification extends AbstractHistorySpecification<ProductStockHistoryCriteria, ProductStockHistory> {

    public ProductStockHistorySpecification(ProductStockHistoryCriteria criteria) {
        super(criteria);
    }

    public ProductStockHistorySpecification(ProductStockHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

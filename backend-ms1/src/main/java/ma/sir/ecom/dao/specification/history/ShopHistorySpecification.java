package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ShopHistoryCriteria;
import ma.sir.ecom.bean.history.ShopHistory;


public class ShopHistorySpecification extends AbstractHistorySpecification<ShopHistoryCriteria, ShopHistory> {

    public ShopHistorySpecification(ShopHistoryCriteria criteria) {
        super(criteria);
    }

    public ShopHistorySpecification(ShopHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

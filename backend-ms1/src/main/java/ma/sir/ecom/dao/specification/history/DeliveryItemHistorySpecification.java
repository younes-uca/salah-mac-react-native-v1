package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DeliveryItemHistoryCriteria;
import ma.sir.ecom.bean.history.DeliveryItemHistory;


public class DeliveryItemHistorySpecification extends AbstractHistorySpecification<DeliveryItemHistoryCriteria, DeliveryItemHistory> {

    public DeliveryItemHistorySpecification(DeliveryItemHistoryCriteria criteria) {
        super(criteria);
    }

    public DeliveryItemHistorySpecification(DeliveryItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

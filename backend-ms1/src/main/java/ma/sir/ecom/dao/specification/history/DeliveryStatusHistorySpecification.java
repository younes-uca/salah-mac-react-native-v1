package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DeliveryStatusHistoryCriteria;
import ma.sir.ecom.bean.history.DeliveryStatusHistory;


public class DeliveryStatusHistorySpecification extends AbstractHistorySpecification<DeliveryStatusHistoryCriteria, DeliveryStatusHistory> {

    public DeliveryStatusHistorySpecification(DeliveryStatusHistoryCriteria criteria) {
        super(criteria);
    }

    public DeliveryStatusHistorySpecification(DeliveryStatusHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

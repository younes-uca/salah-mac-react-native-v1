package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.DeliveryHistoryCriteria;
import ma.sir.ecom.bean.history.DeliveryHistory;


public class DeliveryHistorySpecification extends AbstractHistorySpecification<DeliveryHistoryCriteria, DeliveryHistory> {

    public DeliveryHistorySpecification(DeliveryHistoryCriteria criteria) {
        super(criteria);
    }

    public DeliveryHistorySpecification(DeliveryHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

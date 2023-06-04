package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.MeasurementUnitHistoryCriteria;
import ma.sir.ecom.bean.history.MeasurementUnitHistory;


public class MeasurementUnitHistorySpecification extends AbstractHistorySpecification<MeasurementUnitHistoryCriteria, MeasurementUnitHistory> {

    public MeasurementUnitHistorySpecification(MeasurementUnitHistoryCriteria criteria) {
        super(criteria);
    }

    public MeasurementUnitHistorySpecification(MeasurementUnitHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

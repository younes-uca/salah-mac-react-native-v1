package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CorporateTaxRateHistoryCriteria;
import ma.sir.ecom.bean.history.CorporateTaxRateHistory;


public class CorporateTaxRateHistorySpecification extends AbstractHistorySpecification<CorporateTaxRateHistoryCriteria, CorporateTaxRateHistory> {

    public CorporateTaxRateHistorySpecification(CorporateTaxRateHistoryCriteria criteria) {
        super(criteria);
    }

    public CorporateTaxRateHistorySpecification(CorporateTaxRateHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

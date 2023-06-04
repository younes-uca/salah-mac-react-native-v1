package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.CompanyHistoryCriteria;
import ma.sir.ecom.bean.history.CompanyHistory;


public class CompanyHistorySpecification extends AbstractHistorySpecification<CompanyHistoryCriteria, CompanyHistory> {

    public CompanyHistorySpecification(CompanyHistoryCriteria criteria) {
        super(criteria);
    }

    public CompanyHistorySpecification(CompanyHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

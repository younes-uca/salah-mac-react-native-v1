package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReturnSaleItemHistoryCriteria;
import ma.sir.ecom.bean.history.ReturnSaleItemHistory;


public class ReturnSaleItemHistorySpecification extends AbstractHistorySpecification<ReturnSaleItemHistoryCriteria, ReturnSaleItemHistory> {

    public ReturnSaleItemHistorySpecification(ReturnSaleItemHistoryCriteria criteria) {
        super(criteria);
    }

    public ReturnSaleItemHistorySpecification(ReturnSaleItemHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

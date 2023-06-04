package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ReturnSaleHistoryCriteria;
import ma.sir.ecom.bean.history.ReturnSaleHistory;


public class ReturnSaleHistorySpecification extends AbstractHistorySpecification<ReturnSaleHistoryCriteria, ReturnSaleHistory> {

    public ReturnSaleHistorySpecification(ReturnSaleHistoryCriteria criteria) {
        super(criteria);
    }

    public ReturnSaleHistorySpecification(ReturnSaleHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

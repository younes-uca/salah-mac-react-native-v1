package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.ValidationAccountantHistoryCriteria;
import ma.sir.ecom.bean.history.ValidationAccountantHistory;


public class ValidationAccountantHistorySpecification extends AbstractHistorySpecification<ValidationAccountantHistoryCriteria, ValidationAccountantHistory> {

    public ValidationAccountantHistorySpecification(ValidationAccountantHistoryCriteria criteria) {
        super(criteria);
    }

    public ValidationAccountantHistorySpecification(ValidationAccountantHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

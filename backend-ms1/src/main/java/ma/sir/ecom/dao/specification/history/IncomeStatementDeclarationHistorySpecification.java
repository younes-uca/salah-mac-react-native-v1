package  ma.sir.ecom.dao.specification.history;

import ma.sir.ecom.zynerator.specification.AbstractHistorySpecification;
import ma.sir.ecom.dao.criteria.history.IncomeStatementDeclarationHistoryCriteria;
import ma.sir.ecom.bean.history.IncomeStatementDeclarationHistory;


public class IncomeStatementDeclarationHistorySpecification extends AbstractHistorySpecification<IncomeStatementDeclarationHistoryCriteria, IncomeStatementDeclarationHistory> {

    public IncomeStatementDeclarationHistorySpecification(IncomeStatementDeclarationHistoryCriteria criteria) {
        super(criteria);
    }

    public IncomeStatementDeclarationHistorySpecification(IncomeStatementDeclarationHistoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

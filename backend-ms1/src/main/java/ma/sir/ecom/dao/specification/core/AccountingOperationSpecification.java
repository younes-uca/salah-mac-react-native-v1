package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.AccountingOperationCriteria;
import ma.sir.ecom.bean.core.AccountingOperation;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountingOperationSpecification extends  AbstractSpecification<AccountingOperationCriteria, AccountingOperation>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicateInt("year", criteria.getYear(), criteria.getYearMin(), criteria.getYearMax());
        addPredicateInt("month", criteria.getMonth(), criteria.getMonthMin(), criteria.getMonthMax());
        addPredicate("accountingOperationDate", criteria.getAccountingOperationDate(), criteria.getAccountingOperationDateFrom(), criteria.getAccountingOperationDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("company","id", criteria.getCompany()==null?null:criteria.getCompany().getId());
        addPredicateFk("company","id", criteria.getCompanys());
        addPredicateFk("company","ice", criteria.getCompany()==null?null:criteria.getCompany().getIce());
        addPredicateFk("accountingAccount","id", criteria.getAccountingAccount()==null?null:criteria.getAccountingAccount().getId());
        addPredicateFk("accountingAccount","id", criteria.getAccountingAccounts());
        addPredicateFk("accountingAccount","code", criteria.getAccountingAccount()==null?null:criteria.getAccountingAccount().getCode());
        addPredicateFk("accountingOperationType","id", criteria.getAccountingOperationType()==null?null:criteria.getAccountingOperationType().getId());
        addPredicateFk("accountingOperationType","id", criteria.getAccountingOperationTypes());
        addPredicateFk("accountingOperationType","code", criteria.getAccountingOperationType()==null?null:criteria.getAccountingOperationType().getCode());
        addPredicateFk("accountingOperationStatus","id", criteria.getAccountingOperationStatus()==null?null:criteria.getAccountingOperationStatus().getId());
        addPredicateFk("accountingOperationStatus","id", criteria.getAccountingOperationStatuss());
        addPredicateFk("accountingOperationStatus","code", criteria.getAccountingOperationStatus()==null?null:criteria.getAccountingOperationStatus().getCode());
    }

    public AccountingOperationSpecification(AccountingOperationCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationSpecification(AccountingOperationCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

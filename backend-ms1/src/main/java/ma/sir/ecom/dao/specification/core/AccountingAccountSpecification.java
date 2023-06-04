package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.AccountingAccountCriteria;
import ma.sir.ecom.bean.core.AccountingAccount;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountingAccountSpecification extends  AbstractSpecification<AccountingAccountCriteria, AccountingAccount>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicateFk("subAccountingClass","id", criteria.getSubAccountingClass()==null?null:criteria.getSubAccountingClass().getId());
        addPredicateFk("subAccountingClass","id", criteria.getSubAccountingClasss());
        addPredicateFk("subAccountingClass","code", criteria.getSubAccountingClass()==null?null:criteria.getSubAccountingClass().getCode());
    }

    public AccountingAccountSpecification(AccountingAccountCriteria criteria) {
        super(criteria);
    }

    public AccountingAccountSpecification(AccountingAccountCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

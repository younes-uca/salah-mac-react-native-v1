package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.AccountingOperationStatusCriteria;
import ma.sir.ecom.bean.core.AccountingOperationStatus;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountingOperationStatusSpecification extends  AbstractSpecification<AccountingOperationStatusCriteria, AccountingOperationStatus>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public AccountingOperationStatusSpecification(AccountingOperationStatusCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationStatusSpecification(AccountingOperationStatusCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

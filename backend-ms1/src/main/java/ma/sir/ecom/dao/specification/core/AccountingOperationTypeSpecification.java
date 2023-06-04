package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.AccountingOperationTypeCriteria;
import ma.sir.ecom.bean.core.AccountingOperationType;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AccountingOperationTypeSpecification extends  AbstractSpecification<AccountingOperationTypeCriteria, AccountingOperationType>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public AccountingOperationTypeSpecification(AccountingOperationTypeCriteria criteria) {
        super(criteria);
    }

    public AccountingOperationTypeSpecification(AccountingOperationTypeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

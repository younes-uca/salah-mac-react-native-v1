package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.BankCriteria;
import ma.sir.ecom.bean.core.Bank;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BankSpecification extends  AbstractSpecification<BankCriteria, Bank>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public BankSpecification(BankCriteria criteria) {
        super(criteria);
    }

    public BankSpecification(BankCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

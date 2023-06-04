package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.BankCheckOwnerCriteria;
import ma.sir.ecom.bean.core.BankCheckOwner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BankCheckOwnerSpecification extends  AbstractSpecification<BankCheckOwnerCriteria, BankCheckOwner>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateFk("checkOwner","id", criteria.getCheckOwner()==null?null:criteria.getCheckOwner().getId());
        addPredicateFk("checkOwner","id", criteria.getCheckOwners());
        addPredicateFk("checkOwner","code", criteria.getCheckOwner()==null?null:criteria.getCheckOwner().getCode());
        addPredicateFk("bank","id", criteria.getBank()==null?null:criteria.getBank().getId());
        addPredicateFk("bank","id", criteria.getBanks());
        addPredicateFk("bank","code", criteria.getBank()==null?null:criteria.getBank().getCode());
    }

    public BankCheckOwnerSpecification(BankCheckOwnerCriteria criteria) {
        super(criteria);
    }

    public BankCheckOwnerSpecification(BankCheckOwnerCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ReturnSaleCriteria;
import ma.sir.ecom.bean.core.ReturnSale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReturnSaleSpecification extends  AbstractSpecification<ReturnSaleCriteria, ReturnSale>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("returnDate", criteria.getReturnDate(), criteria.getReturnDateFrom(), criteria.getReturnDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("sale","id", criteria.getSale()==null?null:criteria.getSale().getId());
        addPredicateFk("sale","id", criteria.getSales());
        addPredicateFk("sale","reference", criteria.getSale()==null?null:criteria.getSale().getReference());
        addPredicateFk("returnStatus","id", criteria.getReturnStatus()==null?null:criteria.getReturnStatus().getId());
        addPredicateFk("returnStatus","id", criteria.getReturnStatuss());
        addPredicateFk("returnStatus","code", criteria.getReturnStatus()==null?null:criteria.getReturnStatus().getCode());
    }

    public ReturnSaleSpecification(ReturnSaleCriteria criteria) {
        super(criteria);
    }

    public ReturnSaleSpecification(ReturnSaleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

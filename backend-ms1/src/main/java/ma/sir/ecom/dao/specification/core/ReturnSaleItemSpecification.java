package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ReturnSaleItemCriteria;
import ma.sir.ecom.bean.core.ReturnSaleItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ReturnSaleItemSpecification extends  AbstractSpecification<ReturnSaleItemCriteria, ReturnSaleItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("returnAmount", criteria.getReturnAmount(), criteria.getReturnAmountMin(), criteria.getReturnAmountMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("returnSale","id", criteria.getReturnSale()==null?null:criteria.getReturnSale().getId());
        addPredicateFk("returnSale","id", criteria.getReturnSales());
    }

    public ReturnSaleItemSpecification(ReturnSaleItemCriteria criteria) {
        super(criteria);
    }

    public ReturnSaleItemSpecification(ReturnSaleItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

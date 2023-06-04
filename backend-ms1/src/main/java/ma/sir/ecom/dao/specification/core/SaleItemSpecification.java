package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SaleItemCriteria;
import ma.sir.ecom.bean.core.SaleItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SaleItemSpecification extends  AbstractSpecification<SaleItemCriteria, SaleItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("unitPrice", criteria.getUnitPrice(), criteria.getUnitPriceMin(), criteria.getUnitPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("discount", criteria.getDiscount(), criteria.getDiscountMin(), criteria.getDiscountMax());
        addPredicateBigDecimal("quantityReturned", criteria.getQuantityReturned(), criteria.getQuantityReturnedMin(), criteria.getQuantityReturnedMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("sale","id", criteria.getSale()==null?null:criteria.getSale().getId());
        addPredicateFk("sale","id", criteria.getSales());
        addPredicateFk("sale","reference", criteria.getSale()==null?null:criteria.getSale().getReference());
    }

    public SaleItemSpecification(SaleItemCriteria criteria) {
        super(criteria);
    }

    public SaleItemSpecification(SaleItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

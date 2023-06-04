package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.ecom.bean.core.PurchaseItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemSpecification extends  AbstractSpecification<PurchaseItemCriteria, PurchaseItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("unitPrice", criteria.getUnitPrice(), criteria.getUnitPriceMin(), criteria.getUnitPriceMax());
        addPredicateBigDecimal("sellingPrice", criteria.getSellingPrice(), criteria.getSellingPriceMin(), criteria.getSellingPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("returnQuantity", criteria.getReturnQuantity(), criteria.getReturnQuantityMin(), criteria.getReturnQuantityMax());
        addPredicateBigDecimal("discount", criteria.getDiscount(), criteria.getDiscountMin(), criteria.getDiscountMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria) {
        super(criteria);
    }

    public PurchaseItemSpecification(PurchaseItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseItemCriteria;
import ma.sir.ecom.bean.core.CreditNotePurchaseItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CreditNotePurchaseItemSpecification extends  AbstractSpecification<CreditNotePurchaseItemCriteria, CreditNotePurchaseItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("creditNotePurchase","id", criteria.getCreditNotePurchase()==null?null:criteria.getCreditNotePurchase().getId());
        addPredicateFk("creditNotePurchase","id", criteria.getCreditNotePurchases());
    }

    public CreditNotePurchaseItemSpecification(CreditNotePurchaseItemCriteria criteria) {
        super(criteria);
    }

    public CreditNotePurchaseItemSpecification(CreditNotePurchaseItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

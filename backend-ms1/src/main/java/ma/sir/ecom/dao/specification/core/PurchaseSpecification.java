package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PurchaseCriteria;
import ma.sir.ecom.bean.core.Purchase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PurchaseSpecification extends  AbstractSpecification<PurchaseCriteria, Purchase>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("purchaseDate", criteria.getPurchaseDate(), criteria.getPurchaseDateFrom(), criteria.getPurchaseDateTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalPaid", criteria.getTotalPaid(), criteria.getTotalPaidMin(), criteria.getTotalPaidMax());
        addPredicateFk("supplier","id", criteria.getSupplier()==null?null:criteria.getSupplier().getId());
        addPredicateFk("supplier","id", criteria.getSuppliers());
        addPredicateFk("supplier","ice", criteria.getSupplier()==null?null:criteria.getSupplier().getIce());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
        addPredicateFk("purchaseStatus","id", criteria.getPurchaseStatus()==null?null:criteria.getPurchaseStatus().getId());
        addPredicateFk("purchaseStatus","id", criteria.getPurchaseStatuss());
        addPredicateFk("purchaseStatus","code", criteria.getPurchaseStatus()==null?null:criteria.getPurchaseStatus().getCode());
    }

    public PurchaseSpecification(PurchaseCriteria criteria) {
        super(criteria);
    }

    public PurchaseSpecification(PurchaseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

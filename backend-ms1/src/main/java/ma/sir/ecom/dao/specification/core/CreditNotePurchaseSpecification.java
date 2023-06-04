package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseCriteria;
import ma.sir.ecom.bean.core.CreditNotePurchase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CreditNotePurchaseSpecification extends  AbstractSpecification<CreditNotePurchaseCriteria, CreditNotePurchase>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("creditNoteDate", criteria.getCreditNoteDate(), criteria.getCreditNoteDateFrom(), criteria.getCreditNoteDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
        addPredicateFk("creditNotePurchaseStatus","id", criteria.getCreditNotePurchaseStatus()==null?null:criteria.getCreditNotePurchaseStatus().getId());
        addPredicateFk("creditNotePurchaseStatus","id", criteria.getCreditNotePurchaseStatuss());
        addPredicateFk("creditNotePurchaseStatus","code", criteria.getCreditNotePurchaseStatus()==null?null:criteria.getCreditNotePurchaseStatus().getCode());
    }

    public CreditNotePurchaseSpecification(CreditNotePurchaseCriteria criteria) {
        super(criteria);
    }

    public CreditNotePurchaseSpecification(CreditNotePurchaseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

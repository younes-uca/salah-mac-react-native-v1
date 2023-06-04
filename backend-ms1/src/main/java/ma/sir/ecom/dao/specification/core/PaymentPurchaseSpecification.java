package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PaymentPurchaseCriteria;
import ma.sir.ecom.bean.core.PaymentPurchase;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentPurchaseSpecification extends  AbstractSpecification<PaymentPurchaseCriteria, PaymentPurchase>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("paymentDate", criteria.getPaymentDate(), criteria.getPaymentDateFrom(), criteria.getPaymentDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("purchase","id", criteria.getPurchase()==null?null:criteria.getPurchase().getId());
        addPredicateFk("purchase","id", criteria.getPurchases());
        addPredicateFk("purchase","reference", criteria.getPurchase()==null?null:criteria.getPurchase().getReference());
        addPredicateFk("paymentMode","id", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getId());
        addPredicateFk("paymentMode","id", criteria.getPaymentModes());
        addPredicateFk("paymentMode","code", criteria.getPaymentMode()==null?null:criteria.getPaymentMode().getCode());
        addPredicateFk("purchasePaymentStatus","id", criteria.getPurchasePaymentStatus()==null?null:criteria.getPurchasePaymentStatus().getId());
        addPredicateFk("purchasePaymentStatus","id", criteria.getPurchasePaymentStatuss());
        addPredicateFk("purchasePaymentStatus","code", criteria.getPurchasePaymentStatus()==null?null:criteria.getPurchasePaymentStatus().getCode());
    }

    public PaymentPurchaseSpecification(PaymentPurchaseCriteria criteria) {
        super(criteria);
    }

    public PaymentPurchaseSpecification(PaymentPurchaseCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

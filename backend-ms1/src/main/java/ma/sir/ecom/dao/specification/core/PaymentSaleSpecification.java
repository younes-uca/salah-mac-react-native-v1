package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.PaymentSaleCriteria;
import ma.sir.ecom.bean.core.PaymentSale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PaymentSaleSpecification extends  AbstractSpecification<PaymentSaleCriteria, PaymentSale>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("paymentDate", criteria.getPaymentDate(), criteria.getPaymentDateFrom(), criteria.getPaymentDateTo());
        addPredicateBigDecimal("amount", criteria.getAmount(), criteria.getAmountMin(), criteria.getAmountMax());
        addPredicateFk("sale","id", criteria.getSale()==null?null:criteria.getSale().getId());
        addPredicateFk("sale","id", criteria.getSales());
        addPredicateFk("sale","reference", criteria.getSale()==null?null:criteria.getSale().getReference());
        addPredicateFk("paymentMethod","id", criteria.getPaymentMethod()==null?null:criteria.getPaymentMethod().getId());
        addPredicateFk("paymentMethod","id", criteria.getPaymentMethods());
        addPredicateFk("paymentMethod","code", criteria.getPaymentMethod()==null?null:criteria.getPaymentMethod().getCode());
        addPredicateFk("paymentStatus","id", criteria.getPaymentStatus()==null?null:criteria.getPaymentStatus().getId());
        addPredicateFk("paymentStatus","id", criteria.getPaymentStatuss());
        addPredicateFk("paymentStatus","code", criteria.getPaymentStatus()==null?null:criteria.getPaymentStatus().getCode());
    }

    public PaymentSaleSpecification(PaymentSaleCriteria criteria) {
        super(criteria);
    }

    public PaymentSaleSpecification(PaymentSaleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

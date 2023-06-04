package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteItemCriteria;
import ma.sir.ecom.bean.core.SupplierQuoteItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SupplierQuoteItemSpecification extends  AbstractSpecification<SupplierQuoteItemCriteria, SupplierQuoteItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("unitPrice", criteria.getUnitPrice(), criteria.getUnitPriceMin(), criteria.getUnitPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("discount", criteria.getDiscount(), criteria.getDiscountMin(), criteria.getDiscountMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("supplierQuote","id", criteria.getSupplierQuote()==null?null:criteria.getSupplierQuote().getId());
        addPredicateFk("supplierQuote","id", criteria.getSupplierQuotes());
        addPredicateFk("supplierQuote","reference", criteria.getSupplierQuote()==null?null:criteria.getSupplierQuote().getReference());
    }

    public SupplierQuoteItemSpecification(SupplierQuoteItemCriteria criteria) {
        super(criteria);
    }

    public SupplierQuoteItemSpecification(SupplierQuoteItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

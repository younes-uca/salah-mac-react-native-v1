package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteCriteria;
import ma.sir.ecom.bean.core.SupplierQuote;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SupplierQuoteSpecification extends  AbstractSpecification<SupplierQuoteCriteria, SupplierQuote>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("quoteDate", criteria.getQuoteDate(), criteria.getQuoteDateFrom(), criteria.getQuoteDateTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateFk("supplier","id", criteria.getSupplier()==null?null:criteria.getSupplier().getId());
        addPredicateFk("supplier","id", criteria.getSuppliers());
        addPredicateFk("supplier","ice", criteria.getSupplier()==null?null:criteria.getSupplier().getIce());
    }

    public SupplierQuoteSpecification(SupplierQuoteCriteria criteria) {
        super(criteria);
    }

    public SupplierQuoteSpecification(SupplierQuoteCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

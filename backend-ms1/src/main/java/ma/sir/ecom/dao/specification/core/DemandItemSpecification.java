package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.DemandItemCriteria;
import ma.sir.ecom.bean.core.DemandItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DemandItemSpecification extends  AbstractSpecification<DemandItemCriteria, DemandItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("price", criteria.getPrice(), criteria.getPriceMin(), criteria.getPriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("poundQuantity", criteria.getPoundQuantity(), criteria.getPoundQuantityMin(), criteria.getPoundQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("demand","id", criteria.getDemand()==null?null:criteria.getDemand().getId());
        addPredicateFk("demand","id", criteria.getDemands());
        addPredicateFk("demand","reference", criteria.getDemand()==null?null:criteria.getDemand().getReference());
    }

    public DemandItemSpecification(DemandItemCriteria criteria) {
        super(criteria);
    }

    public DemandItemSpecification(DemandItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

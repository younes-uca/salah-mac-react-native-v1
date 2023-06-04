package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.DeliveryItemCriteria;
import ma.sir.ecom.bean.core.DeliveryItem;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeliveryItemSpecification extends  AbstractSpecification<DeliveryItemCriteria, DeliveryItem>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
        addPredicateFk("delivery","id", criteria.getDelivery()==null?null:criteria.getDelivery().getId());
        addPredicateFk("delivery","id", criteria.getDeliverys());
    }

    public DeliveryItemSpecification(DeliveryItemCriteria criteria) {
        super(criteria);
    }

    public DeliveryItemSpecification(DeliveryItemCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

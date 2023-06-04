package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.DeliveryCriteria;
import ma.sir.ecom.bean.core.Delivery;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DeliverySpecification extends  AbstractSpecification<DeliveryCriteria, Delivery>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("deliveryDate", criteria.getDeliveryDate(), criteria.getDeliveryDateFrom(), criteria.getDeliveryDateTo());
        addPredicateFk("demand","id", criteria.getDemand()==null?null:criteria.getDemand().getId());
        addPredicateFk("demand","id", criteria.getDemands());
        addPredicateFk("demand","reference", criteria.getDemand()==null?null:criteria.getDemand().getReference());
        addPredicateFk("deliveryStatus","id", criteria.getDeliveryStatus()==null?null:criteria.getDeliveryStatus().getId());
        addPredicateFk("deliveryStatus","id", criteria.getDeliveryStatuss());
        addPredicateFk("deliveryStatus","code", criteria.getDeliveryStatus()==null?null:criteria.getDeliveryStatus().getCode());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
    }

    public DeliverySpecification(DeliveryCriteria criteria) {
        super(criteria);
    }

    public DeliverySpecification(DeliveryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

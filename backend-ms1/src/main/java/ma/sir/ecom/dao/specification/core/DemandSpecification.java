package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.DemandCriteria;
import ma.sir.ecom.bean.core.Demand;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class DemandSpecification extends  AbstractSpecification<DemandCriteria, Demand>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("demandDate", criteria.getDemandDate(), criteria.getDemandDateFrom(), criteria.getDemandDateTo());
        addPredicateBigDecimal("totalCheck", criteria.getTotalCheck(), criteria.getTotalCheckMin(), criteria.getTotalCheckMax());
        addPredicateBigDecimal("totalCash", criteria.getTotalCash(), criteria.getTotalCashMin(), criteria.getTotalCashMax());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalPaid", criteria.getTotalPaid(), criteria.getTotalPaidMin(), criteria.getTotalPaidMax());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("demandStatus","id", criteria.getDemandStatus()==null?null:criteria.getDemandStatus().getId());
        addPredicateFk("demandStatus","id", criteria.getDemandStatuss());
        addPredicateFk("demandStatus","code", criteria.getDemandStatus()==null?null:criteria.getDemandStatus().getCode());
    }

    public DemandSpecification(DemandCriteria criteria) {
        super(criteria);
    }

    public DemandSpecification(DemandCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

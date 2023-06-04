package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SaleCriteria;
import ma.sir.ecom.bean.core.Sale;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SaleSpecification extends  AbstractSpecification<SaleCriteria, Sale>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("saleDate", criteria.getSaleDate(), criteria.getSaleDateFrom(), criteria.getSaleDateTo());
        addPredicateBigDecimal("total", criteria.getTotal(), criteria.getTotalMin(), criteria.getTotalMax());
        addPredicateBigDecimal("totalPaid", criteria.getTotalPaid(), criteria.getTotalPaidMin(), criteria.getTotalPaidMax());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
        addPredicateFk("client","id", criteria.getClient()==null?null:criteria.getClient().getId());
        addPredicateFk("client","id", criteria.getClients());
        addPredicateFk("client","cin", criteria.getClient()==null?null:criteria.getClient().getCin());
        addPredicateFk("saleStatus","id", criteria.getSaleStatus()==null?null:criteria.getSaleStatus().getId());
        addPredicateFk("saleStatus","id", criteria.getSaleStatuss());
        addPredicateFk("saleStatus","code", criteria.getSaleStatus()==null?null:criteria.getSaleStatus().getCode());
    }

    public SaleSpecification(SaleCriteria criteria) {
        super(criteria);
    }

    public SaleSpecification(SaleCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

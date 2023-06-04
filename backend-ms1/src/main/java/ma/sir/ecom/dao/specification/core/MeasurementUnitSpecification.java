package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.MeasurementUnitCriteria;
import ma.sir.ecom.bean.core.MeasurementUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MeasurementUnitSpecification extends  AbstractSpecification<MeasurementUnitCriteria, MeasurementUnit>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
    }

    public MeasurementUnitSpecification(MeasurementUnitCriteria criteria) {
        super(criteria);
    }

    public MeasurementUnitSpecification(MeasurementUnitCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

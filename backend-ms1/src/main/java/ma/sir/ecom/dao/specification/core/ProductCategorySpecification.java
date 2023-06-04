package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ProductCategoryCriteria;
import ma.sir.ecom.bean.core.ProductCategory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductCategorySpecification extends  AbstractSpecification<ProductCategoryCriteria, ProductCategory>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria) {
        super(criteria);
    }

    public ProductCategorySpecification(ProductCategoryCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

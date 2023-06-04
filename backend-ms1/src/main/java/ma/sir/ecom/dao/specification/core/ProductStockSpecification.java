package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ProductStockCriteria;
import ma.sir.ecom.bean.core.ProductStock;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductStockSpecification extends  AbstractSpecification<ProductStockCriteria, ProductStock>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("defectiveQuantity", criteria.getDefectiveQuantity(), criteria.getDefectiveQuantityMin(), criteria.getDefectiveQuantityMax());
        addPredicateFk("shop","id", criteria.getShop()==null?null:criteria.getShop().getId());
        addPredicateFk("shop","id", criteria.getShops());
        addPredicateFk("shop","reference", criteria.getShop()==null?null:criteria.getShop().getReference());
        addPredicateFk("product","id", criteria.getProduct()==null?null:criteria.getProduct().getId());
        addPredicateFk("product","id", criteria.getProducts());
        addPredicateFk("product","reference", criteria.getProduct()==null?null:criteria.getProduct().getReference());
    }

    public ProductStockSpecification(ProductStockCriteria criteria) {
        super(criteria);
    }

    public ProductStockSpecification(ProductStockCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

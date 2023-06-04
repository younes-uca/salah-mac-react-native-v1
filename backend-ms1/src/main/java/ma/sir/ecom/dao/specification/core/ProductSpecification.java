package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.ProductCriteria;
import ma.sir.ecom.bean.core.Product;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecification extends  AbstractSpecification<ProductCriteria, Product>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("reference", criteria.getReference(),criteria.getReferenceLike());
        addPredicate("libelle", criteria.getLibelle(),criteria.getLibelleLike());
        addPredicate("barcode", criteria.getBarcode(),criteria.getBarcodeLike());
        addPredicate("description", criteria.getDescription(),criteria.getDescriptionLike());
        addPredicateBigDecimal("averagePurchasePrice", criteria.getAveragePurchasePrice(), criteria.getAveragePurchasePriceMin(), criteria.getAveragePurchasePriceMax());
        addPredicateBigDecimal("quantity", criteria.getQuantity(), criteria.getQuantityMin(), criteria.getQuantityMax());
        addPredicateBigDecimal("alertThreshold", criteria.getAlertThreshold(), criteria.getAlertThresholdMin(), criteria.getAlertThresholdMax());
        addPredicate("productPhotos", criteria.getProductPhotos(),criteria.getProductPhotosLike());
        addPredicateFk("productCategory","id", criteria.getProductCategory()==null?null:criteria.getProductCategory().getId());
        addPredicateFk("productCategory","id", criteria.getProductCategorys());
        addPredicateFk("productCategory","reference", criteria.getProductCategory()==null?null:criteria.getProductCategory().getReference());
        addPredicateFk("measurementUnit","id", criteria.getMeasurementUnit()==null?null:criteria.getMeasurementUnit().getId());
        addPredicateFk("measurementUnit","id", criteria.getMeasurementUnits());
        addPredicateFk("measurementUnit","code", criteria.getMeasurementUnit()==null?null:criteria.getMeasurementUnit().getCode());
        addPredicateFk("brand","id", criteria.getBrand()==null?null:criteria.getBrand().getId());
        addPredicateFk("brand","id", criteria.getBrands());
        addPredicateFk("brand","code", criteria.getBrand()==null?null:criteria.getBrand().getCode());
        addPredicateFk("store","id", criteria.getStore()==null?null:criteria.getStore().getId());
        addPredicateFk("store","id", criteria.getStores());
        addPredicateFk("store","reference", criteria.getStore()==null?null:criteria.getStore().getReference());
    }

    public ProductSpecification(ProductCriteria criteria) {
        super(criteria);
    }

    public ProductSpecification(ProductCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

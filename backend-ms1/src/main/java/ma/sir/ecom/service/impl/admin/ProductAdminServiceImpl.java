package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Product;
import ma.sir.ecom.bean.history.ProductHistory;
import ma.sir.ecom.dao.criteria.core.ProductCriteria;
import ma.sir.ecom.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ProductDao;
import ma.sir.ecom.dao.facade.history.ProductHistoryDao;
import ma.sir.ecom.dao.specification.core.ProductSpecification;
import ma.sir.ecom.service.facade.admin.ProductAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ProductDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.ProductCategoryAdminService ;
import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.BrandAdminService ;
import ma.sir.ecom.service.facade.admin.MeasurementUnitAdminService ;


import java.util.List;
@Service
public class ProductAdminServiceImpl extends AbstractServiceImpl<Product,ProductHistory, ProductCriteria, ProductHistoryCriteria, ProductDao,
ProductHistoryDao> implements ProductAdminService {
    public static final String TEMPLATE = "template/product.vm";
    public static final String FILE_NAME = "product.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ProductDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Product findByReferenceEntity(Product t){
        return  dao.findByReference(t.getReference());
    }

    public List<Product> findByProductCategoryId(Long id){
        return dao.findByProductCategoryId(id);
    }
    public int deleteByProductCategoryId(Long id){
        return dao.deleteByProductCategoryId(id);
    }
    public List<Product> findByMeasurementUnitId(Long id){
        return dao.findByMeasurementUnitId(id);
    }
    public int deleteByMeasurementUnitId(Long id){
        return dao.deleteByMeasurementUnitId(id);
    }
    public List<Product> findByBrandId(Long id){
        return dao.findByBrandId(id);
    }
    public int deleteByBrandId(Long id){
        return dao.deleteByBrandId(id);
    }
    public List<Product> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }




    public void configure() {
        super.configure(Product.class,ProductHistory.class, ProductHistoryCriteria.class, ProductSpecification.class);
    }

    @Autowired
    private ProductCategoryAdminService productCategoryService ;
    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private BrandAdminService brandService ;
    @Autowired
    private MeasurementUnitAdminService measurementUnitService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ProductAdminServiceImpl(ProductDao dao, ProductHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
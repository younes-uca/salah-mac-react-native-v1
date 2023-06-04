package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Product;
import ma.sir.ecom.dao.criteria.core.ProductCriteria;
import ma.sir.ecom.dao.criteria.history.ProductHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ProductDto;
import org.springframework.http.HttpEntity;

public interface ProductAdminService extends  IService<Product,ProductCriteria, ProductHistoryCriteria>  {

    List<Product> findByProductCategoryId(Long id);
    int deleteByProductCategoryId(Long id);
    List<Product> findByMeasurementUnitId(Long id);
    int deleteByMeasurementUnitId(Long id);
    List<Product> findByBrandId(Long id);
    int deleteByBrandId(Long id);
    List<Product> findByStoreId(Long id);
    int deleteByStoreId(Long id);

    HttpEntity<byte[]> createPdf(ProductDto dto) throws Exception;


}

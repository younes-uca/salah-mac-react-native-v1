package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ProductStock;
import ma.sir.ecom.dao.criteria.core.ProductStockCriteria;
import ma.sir.ecom.dao.criteria.history.ProductStockHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ProductStockDto;
import org.springframework.http.HttpEntity;

public interface ProductStockAdminService extends  IService<ProductStock,ProductStockCriteria, ProductStockHistoryCriteria>  {

    List<ProductStock> findByShopId(Long id);
    int deleteByShopId(Long id);
    List<ProductStock> findByProductId(Long id);
    int deleteByProductId(Long id);

    HttpEntity<byte[]> createPdf(ProductStockDto dto) throws Exception;


}

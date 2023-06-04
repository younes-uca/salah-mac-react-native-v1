package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.ProductCategory;
import ma.sir.ecom.dao.criteria.core.ProductCategoryCriteria;
import ma.sir.ecom.dao.criteria.history.ProductCategoryHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ProductCategoryDto;
import org.springframework.http.HttpEntity;

public interface ProductCategoryAdminService extends  IService<ProductCategory,ProductCategoryCriteria, ProductCategoryHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ProductCategoryDto dto) throws Exception;


}

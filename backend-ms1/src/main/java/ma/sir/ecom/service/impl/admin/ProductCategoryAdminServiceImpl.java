package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ProductCategory;
import ma.sir.ecom.bean.history.ProductCategoryHistory;
import ma.sir.ecom.dao.criteria.core.ProductCategoryCriteria;
import ma.sir.ecom.dao.criteria.history.ProductCategoryHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ProductCategoryDao;
import ma.sir.ecom.dao.facade.history.ProductCategoryHistoryDao;
import ma.sir.ecom.dao.specification.core.ProductCategorySpecification;
import ma.sir.ecom.service.facade.admin.ProductCategoryAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ProductCategoryDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ProductCategoryAdminServiceImpl extends AbstractServiceImpl<ProductCategory,ProductCategoryHistory, ProductCategoryCriteria, ProductCategoryHistoryCriteria, ProductCategoryDao,
ProductCategoryHistoryDao> implements ProductCategoryAdminService {
    public static final String TEMPLATE = "template/productCategory.vm";
    public static final String FILE_NAME = "productCategory.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ProductCategoryDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public ProductCategory findByReferenceEntity(ProductCategory t){
        return  dao.findByReference(t.getReference());
    }





    public void configure() {
        super.configure(ProductCategory.class,ProductCategoryHistory.class, ProductCategoryHistoryCriteria.class, ProductCategorySpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ProductCategoryAdminServiceImpl(ProductCategoryDao dao, ProductCategoryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
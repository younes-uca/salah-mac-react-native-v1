package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ProductStock;
import ma.sir.ecom.bean.history.ProductStockHistory;
import ma.sir.ecom.dao.criteria.core.ProductStockCriteria;
import ma.sir.ecom.dao.criteria.history.ProductStockHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ProductStockDao;
import ma.sir.ecom.dao.facade.history.ProductStockHistoryDao;
import ma.sir.ecom.dao.specification.core.ProductStockSpecification;
import ma.sir.ecom.service.facade.admin.ProductStockAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ProductStockDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.ProductAdminService ;
import ma.sir.ecom.service.facade.admin.ShopAdminService ;


import java.util.List;
@Service
public class ProductStockAdminServiceImpl extends AbstractServiceImpl<ProductStock,ProductStockHistory, ProductStockCriteria, ProductStockHistoryCriteria, ProductStockDao,
ProductStockHistoryDao> implements ProductStockAdminService {
    public static final String TEMPLATE = "template/productStock.vm";
    public static final String FILE_NAME = "productStock.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ProductStockDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<ProductStock> findByShopId(Long id){
        return dao.findByShopId(id);
    }
    public int deleteByShopId(Long id){
        return dao.deleteByShopId(id);
    }
    public List<ProductStock> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }




    public void configure() {
        super.configure(ProductStock.class,ProductStockHistory.class, ProductStockHistoryCriteria.class, ProductStockSpecification.class);
    }

    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private ShopAdminService shopService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ProductStockAdminServiceImpl(ProductStockDao dao, ProductStockHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
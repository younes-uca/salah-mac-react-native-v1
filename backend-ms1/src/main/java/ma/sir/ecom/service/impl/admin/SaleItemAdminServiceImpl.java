package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.SaleItem;
import ma.sir.ecom.bean.history.SaleItemHistory;
import ma.sir.ecom.dao.criteria.core.SaleItemCriteria;
import ma.sir.ecom.dao.criteria.history.SaleItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SaleItemDao;
import ma.sir.ecom.dao.facade.history.SaleItemHistoryDao;
import ma.sir.ecom.dao.specification.core.SaleItemSpecification;
import ma.sir.ecom.service.facade.admin.SaleItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SaleItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.SaleAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class SaleItemAdminServiceImpl extends AbstractServiceImpl<SaleItem,SaleItemHistory, SaleItemCriteria, SaleItemHistoryCriteria, SaleItemDao,
SaleItemHistoryDao> implements SaleItemAdminService {
    public static final String TEMPLATE = "template/saleItem.vm";
    public static final String FILE_NAME = "saleItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SaleItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<SaleItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<SaleItem> findBySaleId(Long id){
        return dao.findBySaleId(id);
    }
    public int deleteBySaleId(Long id){
        return dao.deleteBySaleId(id);
    }




    public void configure() {
        super.configure(SaleItem.class,SaleItemHistory.class, SaleItemHistoryCriteria.class, SaleItemSpecification.class);
    }

    @Autowired
    private SaleAdminService saleService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SaleItemAdminServiceImpl(SaleItemDao dao, SaleItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
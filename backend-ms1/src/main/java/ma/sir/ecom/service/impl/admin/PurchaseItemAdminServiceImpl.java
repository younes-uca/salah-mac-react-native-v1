package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.PurchaseItem;
import ma.sir.ecom.bean.history.PurchaseItemHistory;
import ma.sir.ecom.dao.criteria.core.PurchaseItemCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PurchaseItemDao;
import ma.sir.ecom.dao.facade.history.PurchaseItemHistoryDao;
import ma.sir.ecom.dao.specification.core.PurchaseItemSpecification;
import ma.sir.ecom.service.facade.admin.PurchaseItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PurchaseItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.PurchaseAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class PurchaseItemAdminServiceImpl extends AbstractServiceImpl<PurchaseItem,PurchaseItemHistory, PurchaseItemCriteria, PurchaseItemHistoryCriteria, PurchaseItemDao,
PurchaseItemHistoryDao> implements PurchaseItemAdminService {
    public static final String TEMPLATE = "template/purchaseItem.vm";
    public static final String FILE_NAME = "purchaseItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PurchaseItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<PurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<PurchaseItem> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }




    public void configure() {
        super.configure(PurchaseItem.class,PurchaseItemHistory.class, PurchaseItemHistoryCriteria.class, PurchaseItemSpecification.class);
    }

    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PurchaseItemAdminServiceImpl(PurchaseItemDao dao, PurchaseItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
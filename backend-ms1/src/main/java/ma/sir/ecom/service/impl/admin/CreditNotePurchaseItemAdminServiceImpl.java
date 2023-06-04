package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.CreditNotePurchaseItem;
import ma.sir.ecom.bean.history.CreditNotePurchaseItemHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseItemCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CreditNotePurchaseItemDao;
import ma.sir.ecom.dao.facade.history.CreditNotePurchaseItemHistoryDao;
import ma.sir.ecom.dao.specification.core.CreditNotePurchaseItemSpecification;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CreditNotePurchaseItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.CreditNotePurchaseAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class CreditNotePurchaseItemAdminServiceImpl extends AbstractServiceImpl<CreditNotePurchaseItem,CreditNotePurchaseItemHistory, CreditNotePurchaseItemCriteria, CreditNotePurchaseItemHistoryCriteria, CreditNotePurchaseItemDao,
CreditNotePurchaseItemHistoryDao> implements CreditNotePurchaseItemAdminService {
    public static final String TEMPLATE = "template/creditNotePurchaseItem.vm";
    public static final String FILE_NAME = "creditNotePurchaseItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CreditNotePurchaseItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<CreditNotePurchaseItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<CreditNotePurchaseItem> findByCreditNotePurchaseId(Long id){
        return dao.findByCreditNotePurchaseId(id);
    }
    public int deleteByCreditNotePurchaseId(Long id){
        return dao.deleteByCreditNotePurchaseId(id);
    }




    public void configure() {
        super.configure(CreditNotePurchaseItem.class,CreditNotePurchaseItemHistory.class, CreditNotePurchaseItemHistoryCriteria.class, CreditNotePurchaseItemSpecification.class);
    }

    @Autowired
    private CreditNotePurchaseAdminService creditNotePurchaseService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public CreditNotePurchaseItemAdminServiceImpl(CreditNotePurchaseItemDao dao, CreditNotePurchaseItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
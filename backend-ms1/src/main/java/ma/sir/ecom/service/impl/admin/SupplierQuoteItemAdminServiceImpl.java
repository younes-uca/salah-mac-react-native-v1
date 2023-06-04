package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.SupplierQuoteItem;
import ma.sir.ecom.bean.history.SupplierQuoteItemHistory;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteItemCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SupplierQuoteItemDao;
import ma.sir.ecom.dao.facade.history.SupplierQuoteItemHistoryDao;
import ma.sir.ecom.dao.specification.core.SupplierQuoteItemSpecification;
import ma.sir.ecom.service.facade.admin.SupplierQuoteItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SupplierQuoteItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.ProductAdminService ;
import ma.sir.ecom.service.facade.admin.SupplierQuoteAdminService ;


import java.util.List;
@Service
public class SupplierQuoteItemAdminServiceImpl extends AbstractServiceImpl<SupplierQuoteItem,SupplierQuoteItemHistory, SupplierQuoteItemCriteria, SupplierQuoteItemHistoryCriteria, SupplierQuoteItemDao,
SupplierQuoteItemHistoryDao> implements SupplierQuoteItemAdminService {
    public static final String TEMPLATE = "template/supplierQuoteItem.vm";
    public static final String FILE_NAME = "supplierQuoteItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SupplierQuoteItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<SupplierQuoteItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<SupplierQuoteItem> findBySupplierQuoteId(Long id){
        return dao.findBySupplierQuoteId(id);
    }
    public int deleteBySupplierQuoteId(Long id){
        return dao.deleteBySupplierQuoteId(id);
    }




    public void configure() {
        super.configure(SupplierQuoteItem.class,SupplierQuoteItemHistory.class, SupplierQuoteItemHistoryCriteria.class, SupplierQuoteItemSpecification.class);
    }

    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private SupplierQuoteAdminService supplierQuoteService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SupplierQuoteItemAdminServiceImpl(SupplierQuoteItemDao dao, SupplierQuoteItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
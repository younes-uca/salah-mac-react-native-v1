package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.SupplierQuote;
import ma.sir.ecom.bean.history.SupplierQuoteHistory;
import ma.sir.ecom.dao.criteria.core.SupplierQuoteCriteria;
import ma.sir.ecom.dao.criteria.history.SupplierQuoteHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SupplierQuoteDao;
import ma.sir.ecom.dao.facade.history.SupplierQuoteHistoryDao;
import ma.sir.ecom.dao.specification.core.SupplierQuoteSpecification;
import ma.sir.ecom.service.facade.admin.SupplierQuoteAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SupplierQuoteDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.SupplierQuoteItem;

import ma.sir.ecom.service.facade.admin.SupplierQuoteItemAdminService ;
import ma.sir.ecom.service.facade.admin.SupplierAdminService ;


import java.util.List;
@Service
public class SupplierQuoteAdminServiceImpl extends AbstractServiceImpl<SupplierQuote,SupplierQuoteHistory, SupplierQuoteCriteria, SupplierQuoteHistoryCriteria, SupplierQuoteDao,
SupplierQuoteHistoryDao> implements SupplierQuoteAdminService {
    public static final String TEMPLATE = "template/supplierQuote.vm";
    public static final String FILE_NAME = "supplierQuote.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SupplierQuoteDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public SupplierQuote create(SupplierQuote t) {
        super.create(t);
        if (t.getSupplierQuoteItems() != null) {
                t.getSupplierQuoteItems().forEach(element-> {
                    element.setSupplierQuote(t);
                    supplierQuoteItemService.create(element);
            });
        }
        return t;
    }

    public SupplierQuote findWithAssociatedLists(Long id){
        SupplierQuote result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSupplierQuoteItems(supplierQuoteItemService.findBySupplierQuoteId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        supplierQuoteItemService.deleteBySupplierQuoteId(id);
    }


    public void updateWithAssociatedLists(SupplierQuote supplierQuote){
    if(supplierQuote !=null && supplierQuote.getId() != null){
            List<List<SupplierQuoteItem>> resultSupplierQuoteItems= supplierQuoteItemService.getToBeSavedAndToBeDeleted(supplierQuoteItemService.findBySupplierQuoteId(supplierQuote.getId()),supplierQuote.getSupplierQuoteItems());
            supplierQuoteItemService.delete(resultSupplierQuoteItems.get(1));
            ListUtil.emptyIfNull(resultSupplierQuoteItems.get(0)).forEach(e -> e.setSupplierQuote(supplierQuote));
            supplierQuoteItemService.update(resultSupplierQuoteItems.get(0),true);
    }
    }

    public SupplierQuote findByReferenceEntity(SupplierQuote t){
        return  dao.findByReference(t.getReference());
    }

    public List<SupplierQuote> findBySupplierId(Long id){
        return dao.findBySupplierId(id);
    }
    public int deleteBySupplierId(Long id){
        return dao.deleteBySupplierId(id);
    }




    public void configure() {
        super.configure(SupplierQuote.class,SupplierQuoteHistory.class, SupplierQuoteHistoryCriteria.class, SupplierQuoteSpecification.class);
    }

    @Autowired
    private SupplierQuoteItemAdminService supplierQuoteItemService ;
    @Autowired
    private SupplierAdminService supplierService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SupplierQuoteAdminServiceImpl(SupplierQuoteDao dao, SupplierQuoteHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.CreditNotePurchase;
import ma.sir.ecom.bean.history.CreditNotePurchaseHistory;
import ma.sir.ecom.dao.criteria.core.CreditNotePurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.CreditNotePurchaseHistoryCriteria;
import ma.sir.ecom.dao.facade.core.CreditNotePurchaseDao;
import ma.sir.ecom.dao.facade.history.CreditNotePurchaseHistoryDao;
import ma.sir.ecom.dao.specification.core.CreditNotePurchaseSpecification;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.CreditNotePurchaseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.CreditNotePurchaseItem;

import ma.sir.ecom.service.facade.admin.CreditNotePurchaseStatusAdminService ;
import ma.sir.ecom.service.facade.admin.PurchaseAdminService ;
import ma.sir.ecom.service.facade.admin.CreditNotePurchaseItemAdminService ;


import java.util.List;
@Service
public class CreditNotePurchaseAdminServiceImpl extends AbstractServiceImpl<CreditNotePurchase,CreditNotePurchaseHistory, CreditNotePurchaseCriteria, CreditNotePurchaseHistoryCriteria, CreditNotePurchaseDao,
CreditNotePurchaseHistoryDao> implements CreditNotePurchaseAdminService {
    public static final String TEMPLATE = "template/creditNotePurchase.vm";
    public static final String FILE_NAME = "creditNotePurchase.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(CreditNotePurchaseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public CreditNotePurchase create(CreditNotePurchase t) {
        super.create(t);
        if (t.getCreditNotePurchaseItems() != null) {
                t.getCreditNotePurchaseItems().forEach(element-> {
                    element.setCreditNotePurchase(t);
                    creditNotePurchaseItemService.create(element);
            });
        }
        return t;
    }

    public CreditNotePurchase findWithAssociatedLists(Long id){
        CreditNotePurchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setCreditNotePurchaseItems(creditNotePurchaseItemService.findByCreditNotePurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        creditNotePurchaseItemService.deleteByCreditNotePurchaseId(id);
    }


    public void updateWithAssociatedLists(CreditNotePurchase creditNotePurchase){
    if(creditNotePurchase !=null && creditNotePurchase.getId() != null){
            List<List<CreditNotePurchaseItem>> resultCreditNotePurchaseItems= creditNotePurchaseItemService.getToBeSavedAndToBeDeleted(creditNotePurchaseItemService.findByCreditNotePurchaseId(creditNotePurchase.getId()),creditNotePurchase.getCreditNotePurchaseItems());
            creditNotePurchaseItemService.delete(resultCreditNotePurchaseItems.get(1));
            ListUtil.emptyIfNull(resultCreditNotePurchaseItems.get(0)).forEach(e -> e.setCreditNotePurchase(creditNotePurchase));
            creditNotePurchaseItemService.update(resultCreditNotePurchaseItems.get(0),true);
    }
    }


    public List<CreditNotePurchase> findByPurchaseId(Long id){
        return dao.findByPurchaseId(id);
    }
    public int deleteByPurchaseId(Long id){
        return dao.deleteByPurchaseId(id);
    }
    public List<CreditNotePurchase> findByCreditNotePurchaseStatusId(Long id){
        return dao.findByCreditNotePurchaseStatusId(id);
    }
    public int deleteByCreditNotePurchaseStatusId(Long id){
        return dao.deleteByCreditNotePurchaseStatusId(id);
    }




    public void configure() {
        super.configure(CreditNotePurchase.class,CreditNotePurchaseHistory.class, CreditNotePurchaseHistoryCriteria.class, CreditNotePurchaseSpecification.class);
    }

    @Autowired
    private CreditNotePurchaseStatusAdminService creditNotePurchaseStatusService ;
    @Autowired
    private PurchaseAdminService purchaseService ;
    @Autowired
    private CreditNotePurchaseItemAdminService creditNotePurchaseItemService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public CreditNotePurchaseAdminServiceImpl(CreditNotePurchaseDao dao, CreditNotePurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
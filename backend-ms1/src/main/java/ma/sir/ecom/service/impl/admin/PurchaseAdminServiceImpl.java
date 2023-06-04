package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Purchase;
import ma.sir.ecom.bean.history.PurchaseHistory;
import ma.sir.ecom.dao.criteria.core.PurchaseCriteria;
import ma.sir.ecom.dao.criteria.history.PurchaseHistoryCriteria;
import ma.sir.ecom.dao.facade.core.PurchaseDao;
import ma.sir.ecom.dao.facade.history.PurchaseHistoryDao;
import ma.sir.ecom.dao.specification.core.PurchaseSpecification;
import ma.sir.ecom.service.facade.admin.PurchaseAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.PurchaseDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.PurchaseItem;

import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.SupplierAdminService ;
import ma.sir.ecom.service.facade.admin.PurchaseItemAdminService ;
import ma.sir.ecom.service.facade.admin.PurchaseStatusAdminService ;


import java.util.List;
@Service
public class PurchaseAdminServiceImpl extends AbstractServiceImpl<Purchase,PurchaseHistory, PurchaseCriteria, PurchaseHistoryCriteria, PurchaseDao,
PurchaseHistoryDao> implements PurchaseAdminService {
    public static final String TEMPLATE = "template/purchase.vm";
    public static final String FILE_NAME = "purchase.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(PurchaseDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Purchase create(Purchase t) {
        super.create(t);
        if (t.getPurchaseItems() != null) {
                t.getPurchaseItems().forEach(element-> {
                    element.setPurchase(t);
                    purchaseItemService.create(element);
            });
        }
        return t;
    }

    public Purchase findWithAssociatedLists(Long id){
        Purchase result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setPurchaseItems(purchaseItemService.findByPurchaseId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        purchaseItemService.deleteByPurchaseId(id);
    }


    public void updateWithAssociatedLists(Purchase purchase){
    if(purchase !=null && purchase.getId() != null){
            List<List<PurchaseItem>> resultPurchaseItems= purchaseItemService.getToBeSavedAndToBeDeleted(purchaseItemService.findByPurchaseId(purchase.getId()),purchase.getPurchaseItems());
            purchaseItemService.delete(resultPurchaseItems.get(1));
            ListUtil.emptyIfNull(resultPurchaseItems.get(0)).forEach(e -> e.setPurchase(purchase));
            purchaseItemService.update(resultPurchaseItems.get(0),true);
    }
    }

    public Purchase findByReferenceEntity(Purchase t){
        return  dao.findByReference(t.getReference());
    }

    public List<Purchase> findBySupplierId(Long id){
        return dao.findBySupplierId(id);
    }
    public int deleteBySupplierId(Long id){
        return dao.deleteBySupplierId(id);
    }
    public List<Purchase> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<Purchase> findByPurchaseStatusId(Long id){
        return dao.findByPurchaseStatusId(id);
    }
    public int deleteByPurchaseStatusId(Long id){
        return dao.deleteByPurchaseStatusId(id);
    }




    public void configure() {
        super.configure(Purchase.class,PurchaseHistory.class, PurchaseHistoryCriteria.class, PurchaseSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private SupplierAdminService supplierService ;
    @Autowired
    private PurchaseItemAdminService purchaseItemService ;
    @Autowired
    private PurchaseStatusAdminService purchaseStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public PurchaseAdminServiceImpl(PurchaseDao dao, PurchaseHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
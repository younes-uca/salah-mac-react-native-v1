package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Sale;
import ma.sir.ecom.bean.history.SaleHistory;
import ma.sir.ecom.dao.criteria.core.SaleCriteria;
import ma.sir.ecom.dao.criteria.history.SaleHistoryCriteria;
import ma.sir.ecom.dao.facade.core.SaleDao;
import ma.sir.ecom.dao.facade.history.SaleHistoryDao;
import ma.sir.ecom.dao.specification.core.SaleSpecification;
import ma.sir.ecom.service.facade.admin.SaleAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.SaleDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.SaleItem;

import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.SaleItemAdminService ;
import ma.sir.ecom.service.facade.admin.ClientAdminService ;
import ma.sir.ecom.service.facade.admin.SaleStatusAdminService ;


import java.util.List;
@Service
public class SaleAdminServiceImpl extends AbstractServiceImpl<Sale,SaleHistory, SaleCriteria, SaleHistoryCriteria, SaleDao,
SaleHistoryDao> implements SaleAdminService {
    public static final String TEMPLATE = "template/sale.vm";
    public static final String FILE_NAME = "sale.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(SaleDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Sale create(Sale t) {
        super.create(t);
        if (t.getSaleItems() != null) {
                t.getSaleItems().forEach(element-> {
                    element.setSale(t);
                    saleItemService.create(element);
            });
        }
        return t;
    }

    public Sale findWithAssociatedLists(Long id){
        Sale result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setSaleItems(saleItemService.findBySaleId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        saleItemService.deleteBySaleId(id);
    }


    public void updateWithAssociatedLists(Sale sale){
    if(sale !=null && sale.getId() != null){
            List<List<SaleItem>> resultSaleItems= saleItemService.getToBeSavedAndToBeDeleted(saleItemService.findBySaleId(sale.getId()),sale.getSaleItems());
            saleItemService.delete(resultSaleItems.get(1));
            ListUtil.emptyIfNull(resultSaleItems.get(0)).forEach(e -> e.setSale(sale));
            saleItemService.update(resultSaleItems.get(0),true);
    }
    }

    public Sale findByReferenceEntity(Sale t){
        return  dao.findByReference(t.getReference());
    }

    public List<Sale> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<Sale> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Sale> findBySaleStatusId(Long id){
        return dao.findBySaleStatusId(id);
    }
    public int deleteBySaleStatusId(Long id){
        return dao.deleteBySaleStatusId(id);
    }




    public void configure() {
        super.configure(Sale.class,SaleHistory.class, SaleHistoryCriteria.class, SaleSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private SaleItemAdminService saleItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private SaleStatusAdminService saleStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public SaleAdminServiceImpl(SaleDao dao, SaleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
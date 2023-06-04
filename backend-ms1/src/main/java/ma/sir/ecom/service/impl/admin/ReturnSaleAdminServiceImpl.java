package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ReturnSale;
import ma.sir.ecom.bean.history.ReturnSaleHistory;
import ma.sir.ecom.dao.criteria.core.ReturnSaleCriteria;
import ma.sir.ecom.dao.criteria.history.ReturnSaleHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReturnSaleDao;
import ma.sir.ecom.dao.facade.history.ReturnSaleHistoryDao;
import ma.sir.ecom.dao.specification.core.ReturnSaleSpecification;
import ma.sir.ecom.service.facade.admin.ReturnSaleAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReturnSaleDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.ReturnSaleItem;

import ma.sir.ecom.service.facade.admin.SaleAdminService ;
import ma.sir.ecom.service.facade.admin.ReturnSaleItemAdminService ;
import ma.sir.ecom.service.facade.admin.ReturnStatusAdminService ;


import java.util.List;
@Service
public class ReturnSaleAdminServiceImpl extends AbstractServiceImpl<ReturnSale,ReturnSaleHistory, ReturnSaleCriteria, ReturnSaleHistoryCriteria, ReturnSaleDao,
ReturnSaleHistoryDao> implements ReturnSaleAdminService {
    public static final String TEMPLATE = "template/returnSale.vm";
    public static final String FILE_NAME = "returnSale.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReturnSaleDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public ReturnSale create(ReturnSale t) {
        super.create(t);
        if (t.getReturnSaleItems() != null) {
                t.getReturnSaleItems().forEach(element-> {
                    element.setReturnSale(t);
                    returnSaleItemService.create(element);
            });
        }
        return t;
    }

    public ReturnSale findWithAssociatedLists(Long id){
        ReturnSale result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setReturnSaleItems(returnSaleItemService.findByReturnSaleId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        returnSaleItemService.deleteByReturnSaleId(id);
    }


    public void updateWithAssociatedLists(ReturnSale returnSale){
    if(returnSale !=null && returnSale.getId() != null){
            List<List<ReturnSaleItem>> resultReturnSaleItems= returnSaleItemService.getToBeSavedAndToBeDeleted(returnSaleItemService.findByReturnSaleId(returnSale.getId()),returnSale.getReturnSaleItems());
            returnSaleItemService.delete(resultReturnSaleItems.get(1));
            ListUtil.emptyIfNull(resultReturnSaleItems.get(0)).forEach(e -> e.setReturnSale(returnSale));
            returnSaleItemService.update(resultReturnSaleItems.get(0),true);
    }
    }


    public List<ReturnSale> findBySaleId(Long id){
        return dao.findBySaleId(id);
    }
    public int deleteBySaleId(Long id){
        return dao.deleteBySaleId(id);
    }
    public List<ReturnSale> findByReturnStatusId(Long id){
        return dao.findByReturnStatusId(id);
    }
    public int deleteByReturnStatusId(Long id){
        return dao.deleteByReturnStatusId(id);
    }




    public void configure() {
        super.configure(ReturnSale.class,ReturnSaleHistory.class, ReturnSaleHistoryCriteria.class, ReturnSaleSpecification.class);
    }

    @Autowired
    private SaleAdminService saleService ;
    @Autowired
    private ReturnSaleItemAdminService returnSaleItemService ;
    @Autowired
    private ReturnStatusAdminService returnStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReturnSaleAdminServiceImpl(ReturnSaleDao dao, ReturnSaleHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
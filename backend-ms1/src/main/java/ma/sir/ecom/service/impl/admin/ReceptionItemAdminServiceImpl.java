package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.ReceptionItem;
import ma.sir.ecom.bean.history.ReceptionItemHistory;
import ma.sir.ecom.dao.criteria.core.ReceptionItemCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ReceptionItemDao;
import ma.sir.ecom.dao.facade.history.ReceptionItemHistoryDao;
import ma.sir.ecom.dao.specification.core.ReceptionItemSpecification;
import ma.sir.ecom.service.facade.admin.ReceptionItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ReceptionItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.ReceptionAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class ReceptionItemAdminServiceImpl extends AbstractServiceImpl<ReceptionItem,ReceptionItemHistory, ReceptionItemCriteria, ReceptionItemHistoryCriteria, ReceptionItemDao,
ReceptionItemHistoryDao> implements ReceptionItemAdminService {
    public static final String TEMPLATE = "template/receptionItem.vm";
    public static final String FILE_NAME = "receptionItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ReceptionItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<ReceptionItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<ReceptionItem> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<ReceptionItem> findByReceptionId(Long id){
        return dao.findByReceptionId(id);
    }
    public int deleteByReceptionId(Long id){
        return dao.deleteByReceptionId(id);
    }




    public void configure() {
        super.configure(ReceptionItem.class,ReceptionItemHistory.class, ReceptionItemHistoryCriteria.class, ReceptionItemSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private ReceptionAdminService receptionService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public ReceptionItemAdminServiceImpl(ReceptionItemDao dao, ReceptionItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
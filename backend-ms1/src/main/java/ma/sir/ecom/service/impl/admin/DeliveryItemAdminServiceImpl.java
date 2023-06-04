package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.DeliveryItem;
import ma.sir.ecom.bean.history.DeliveryItemHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryItemCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DeliveryItemDao;
import ma.sir.ecom.dao.facade.history.DeliveryItemHistoryDao;
import ma.sir.ecom.dao.specification.core.DeliveryItemSpecification;
import ma.sir.ecom.service.facade.admin.DeliveryItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DeliveryItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.StoreAdminService ;
import ma.sir.ecom.service.facade.admin.DeliveryAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class DeliveryItemAdminServiceImpl extends AbstractServiceImpl<DeliveryItem,DeliveryItemHistory, DeliveryItemCriteria, DeliveryItemHistoryCriteria, DeliveryItemDao,
DeliveryItemHistoryDao> implements DeliveryItemAdminService {
    public static final String TEMPLATE = "template/deliveryItem.vm";
    public static final String FILE_NAME = "deliveryItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeliveryItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<DeliveryItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<DeliveryItem> findByStoreId(Long id){
        return dao.findByStoreId(id);
    }
    public int deleteByStoreId(Long id){
        return dao.deleteByStoreId(id);
    }
    public List<DeliveryItem> findByDeliveryId(Long id){
        return dao.findByDeliveryId(id);
    }
    public int deleteByDeliveryId(Long id){
        return dao.deleteByDeliveryId(id);
    }




    public void configure() {
        super.configure(DeliveryItem.class,DeliveryItemHistory.class, DeliveryItemHistoryCriteria.class, DeliveryItemSpecification.class);
    }

    @Autowired
    private StoreAdminService storeService ;
    @Autowired
    private DeliveryAdminService deliveryService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeliveryItemAdminServiceImpl(DeliveryItemDao dao, DeliveryItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
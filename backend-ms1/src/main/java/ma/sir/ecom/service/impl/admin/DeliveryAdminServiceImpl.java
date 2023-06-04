package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Delivery;
import ma.sir.ecom.bean.history.DeliveryHistory;
import ma.sir.ecom.dao.criteria.core.DeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryHistoryCriteria;
import ma.sir.ecom.dao.facade.core.DeliveryDao;
import ma.sir.ecom.dao.facade.history.DeliveryHistoryDao;
import ma.sir.ecom.dao.specification.core.DeliverySpecification;
import ma.sir.ecom.service.facade.admin.DeliveryAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.DeliveryDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.DeliveryItem;

import ma.sir.ecom.service.facade.admin.DeliveryStatusAdminService ;
import ma.sir.ecom.service.facade.admin.ClientAdminService ;
import ma.sir.ecom.service.facade.admin.DeliveryItemAdminService ;
import ma.sir.ecom.service.facade.admin.DemandAdminService ;


import java.util.List;
@Service
public class DeliveryAdminServiceImpl extends AbstractServiceImpl<Delivery,DeliveryHistory, DeliveryCriteria, DeliveryHistoryCriteria, DeliveryDao,
DeliveryHistoryDao> implements DeliveryAdminService {
    public static final String TEMPLATE = "template/delivery.vm";
    public static final String FILE_NAME = "delivery.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(DeliveryDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Delivery create(Delivery t) {
        super.create(t);
        if (t.getDeliveryItems() != null) {
                t.getDeliveryItems().forEach(element-> {
                    element.setDelivery(t);
                    deliveryItemService.create(element);
            });
        }
        return t;
    }

    public Delivery findWithAssociatedLists(Long id){
        Delivery result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setDeliveryItems(deliveryItemService.findByDeliveryId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        deliveryItemService.deleteByDeliveryId(id);
    }


    public void updateWithAssociatedLists(Delivery delivery){
    if(delivery !=null && delivery.getId() != null){
            List<List<DeliveryItem>> resultDeliveryItems= deliveryItemService.getToBeSavedAndToBeDeleted(deliveryItemService.findByDeliveryId(delivery.getId()),delivery.getDeliveryItems());
            deliveryItemService.delete(resultDeliveryItems.get(1));
            ListUtil.emptyIfNull(resultDeliveryItems.get(0)).forEach(e -> e.setDelivery(delivery));
            deliveryItemService.update(resultDeliveryItems.get(0),true);
    }
    }


    public List<Delivery> findByDemandId(Long id){
        return dao.findByDemandId(id);
    }
    public int deleteByDemandId(Long id){
        return dao.deleteByDemandId(id);
    }
    public List<Delivery> findByDeliveryStatusId(Long id){
        return dao.findByDeliveryStatusId(id);
    }
    public int deleteByDeliveryStatusId(Long id){
        return dao.deleteByDeliveryStatusId(id);
    }
    public List<Delivery> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }




    public void configure() {
        super.configure(Delivery.class,DeliveryHistory.class, DeliveryHistoryCriteria.class, DeliverySpecification.class);
    }

    @Autowired
    private DeliveryStatusAdminService deliveryStatusService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private DeliveryItemAdminService deliveryItemService ;
    @Autowired
    private DemandAdminService demandService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public DeliveryAdminServiceImpl(DeliveryDao dao, DeliveryHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
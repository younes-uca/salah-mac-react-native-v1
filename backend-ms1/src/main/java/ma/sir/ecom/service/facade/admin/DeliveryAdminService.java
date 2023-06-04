package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Delivery;
import ma.sir.ecom.dao.criteria.core.DeliveryCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DeliveryDto;
import org.springframework.http.HttpEntity;

public interface DeliveryAdminService extends  IService<Delivery,DeliveryCriteria, DeliveryHistoryCriteria>  {

    List<Delivery> findByDemandId(Long id);
    int deleteByDemandId(Long id);
    List<Delivery> findByDeliveryStatusId(Long id);
    int deleteByDeliveryStatusId(Long id);
    List<Delivery> findByClientId(Long id);
    int deleteByClientId(Long id);

    HttpEntity<byte[]> createPdf(DeliveryDto dto) throws Exception;


}

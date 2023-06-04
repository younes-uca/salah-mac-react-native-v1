package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.DeliveryItem;
import ma.sir.ecom.dao.criteria.core.DeliveryItemCriteria;
import ma.sir.ecom.dao.criteria.history.DeliveryItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.DeliveryItemDto;
import org.springframework.http.HttpEntity;

public interface DeliveryItemAdminService extends  IService<DeliveryItem,DeliveryItemCriteria, DeliveryItemHistoryCriteria>  {

    List<DeliveryItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<DeliveryItem> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<DeliveryItem> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);

    HttpEntity<byte[]> createPdf(DeliveryItemDto dto) throws Exception;


}

package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.DeliveryItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DeliveryItemDao extends AbstractRepository<DeliveryItem,Long>  {

    List<DeliveryItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<DeliveryItem> findByStoreId(Long id);
    int deleteByStoreId(Long id);
    List<DeliveryItem> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);

}

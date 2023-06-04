package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Delivery;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DeliveryDao extends AbstractRepository<Delivery,Long>  {

    List<Delivery> findByDemandId(Long id);
    int deleteByDemandId(Long id);
    List<Delivery> findByDeliveryStatusId(Long id);
    int deleteByDeliveryStatusId(Long id);
    List<Delivery> findByClientId(Long id);
    int deleteByClientId(Long id);

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DeliveryStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryStatusHistoryDao extends AbstractHistoryRepository<DeliveryStatusHistory,Long> {

}

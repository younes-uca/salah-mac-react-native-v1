package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DeliveryItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryItemHistoryDao extends AbstractHistoryRepository<DeliveryItemHistory,Long> {

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SubscriberHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberHistoryDao extends AbstractHistoryRepository<SubscriberHistory,Long> {

}

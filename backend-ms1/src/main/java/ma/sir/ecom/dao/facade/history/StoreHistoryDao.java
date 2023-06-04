package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.StoreHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHistoryDao extends AbstractHistoryRepository<StoreHistory,Long> {

}

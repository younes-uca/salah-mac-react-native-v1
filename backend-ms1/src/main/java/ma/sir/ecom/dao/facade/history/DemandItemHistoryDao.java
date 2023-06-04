package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DemandItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandItemHistoryDao extends AbstractHistoryRepository<DemandItemHistory,Long> {

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DemandHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandHistoryDao extends AbstractHistoryRepository<DemandHistory,Long> {

}

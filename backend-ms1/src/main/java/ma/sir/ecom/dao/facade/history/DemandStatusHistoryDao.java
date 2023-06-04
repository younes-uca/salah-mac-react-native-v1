package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DemandStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandStatusHistoryDao extends AbstractHistoryRepository<DemandStatusHistory,Long> {

}

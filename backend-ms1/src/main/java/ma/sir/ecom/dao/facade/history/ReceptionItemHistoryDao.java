package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ReceptionItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionItemHistoryDao extends AbstractHistoryRepository<ReceptionItemHistory,Long> {

}

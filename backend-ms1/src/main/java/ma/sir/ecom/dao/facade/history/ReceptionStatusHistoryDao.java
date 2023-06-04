package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ReceptionStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionStatusHistoryDao extends AbstractHistoryRepository<ReceptionStatusHistory,Long> {

}

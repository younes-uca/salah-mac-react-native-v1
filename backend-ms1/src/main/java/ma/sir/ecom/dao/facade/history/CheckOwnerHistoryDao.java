package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CheckOwnerHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOwnerHistoryDao extends AbstractHistoryRepository<CheckOwnerHistory,Long> {

}

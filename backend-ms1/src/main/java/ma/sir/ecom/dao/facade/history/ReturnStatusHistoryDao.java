package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ReturnStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnStatusHistoryDao extends AbstractHistoryRepository<ReturnStatusHistory,Long> {

}

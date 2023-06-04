package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.HandlingAccountantHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface HandlingAccountantHistoryDao extends AbstractHistoryRepository<HandlingAccountantHistory,Long> {

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ValidationAccountantHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationAccountantHistoryDao extends AbstractHistoryRepository<ValidationAccountantHistory,Long> {

}

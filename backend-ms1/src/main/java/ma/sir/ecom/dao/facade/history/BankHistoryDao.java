package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.BankHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BankHistoryDao extends AbstractHistoryRepository<BankHistory,Long> {

}

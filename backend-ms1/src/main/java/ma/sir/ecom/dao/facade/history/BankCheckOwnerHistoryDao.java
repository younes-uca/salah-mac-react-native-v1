package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.BankCheckOwnerHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BankCheckOwnerHistoryDao extends AbstractHistoryRepository<BankCheckOwnerHistory,Long> {

}

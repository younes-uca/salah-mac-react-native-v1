package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.BalanceSheetStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceSheetStatusHistoryDao extends AbstractHistoryRepository<BalanceSheetStatusHistory,Long> {

}

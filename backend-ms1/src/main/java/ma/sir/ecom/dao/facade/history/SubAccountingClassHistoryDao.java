package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SubAccountingClassHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SubAccountingClassHistoryDao extends AbstractHistoryRepository<SubAccountingClassHistory,Long> {

}

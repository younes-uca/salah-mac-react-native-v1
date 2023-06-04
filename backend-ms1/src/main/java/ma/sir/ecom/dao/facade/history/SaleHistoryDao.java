package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SaleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleHistoryDao extends AbstractHistoryRepository<SaleHistory,Long> {

}

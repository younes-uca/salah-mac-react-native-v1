package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SaleItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemHistoryDao extends AbstractHistoryRepository<SaleItemHistory,Long> {

}

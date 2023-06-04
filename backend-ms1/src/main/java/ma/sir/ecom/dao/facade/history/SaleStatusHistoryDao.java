package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SaleStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleStatusHistoryDao extends AbstractHistoryRepository<SaleStatusHistory,Long> {

}

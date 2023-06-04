package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ReturnSaleItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnSaleItemHistoryDao extends AbstractHistoryRepository<ReturnSaleItemHistory,Long> {

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ReturnSaleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnSaleHistoryDao extends AbstractHistoryRepository<ReturnSaleHistory,Long> {

}

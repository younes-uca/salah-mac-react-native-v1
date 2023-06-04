package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SupplierQuoteHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierQuoteHistoryDao extends AbstractHistoryRepository<SupplierQuoteHistory,Long> {

}

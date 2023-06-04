package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SupplierQuoteItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierQuoteItemHistoryDao extends AbstractHistoryRepository<SupplierQuoteItemHistory,Long> {

}

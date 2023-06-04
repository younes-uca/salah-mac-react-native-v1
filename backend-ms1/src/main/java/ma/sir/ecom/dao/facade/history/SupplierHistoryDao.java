package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.SupplierHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierHistoryDao extends AbstractHistoryRepository<SupplierHistory,Long> {

}

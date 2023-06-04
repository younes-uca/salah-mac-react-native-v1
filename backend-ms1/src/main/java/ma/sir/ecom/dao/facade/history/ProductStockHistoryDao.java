package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ProductStockHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockHistoryDao extends AbstractHistoryRepository<ProductStockHistory,Long> {

}

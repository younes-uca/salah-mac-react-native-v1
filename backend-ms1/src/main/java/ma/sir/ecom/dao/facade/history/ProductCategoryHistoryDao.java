package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ProductCategoryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryHistoryDao extends AbstractHistoryRepository<ProductCategoryHistory,Long> {

}

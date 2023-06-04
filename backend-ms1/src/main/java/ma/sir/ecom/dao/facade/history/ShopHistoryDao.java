package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.ShopHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopHistoryDao extends AbstractHistoryRepository<ShopHistory,Long> {

}

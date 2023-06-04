package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentPurchaseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentPurchaseHistoryDao extends AbstractHistoryRepository<PaymentPurchaseHistory,Long> {

}

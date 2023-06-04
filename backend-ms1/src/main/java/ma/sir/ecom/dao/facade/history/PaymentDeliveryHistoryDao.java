package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentDeliveryHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDeliveryHistoryDao extends AbstractHistoryRepository<PaymentDeliveryHistory,Long> {

}

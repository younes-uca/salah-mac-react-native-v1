package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentStatusHistoryDao extends AbstractHistoryRepository<PaymentStatusHistory,Long> {

}

package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentSaleHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSaleHistoryDao extends AbstractHistoryRepository<PaymentSaleHistory,Long> {

}

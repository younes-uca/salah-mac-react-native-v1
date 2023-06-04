package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CorporateTaxRateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CorporateTaxRateHistoryDao extends AbstractHistoryRepository<CorporateTaxRateHistory,Long> {

}

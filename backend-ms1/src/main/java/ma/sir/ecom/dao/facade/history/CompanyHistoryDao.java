package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CompanyHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyHistoryDao extends AbstractHistoryRepository<CompanyHistory,Long> {

}

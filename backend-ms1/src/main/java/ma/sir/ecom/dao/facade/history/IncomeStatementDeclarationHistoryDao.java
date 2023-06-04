package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.IncomeStatementDeclarationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeStatementDeclarationHistoryDao extends AbstractHistoryRepository<IncomeStatementDeclarationHistory,Long> {

}

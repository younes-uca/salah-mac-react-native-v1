package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.VatDeclarationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface VatDeclarationHistoryDao extends AbstractHistoryRepository<VatDeclarationHistory,Long> {

}

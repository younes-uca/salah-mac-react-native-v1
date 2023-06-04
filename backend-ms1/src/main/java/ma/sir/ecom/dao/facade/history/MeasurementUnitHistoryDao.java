package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.MeasurementUnitHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementUnitHistoryDao extends AbstractHistoryRepository<MeasurementUnitHistory,Long> {

}

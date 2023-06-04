package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Demand;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Demand;
import java.util.List;


@Repository
public interface DemandDao extends AbstractRepository<Demand,Long>  {
    Demand findByReference(String reference);
    int deleteByReference(String reference);

    List<Demand> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Demand> findByDemandStatusId(Long id);
    int deleteByDemandStatusId(Long id);

    @Query("SELECT NEW Demand(item.id,item.reference) FROM Demand item")
    List<Demand> findAllOptimized();
}

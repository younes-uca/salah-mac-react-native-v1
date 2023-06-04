package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.DemandItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DemandItemDao extends AbstractRepository<DemandItem,Long>  {

    List<DemandItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<DemandItem> findByDemandId(Long id);
    int deleteByDemandId(Long id);

}

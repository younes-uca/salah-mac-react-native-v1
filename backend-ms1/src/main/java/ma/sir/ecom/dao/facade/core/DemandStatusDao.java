package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.DemandStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.DemandStatus;
import java.util.List;


@Repository
public interface DemandStatusDao extends AbstractRepository<DemandStatus,Long>  {
    DemandStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW DemandStatus(item.id,item.libelle) FROM DemandStatus item")
    List<DemandStatus> findAllOptimized();
}

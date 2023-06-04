package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.DeliveryStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.DeliveryStatus;
import java.util.List;


@Repository
public interface DeliveryStatusDao extends AbstractRepository<DeliveryStatus,Long>  {
    DeliveryStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW DeliveryStatus(item.id,item.libelle) FROM DeliveryStatus item")
    List<DeliveryStatus> findAllOptimized();
}

package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.StatusPaymentDemand;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.StatusPaymentDemand;
import java.util.List;


@Repository
public interface StatusPaymentDemandDao extends AbstractRepository<StatusPaymentDemand,Long>  {
    StatusPaymentDemand findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW StatusPaymentDemand(item.id,item.libelle) FROM StatusPaymentDemand item")
    List<StatusPaymentDemand> findAllOptimized();
}

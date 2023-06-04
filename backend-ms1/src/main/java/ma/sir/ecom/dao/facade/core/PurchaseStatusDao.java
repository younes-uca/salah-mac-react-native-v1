package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PurchaseStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PurchaseStatus;
import java.util.List;


@Repository
public interface PurchaseStatusDao extends AbstractRepository<PurchaseStatus,Long>  {
    PurchaseStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PurchaseStatus(item.id,item.libelle) FROM PurchaseStatus item")
    List<PurchaseStatus> findAllOptimized();
}

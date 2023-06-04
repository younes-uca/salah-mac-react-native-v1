package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.CreditNotePurchaseStatus;
import java.util.List;


@Repository
public interface CreditNotePurchaseStatusDao extends AbstractRepository<CreditNotePurchaseStatus,Long>  {
    CreditNotePurchaseStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW CreditNotePurchaseStatus(item.id,item.libelle) FROM CreditNotePurchaseStatus item")
    List<CreditNotePurchaseStatus> findAllOptimized();
}

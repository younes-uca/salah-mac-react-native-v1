package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.CreditNotePurchaseItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CreditNotePurchaseItemDao extends AbstractRepository<CreditNotePurchaseItem,Long>  {

    List<CreditNotePurchaseItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<CreditNotePurchaseItem> findByCreditNotePurchaseId(Long id);
    int deleteByCreditNotePurchaseId(Long id);

}

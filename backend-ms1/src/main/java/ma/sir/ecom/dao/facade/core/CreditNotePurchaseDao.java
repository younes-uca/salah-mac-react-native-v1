package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.CreditNotePurchase;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CreditNotePurchaseDao extends AbstractRepository<CreditNotePurchase,Long>  {

    List<CreditNotePurchase> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<CreditNotePurchase> findByCreditNotePurchaseStatusId(Long id);
    int deleteByCreditNotePurchaseStatusId(Long id);

}

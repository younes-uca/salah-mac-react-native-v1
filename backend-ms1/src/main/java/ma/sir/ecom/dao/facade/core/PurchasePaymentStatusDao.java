package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PurchasePaymentStatus;
import java.util.List;


@Repository
public interface PurchasePaymentStatusDao extends AbstractRepository<PurchasePaymentStatus,Long>  {
    PurchasePaymentStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PurchasePaymentStatus(item.id,item.libelle) FROM PurchasePaymentStatus item")
    List<PurchasePaymentStatus> findAllOptimized();
}

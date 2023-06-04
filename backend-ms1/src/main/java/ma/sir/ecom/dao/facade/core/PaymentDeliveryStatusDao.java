package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentDeliveryStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentDeliveryStatus;
import java.util.List;


@Repository
public interface PaymentDeliveryStatusDao extends AbstractRepository<PaymentDeliveryStatus,Long>  {
    PaymentDeliveryStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PaymentDeliveryStatus(item.id,item.libelle) FROM PaymentDeliveryStatus item")
    List<PaymentDeliveryStatus> findAllOptimized();
}

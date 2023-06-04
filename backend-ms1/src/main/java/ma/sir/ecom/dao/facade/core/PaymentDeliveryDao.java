package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentDelivery;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentDelivery;
import java.util.List;


@Repository
public interface PaymentDeliveryDao extends AbstractRepository<PaymentDelivery,Long>  {
    PaymentDelivery findByReference(String reference);
    int deleteByReference(String reference);

    List<PaymentDelivery> findByDeliveryId(Long id);
    int deleteByDeliveryId(Long id);
    List<PaymentDelivery> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<PaymentDelivery> findByPaymentMethodId(Long id);
    int deleteByPaymentMethodId(Long id);
    List<PaymentDelivery> findByPaymentDeliveryStatusId(Long id);
    int deleteByPaymentDeliveryStatusId(Long id);

    @Query("SELECT NEW PaymentDelivery(item.id,item.reference) FROM PaymentDelivery item")
    List<PaymentDelivery> findAllOptimized();
}

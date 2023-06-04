package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentPurchase;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentPurchase;
import java.util.List;


@Repository
public interface PaymentPurchaseDao extends AbstractRepository<PaymentPurchase,Long>  {
    PaymentPurchase findByReference(String reference);
    int deleteByReference(String reference);

    List<PaymentPurchase> findByPurchaseId(Long id);
    int deleteByPurchaseId(Long id);
    List<PaymentPurchase> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<PaymentPurchase> findByPurchasePaymentStatusId(Long id);
    int deleteByPurchasePaymentStatusId(Long id);

    @Query("SELECT NEW PaymentPurchase(item.id,item.reference) FROM PaymentPurchase item")
    List<PaymentPurchase> findAllOptimized();
}

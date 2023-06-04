package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentSale;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentSale;
import java.util.List;


@Repository
public interface PaymentSaleDao extends AbstractRepository<PaymentSale,Long>  {
    PaymentSale findByReference(String reference);
    int deleteByReference(String reference);

    List<PaymentSale> findBySaleId(Long id);
    int deleteBySaleId(Long id);
    List<PaymentSale> findByPaymentMethodId(Long id);
    int deleteByPaymentMethodId(Long id);
    List<PaymentSale> findByPaymentStatusId(Long id);
    int deleteByPaymentStatusId(Long id);

    @Query("SELECT NEW PaymentSale(item.id,item.reference) FROM PaymentSale item")
    List<PaymentSale> findAllOptimized();
}

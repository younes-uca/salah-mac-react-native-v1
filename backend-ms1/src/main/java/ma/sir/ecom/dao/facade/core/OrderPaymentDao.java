package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.OrderPayment;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.OrderPayment;
import java.util.List;


@Repository
public interface OrderPaymentDao extends AbstractRepository<OrderPayment,Long>  {
    OrderPayment findByReference(String reference);
    int deleteByReference(String reference);

    List<OrderPayment> findByOrderId(Long id);
    int deleteByOrderId(Long id);
    List<OrderPayment> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<OrderPayment> findByOrderStatusOrderId(Long id);
    int deleteByOrderStatusOrderId(Long id);

    @Query("SELECT NEW OrderPayment(item.id,item.reference) FROM OrderPayment item")
    List<OrderPayment> findAllOptimized();
}

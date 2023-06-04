package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.OrderItem;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface OrderItemDao extends AbstractRepository<OrderItem,Long>  {

    List<OrderItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<OrderItem> findByOrderId(Long id);
    int deleteByOrderId(Long id);

}

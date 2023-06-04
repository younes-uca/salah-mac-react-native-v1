package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Order;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Order;
import java.util.List;


@Repository
public interface OrderDao extends AbstractRepository<Order,Long>  {
    Order findByReference(String reference);
    int deleteByReference(String reference);

    List<Order> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Order> findByOrderStatusId(Long id);
    int deleteByOrderStatusId(Long id);

    @Query("SELECT NEW Order(item.id,item.reference) FROM Order item")
    List<Order> findAllOptimized();
}

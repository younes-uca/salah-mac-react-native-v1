package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.OrderStatusOrder;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.OrderStatusOrder;
import java.util.List;


@Repository
public interface OrderStatusOrderDao extends AbstractRepository<OrderStatusOrder,Long>  {
    OrderStatusOrder findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW OrderStatusOrder(item.id,item.libelle) FROM OrderStatusOrder item")
    List<OrderStatusOrder> findAllOptimized();
}

package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.OrderStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.OrderStatus;
import java.util.List;


@Repository
public interface OrderStatusDao extends AbstractRepository<OrderStatus,Long>  {
    OrderStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW OrderStatus(item.id,item.libelle) FROM OrderStatus item")
    List<OrderStatus> findAllOptimized();
}

package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Subscriber;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Subscriber;
import java.util.List;


@Repository
public interface SubscriberDao extends AbstractRepository<Subscriber,Long>  {
    Subscriber findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW Subscriber(item.id,item.code) FROM Subscriber item")
    List<Subscriber> findAllOptimized();
}

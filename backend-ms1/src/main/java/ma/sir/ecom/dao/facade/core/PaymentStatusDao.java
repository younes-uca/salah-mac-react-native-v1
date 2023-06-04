package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentStatus;
import java.util.List;


@Repository
public interface PaymentStatusDao extends AbstractRepository<PaymentStatus,Long>  {
    PaymentStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PaymentStatus(item.id,item.libelle) FROM PaymentStatus item")
    List<PaymentStatus> findAllOptimized();
}

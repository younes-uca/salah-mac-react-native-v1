package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentMode;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentMode;
import java.util.List;


@Repository
public interface PaymentModeDao extends AbstractRepository<PaymentMode,Long>  {
    PaymentMode findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PaymentMode(item.id,item.libelle) FROM PaymentMode item")
    List<PaymentMode> findAllOptimized();
}

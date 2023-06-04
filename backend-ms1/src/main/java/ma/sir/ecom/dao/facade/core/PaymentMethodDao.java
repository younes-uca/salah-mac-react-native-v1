package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.PaymentMethod;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.PaymentMethod;
import java.util.List;


@Repository
public interface PaymentMethodDao extends AbstractRepository<PaymentMethod,Long>  {
    PaymentMethod findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW PaymentMethod(item.id,item.libelle) FROM PaymentMethod item")
    List<PaymentMethod> findAllOptimized();
}

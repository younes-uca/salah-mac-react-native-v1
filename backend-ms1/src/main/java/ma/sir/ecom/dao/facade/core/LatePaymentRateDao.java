package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.LatePaymentRate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LatePaymentRateDao extends AbstractRepository<LatePaymentRate,Long>  {


}

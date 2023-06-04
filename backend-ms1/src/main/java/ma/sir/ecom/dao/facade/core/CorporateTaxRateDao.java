package ma.sir.ecom.dao.facade.core;

import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.CorporateTaxRate;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CorporateTaxRateDao extends AbstractRepository<CorporateTaxRate,Long>  {


}

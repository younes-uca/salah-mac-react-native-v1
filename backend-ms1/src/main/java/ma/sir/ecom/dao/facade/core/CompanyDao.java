package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.Company;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.Company;
import java.util.List;


@Repository
public interface CompanyDao extends AbstractRepository<Company,Long>  {
    Company findByIce(String ice);
    int deleteByIce(String ice);

    List<Company> findBySubscriberId(Long id);
    int deleteBySubscriberId(Long id);

    @Query("SELECT NEW Company(item.id,item.ice) FROM Company item")
    List<Company> findAllOptimized();
}

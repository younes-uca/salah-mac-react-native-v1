package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.ReceptionStatus;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.ReceptionStatus;
import java.util.List;


@Repository
public interface ReceptionStatusDao extends AbstractRepository<ReceptionStatus,Long>  {
    ReceptionStatus findByCode(String code);
    int deleteByCode(String code);


    @Query("SELECT NEW ReceptionStatus(item.id,item.libelle) FROM ReceptionStatus item")
    List<ReceptionStatus> findAllOptimized();
}

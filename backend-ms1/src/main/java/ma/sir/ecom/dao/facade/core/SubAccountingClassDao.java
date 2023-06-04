package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.SubAccountingClass;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.SubAccountingClass;
import java.util.List;


@Repository
public interface SubAccountingClassDao extends AbstractRepository<SubAccountingClass,Long>  {
    SubAccountingClass findByCode(String code);
    int deleteByCode(String code);

    List<SubAccountingClass> findByAccountingClassId(Long id);
    int deleteByAccountingClassId(Long id);

    @Query("SELECT NEW SubAccountingClass(item.id,item.libelle) FROM SubAccountingClass item")
    List<SubAccountingClass> findAllOptimized();
}

package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.DemandPayment;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.DemandPayment;
import java.util.List;


@Repository
public interface DemandPaymentDao extends AbstractRepository<DemandPayment,Long>  {
    DemandPayment findByReference(String reference);
    int deleteByReference(String reference);

    List<DemandPayment> findByDemandId(Long id);
    int deleteByDemandId(Long id);
    List<DemandPayment> findByPaymentModeId(Long id);
    int deleteByPaymentModeId(Long id);
    List<DemandPayment> findByStatusPaymentDemandId(Long id);
    int deleteByStatusPaymentDemandId(Long id);

    @Query("SELECT NEW DemandPayment(item.id,item.reference) FROM DemandPayment item")
    List<DemandPayment> findAllOptimized();
}

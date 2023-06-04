package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.VatDeclaration;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.VatDeclaration;
import java.util.List;


@Repository
public interface VatDeclarationDao extends AbstractRepository<VatDeclaration,Long>  {
    VatDeclaration findByReference(String reference);
    int deleteByReference(String reference);

    List<VatDeclaration> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<VatDeclaration> findByLatePaymentRateId(Long id);
    int deleteByLatePaymentRateId(Long id);
    List<VatDeclaration> findByHandlingAccountantId(Long id);
    int deleteByHandlingAccountantId(Long id);
    List<VatDeclaration> findByValidationAccountantId(Long id);
    int deleteByValidationAccountantId(Long id);

    @Query("SELECT NEW VatDeclaration(item.id,item.reference) FROM VatDeclaration item")
    List<VatDeclaration> findAllOptimized();
}

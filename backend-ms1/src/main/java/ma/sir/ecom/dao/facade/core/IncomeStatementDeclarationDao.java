package ma.sir.ecom.dao.facade.core;

import org.springframework.data.jpa.repository.Query;
import ma.sir.ecom.zynerator.repository.AbstractRepository;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import org.springframework.stereotype.Repository;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import java.util.List;


@Repository
public interface IncomeStatementDeclarationDao extends AbstractRepository<IncomeStatementDeclaration,Long>  {
    IncomeStatementDeclaration findByReference(String reference);
    int deleteByReference(String reference);

    List<IncomeStatementDeclaration> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<IncomeStatementDeclaration> findByCorporateTaxRateId(Long id);
    int deleteByCorporateTaxRateId(Long id);
    List<IncomeStatementDeclaration> findByHandlingAccountantId(Long id);
    int deleteByHandlingAccountantId(Long id);
    List<IncomeStatementDeclaration> findByValidationAccountantId(Long id);
    int deleteByValidationAccountantId(Long id);

    @Query("SELECT NEW IncomeStatementDeclaration(item.id,item.reference) FROM IncomeStatementDeclaration item")
    List<IncomeStatementDeclaration> findAllOptimized();
}

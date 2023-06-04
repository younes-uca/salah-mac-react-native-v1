package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.IncomeStatementDeclaration;
import ma.sir.ecom.dao.criteria.core.IncomeStatementDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.IncomeStatementDeclarationHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.IncomeStatementDeclarationDto;
import org.springframework.http.HttpEntity;

public interface IncomeStatementDeclarationAdminService extends  IService<IncomeStatementDeclaration,IncomeStatementDeclarationCriteria, IncomeStatementDeclarationHistoryCriteria>  {

    List<IncomeStatementDeclaration> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<IncomeStatementDeclaration> findByCorporateTaxRateId(Long id);
    int deleteByCorporateTaxRateId(Long id);
    List<IncomeStatementDeclaration> findByHandlingAccountantId(Long id);
    int deleteByHandlingAccountantId(Long id);
    List<IncomeStatementDeclaration> findByValidationAccountantId(Long id);
    int deleteByValidationAccountantId(Long id);

    HttpEntity<byte[]> createPdf(IncomeStatementDeclarationDto dto) throws Exception;


}

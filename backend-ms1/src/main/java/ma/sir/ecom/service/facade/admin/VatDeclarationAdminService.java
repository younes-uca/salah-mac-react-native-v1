package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.VatDeclaration;
import ma.sir.ecom.dao.criteria.core.VatDeclarationCriteria;
import ma.sir.ecom.dao.criteria.history.VatDeclarationHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.VatDeclarationDto;
import org.springframework.http.HttpEntity;

public interface VatDeclarationAdminService extends  IService<VatDeclaration,VatDeclarationCriteria, VatDeclarationHistoryCriteria>  {

    List<VatDeclaration> findByCompanyId(Long id);
    int deleteByCompanyId(Long id);
    List<VatDeclaration> findByLatePaymentRateId(Long id);
    int deleteByLatePaymentRateId(Long id);
    List<VatDeclaration> findByHandlingAccountantId(Long id);
    int deleteByHandlingAccountantId(Long id);
    List<VatDeclaration> findByValidationAccountantId(Long id);
    int deleteByValidationAccountantId(Long id);

    HttpEntity<byte[]> createPdf(VatDeclarationDto dto) throws Exception;


}

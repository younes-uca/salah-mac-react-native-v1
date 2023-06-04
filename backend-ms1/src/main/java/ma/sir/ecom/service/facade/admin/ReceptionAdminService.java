package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Reception;
import ma.sir.ecom.dao.criteria.core.ReceptionCriteria;
import ma.sir.ecom.dao.criteria.history.ReceptionHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ReceptionDto;
import org.springframework.http.HttpEntity;

public interface ReceptionAdminService extends  IService<Reception,ReceptionCriteria, ReceptionHistoryCriteria>  {

    List<Reception> findByOrderId(Long id);
    int deleteByOrderId(Long id);
    List<Reception> findByReceptionStatusId(Long id);
    int deleteByReceptionStatusId(Long id);

    HttpEntity<byte[]> createPdf(ReceptionDto dto) throws Exception;


}

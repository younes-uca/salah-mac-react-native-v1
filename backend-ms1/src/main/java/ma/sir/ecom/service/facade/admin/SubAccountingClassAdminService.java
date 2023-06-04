package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.SubAccountingClass;
import ma.sir.ecom.dao.criteria.core.SubAccountingClassCriteria;
import ma.sir.ecom.dao.criteria.history.SubAccountingClassHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SubAccountingClassDto;
import org.springframework.http.HttpEntity;

public interface SubAccountingClassAdminService extends  IService<SubAccountingClass,SubAccountingClassCriteria, SubAccountingClassHistoryCriteria>  {

    List<SubAccountingClass> findByAccountingClassId(Long id);
    int deleteByAccountingClassId(Long id);

    HttpEntity<byte[]> createPdf(SubAccountingClassDto dto) throws Exception;


}

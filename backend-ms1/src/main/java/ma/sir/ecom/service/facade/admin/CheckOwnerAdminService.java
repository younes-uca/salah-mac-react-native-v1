package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.CheckOwner;
import ma.sir.ecom.dao.criteria.core.CheckOwnerCriteria;
import ma.sir.ecom.dao.criteria.history.CheckOwnerHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.CheckOwnerDto;
import org.springframework.http.HttpEntity;

public interface CheckOwnerAdminService extends  IService<CheckOwner,CheckOwnerCriteria, CheckOwnerHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(CheckOwnerDto dto) throws Exception;


}

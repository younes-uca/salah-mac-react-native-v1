package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Client;
import ma.sir.ecom.dao.criteria.core.ClientCriteria;
import ma.sir.ecom.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.ClientDto;
import org.springframework.http.HttpEntity;

public interface ClientAdminService extends  IService<Client,ClientCriteria, ClientHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception;


}

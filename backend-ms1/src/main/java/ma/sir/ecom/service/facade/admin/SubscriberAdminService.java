package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Subscriber;
import ma.sir.ecom.dao.criteria.core.SubscriberCriteria;
import ma.sir.ecom.dao.criteria.history.SubscriberHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.SubscriberDto;
import org.springframework.http.HttpEntity;

public interface SubscriberAdminService extends  IService<Subscriber,SubscriberCriteria, SubscriberHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(SubscriberDto dto) throws Exception;


}

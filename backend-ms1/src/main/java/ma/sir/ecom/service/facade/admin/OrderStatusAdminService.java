package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.OrderStatus;
import ma.sir.ecom.dao.criteria.core.OrderStatusCriteria;
import ma.sir.ecom.dao.criteria.history.OrderStatusHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.OrderStatusDto;
import org.springframework.http.HttpEntity;

public interface OrderStatusAdminService extends  IService<OrderStatus,OrderStatusCriteria, OrderStatusHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception;


}

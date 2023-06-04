package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.OrderStatusOrder;
import ma.sir.ecom.dao.criteria.core.OrderStatusOrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderStatusOrderHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.OrderStatusOrderDto;
import org.springframework.http.HttpEntity;

public interface OrderStatusOrderAdminService extends  IService<OrderStatusOrder,OrderStatusOrderCriteria, OrderStatusOrderHistoryCriteria>  {


    HttpEntity<byte[]> createPdf(OrderStatusOrderDto dto) throws Exception;


}

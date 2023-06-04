package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.Order;
import ma.sir.ecom.dao.criteria.core.OrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.OrderDto;
import org.springframework.http.HttpEntity;

public interface OrderAdminService extends  IService<Order,OrderCriteria, OrderHistoryCriteria>  {

    List<Order> findByClientId(Long id);
    int deleteByClientId(Long id);
    List<Order> findByOrderStatusId(Long id);
    int deleteByOrderStatusId(Long id);

    HttpEntity<byte[]> createPdf(OrderDto dto) throws Exception;


}

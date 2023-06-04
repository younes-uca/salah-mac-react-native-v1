package ma.sir.ecom.service.facade.admin;

import java.util.List;
import ma.sir.ecom.bean.core.OrderItem;
import ma.sir.ecom.dao.criteria.core.OrderItemCriteria;
import ma.sir.ecom.dao.criteria.history.OrderItemHistoryCriteria;
import ma.sir.ecom.zynerator.service.IService;

import ma.sir.ecom.ws.dto.OrderItemDto;
import org.springframework.http.HttpEntity;

public interface OrderItemAdminService extends  IService<OrderItem,OrderItemCriteria, OrderItemHistoryCriteria>  {

    List<OrderItem> findByProductId(Long id);
    int deleteByProductId(Long id);
    List<OrderItem> findByOrderId(Long id);
    int deleteByOrderId(Long id);

    HttpEntity<byte[]> createPdf(OrderItemDto dto) throws Exception;


}

package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.OrderItem;
import ma.sir.ecom.bean.history.OrderItemHistory;
import ma.sir.ecom.dao.criteria.core.OrderItemCriteria;
import ma.sir.ecom.dao.criteria.history.OrderItemHistoryCriteria;
import ma.sir.ecom.dao.facade.core.OrderItemDao;
import ma.sir.ecom.dao.facade.history.OrderItemHistoryDao;
import ma.sir.ecom.dao.specification.core.OrderItemSpecification;
import ma.sir.ecom.service.facade.admin.OrderItemAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.OrderItemDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;


import ma.sir.ecom.service.facade.admin.OrderAdminService ;
import ma.sir.ecom.service.facade.admin.ProductAdminService ;


import java.util.List;
@Service
public class OrderItemAdminServiceImpl extends AbstractServiceImpl<OrderItem,OrderItemHistory, OrderItemCriteria, OrderItemHistoryCriteria, OrderItemDao,
OrderItemHistoryDao> implements OrderItemAdminService {
    public static final String TEMPLATE = "template/orderItem.vm";
    public static final String FILE_NAME = "orderItem.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderItemDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }



    public List<OrderItem> findByProductId(Long id){
        return dao.findByProductId(id);
    }
    public int deleteByProductId(Long id){
        return dao.deleteByProductId(id);
    }
    public List<OrderItem> findByOrderId(Long id){
        return dao.findByOrderId(id);
    }
    public int deleteByOrderId(Long id){
        return dao.deleteByOrderId(id);
    }




    public void configure() {
        super.configure(OrderItem.class,OrderItemHistory.class, OrderItemHistoryCriteria.class, OrderItemSpecification.class);
    }

    @Autowired
    private OrderAdminService orderService ;
    @Autowired
    private ProductAdminService productService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public OrderItemAdminServiceImpl(OrderItemDao dao, OrderItemHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
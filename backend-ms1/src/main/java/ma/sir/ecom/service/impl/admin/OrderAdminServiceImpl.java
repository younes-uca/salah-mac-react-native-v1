package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Order;
import ma.sir.ecom.bean.history.OrderHistory;
import ma.sir.ecom.dao.criteria.core.OrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderHistoryCriteria;
import ma.sir.ecom.dao.facade.core.OrderDao;
import ma.sir.ecom.dao.facade.history.OrderHistoryDao;
import ma.sir.ecom.dao.specification.core.OrderSpecification;
import ma.sir.ecom.service.facade.admin.OrderAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.OrderDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ma.sir.ecom.bean.core.OrderItem;

import ma.sir.ecom.service.facade.admin.OrderItemAdminService ;
import ma.sir.ecom.service.facade.admin.ClientAdminService ;
import ma.sir.ecom.service.facade.admin.OrderStatusAdminService ;


import java.util.List;
@Service
public class OrderAdminServiceImpl extends AbstractServiceImpl<Order,OrderHistory, OrderCriteria, OrderHistoryCriteria, OrderDao,
OrderHistoryDao> implements OrderAdminService {
    public static final String TEMPLATE = "template/order.vm";
    public static final String FILE_NAME = "order.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class, readOnly = false)
    public Order create(Order t) {
        super.create(t);
        if (t.getOrderItems() != null) {
                t.getOrderItems().forEach(element-> {
                    element.setOrder(t);
                    orderItemService.create(element);
            });
        }
        return t;
    }

    public Order findWithAssociatedLists(Long id){
        Order result = dao.findById(id).orElse(null);
        if(result!=null && result.getId() != null) {
            result.setOrderItems(orderItemService.findByOrderId(id));
        }
        return result;
    }
    @Transactional
    public void deleteAssociatedLists(Long id) {
        orderItemService.deleteByOrderId(id);
    }


    public void updateWithAssociatedLists(Order order){
    if(order !=null && order.getId() != null){
            List<List<OrderItem>> resultOrderItems= orderItemService.getToBeSavedAndToBeDeleted(orderItemService.findByOrderId(order.getId()),order.getOrderItems());
            orderItemService.delete(resultOrderItems.get(1));
            ListUtil.emptyIfNull(resultOrderItems.get(0)).forEach(e -> e.setOrder(order));
            orderItemService.update(resultOrderItems.get(0),true);
    }
    }

    public Order findByReferenceEntity(Order t){
        return  dao.findByReference(t.getReference());
    }

    public List<Order> findByClientId(Long id){
        return dao.findByClientId(id);
    }
    public int deleteByClientId(Long id){
        return dao.deleteByClientId(id);
    }
    public List<Order> findByOrderStatusId(Long id){
        return dao.findByOrderStatusId(id);
    }
    public int deleteByOrderStatusId(Long id){
        return dao.deleteByOrderStatusId(id);
    }




    public void configure() {
        super.configure(Order.class,OrderHistory.class, OrderHistoryCriteria.class, OrderSpecification.class);
    }

    @Autowired
    private OrderItemAdminService orderItemService ;
    @Autowired
    private ClientAdminService clientService ;
    @Autowired
    private OrderStatusAdminService orderStatusService ;
    @Autowired
    private VelocityPdf velocityPdf;

    public OrderAdminServiceImpl(OrderDao dao, OrderHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
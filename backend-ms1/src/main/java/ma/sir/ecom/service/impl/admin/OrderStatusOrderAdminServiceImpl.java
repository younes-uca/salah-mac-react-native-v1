package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.OrderStatusOrder;
import ma.sir.ecom.bean.history.OrderStatusOrderHistory;
import ma.sir.ecom.dao.criteria.core.OrderStatusOrderCriteria;
import ma.sir.ecom.dao.criteria.history.OrderStatusOrderHistoryCriteria;
import ma.sir.ecom.dao.facade.core.OrderStatusOrderDao;
import ma.sir.ecom.dao.facade.history.OrderStatusOrderHistoryDao;
import ma.sir.ecom.dao.specification.core.OrderStatusOrderSpecification;
import ma.sir.ecom.service.facade.admin.OrderStatusOrderAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.OrderStatusOrderDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class OrderStatusOrderAdminServiceImpl extends AbstractServiceImpl<OrderStatusOrder,OrderStatusOrderHistory, OrderStatusOrderCriteria, OrderStatusOrderHistoryCriteria, OrderStatusOrderDao,
OrderStatusOrderHistoryDao> implements OrderStatusOrderAdminService {
    public static final String TEMPLATE = "template/orderStatusOrder.vm";
    public static final String FILE_NAME = "orderStatusOrder.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderStatusOrderDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public OrderStatusOrder findByReferenceEntity(OrderStatusOrder t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(OrderStatusOrder.class,OrderStatusOrderHistory.class, OrderStatusOrderHistoryCriteria.class, OrderStatusOrderSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public OrderStatusOrderAdminServiceImpl(OrderStatusOrderDao dao, OrderStatusOrderHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
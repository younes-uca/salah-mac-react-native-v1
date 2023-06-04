package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.OrderStatus;
import ma.sir.ecom.bean.history.OrderStatusHistory;
import ma.sir.ecom.dao.criteria.core.OrderStatusCriteria;
import ma.sir.ecom.dao.criteria.history.OrderStatusHistoryCriteria;
import ma.sir.ecom.dao.facade.core.OrderStatusDao;
import ma.sir.ecom.dao.facade.history.OrderStatusHistoryDao;
import ma.sir.ecom.dao.specification.core.OrderStatusSpecification;
import ma.sir.ecom.service.facade.admin.OrderStatusAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.OrderStatusDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class OrderStatusAdminServiceImpl extends AbstractServiceImpl<OrderStatus,OrderStatusHistory, OrderStatusCriteria, OrderStatusHistoryCriteria, OrderStatusDao,
OrderStatusHistoryDao> implements OrderStatusAdminService {
    public static final String TEMPLATE = "template/orderStatus.vm";
    public static final String FILE_NAME = "orderStatus.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(OrderStatusDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public OrderStatus findByReferenceEntity(OrderStatus t){
        return  dao.findByCode(t.getCode());
    }





    public void configure() {
        super.configure(OrderStatus.class,OrderStatusHistory.class, OrderStatusHistoryCriteria.class, OrderStatusSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public OrderStatusAdminServiceImpl(OrderStatusDao dao, OrderStatusHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
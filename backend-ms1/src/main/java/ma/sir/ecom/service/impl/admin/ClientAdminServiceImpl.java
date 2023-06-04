package ma.sir.ecom.service.impl.admin;

import ma.sir.ecom.bean.core.Client;
import ma.sir.ecom.bean.history.ClientHistory;
import ma.sir.ecom.dao.criteria.core.ClientCriteria;
import ma.sir.ecom.dao.criteria.history.ClientHistoryCriteria;
import ma.sir.ecom.dao.facade.core.ClientDao;
import ma.sir.ecom.dao.facade.history.ClientHistoryDao;
import ma.sir.ecom.dao.specification.core.ClientSpecification;
import ma.sir.ecom.service.facade.admin.ClientAdminService;
import ma.sir.ecom.zynerator.service.AbstractServiceImpl;
import ma.sir.ecom.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;

import ma.sir.ecom.zynerator.util.VelocityPdf;
import ma.sir.ecom.ws.dto.ClientDto;
import org.springframework.http.HttpEntity;

import org.springframework.beans.factory.annotation.Autowired;




import java.util.List;
@Service
public class ClientAdminServiceImpl extends AbstractServiceImpl<Client,ClientHistory, ClientCriteria, ClientHistoryCriteria, ClientDao,
ClientHistoryDao> implements ClientAdminService {
    public static final String TEMPLATE = "template/client.vm";
    public static final String FILE_NAME = "client.pdf";

    @Override
    public HttpEntity<byte[]> createPdf(ClientDto dto) throws Exception{
        return velocityPdf.createPdf(FILE_NAME, TEMPLATE, dto);
    }


    public Client findByReferenceEntity(Client t){
        return  dao.findByCin(t.getCin());
    }





    public void configure() {
        super.configure(Client.class,ClientHistory.class, ClientHistoryCriteria.class, ClientSpecification.class);
    }

    @Autowired
    private VelocityPdf velocityPdf;

    public ClientAdminServiceImpl(ClientDao dao, ClientHistoryDao historyDao) {
        super(dao, historyDao);
    }

}
package ma.sir.ecom.zynerator.service;

import ma.sir.ecom.zynerator.audit.AuditBusinessObjectEnhanced;
import ma.sir.ecom.zynerator.criteria.BaseCriteria;
import ma.sir.ecom.zynerator.history.HistBusinessObject;
import ma.sir.ecom.zynerator.history.HistCriteria;
import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.zynerator.repository.AbstractRepository;

public abstract class AbstractReferentielServiceImpl<T extends AuditBusinessObjectEnhanced, H extends HistBusinessObject, CRITERIA extends BaseCriteria, HC extends HistCriteria, REPO extends AbstractRepository<T, Long>, HISTREPO extends AbstractHistoryRepository<H, Long>> extends AbstractServiceImpl<T, H, CRITERIA, HC, REPO, HISTREPO> {

    public AbstractReferentielServiceImpl(REPO dao, HISTREPO historyRepository) {
    super(dao, historyRepository);
    }

}
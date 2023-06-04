package  ma.sir.ecom.dao.specification.core;

import ma.sir.ecom.zynerator.specification.AbstractSpecification;
import ma.sir.ecom.dao.criteria.core.SubscriberCriteria;
import ma.sir.ecom.bean.core.Subscriber;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class SubscriberSpecification extends  AbstractSpecification<SubscriberCriteria, Subscriber>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("code", criteria.getCode(),criteria.getCodeLike());
        addPredicate("address", criteria.getAddress(),criteria.getAddressLike());
        addPredicateBool("blocked", criteria.getBlocked());
        addPredicate("creationDate", criteria.getCreationDate(), criteria.getCreationDateFrom(), criteria.getCreationDateTo());
        addPredicate("email", criteria.getEmail(),criteria.getEmailLike());
        addPredicate("phone", criteria.getPhone(),criteria.getPhoneLike());
        addPredicate("logo", criteria.getLogo(),criteria.getLogoLike());
        addPredicate("firstName", criteria.getFirstName(),criteria.getFirstNameLike());
        addPredicate("lastName", criteria.getLastName(),criteria.getLastNameLike());
        addPredicate("companyName", criteria.getCompanyName(),criteria.getCompanyNameLike());
        addPredicate("backupPath", criteria.getBackupPath(),criteria.getBackupPathLike());
        addPredicate("patent", criteria.getPatent(),criteria.getPatentLike());
        addPredicate("rc", criteria.getRc(),criteria.getRcLike());
        addPredicate("cnss", criteria.getCnss(),criteria.getCnssLike());
        addPredicate("ifisc", criteria.getIfisc(),criteria.getIfiscLike());
        addPredicate("ice", criteria.getIce(),criteria.getIceLike());
    }

    public SubscriberSpecification(SubscriberCriteria criteria) {
        super(criteria);
    }

    public SubscriberSpecification(SubscriberCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}

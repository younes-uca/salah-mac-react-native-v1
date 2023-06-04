import {CompanyCriteria} from './CompanyCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SubscriberCriteria  extends   BaseCriteria  {

    public id: number;
    public code: string;
    public codeLike: string;
    public address: string;
    public addressLike: string;
    public blocked: null | boolean;
    public creationDate: Date;
    public creationDateFrom: Date;
    public creationDateTo: Date;
    public email: string;
    public emailLike: string;
    public phone: string;
    public phoneLike: string;
    public logo: string;
    public logoLike: string;
    public firstName: string;
    public firstNameLike: string;
    public lastName: string;
    public lastNameLike: string;
    public companyName: string;
    public companyNameLike: string;
    public backupPath: string;
    public backupPathLike: string;
    public patent: string;
    public patentLike: string;
    public rc: string;
    public rcLike: string;
    public cnss: string;
    public cnssLike: string;
    public ifisc: string;
    public ifiscLike: string;
    public ice: string;
    public iceLike: string;
      public companys: Array<CompanyCriteria>;

}

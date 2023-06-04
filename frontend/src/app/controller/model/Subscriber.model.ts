import {CompanyDto} from './Company.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SubscriberDto  extends BaseDto{

    public id: number;
    public code: string;
    public address: string;
   public blocked: null | boolean;
   public creationDate: Date;
    public email: string;
    public phone: string;
    public logo: string;
    public firstName: string;
    public lastName: string;
    public companyName: string;
    public backupPath: string;
    public patent: string;
    public rc: string;
    public cnss: string;
    public ifisc: string;
    public ice: string;
    public creationDateMax: string ;
    public creationDateMin: string ;
     public companys: Array<CompanyDto>;

}

import {AccountingOperationTypeDto} from './AccountingOperationType.model';
import {CompanyDto} from './Company.model';
import {AccountingOperationStatusDto} from './AccountingOperationStatus.model';
import {AccountingAccountDto} from './AccountingAccount.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class AccountingOperationDto  extends BaseDto{

    public id: number;
    public libelle: string;
   public year: number;
   public month: number;
   public accountingOperationDate: Date;
    public amount: number;
    public yearMax: string ;
    public yearMin: string ;
    public monthMax: string ;
    public monthMin: string ;
    public accountingOperationDateMax: string ;
    public accountingOperationDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public company: CompanyDto ;
    public accountingAccount: AccountingAccountDto ;
    public accountingOperationType: AccountingOperationTypeDto ;
    public accountingOperationStatus: AccountingOperationStatusDto ;

}

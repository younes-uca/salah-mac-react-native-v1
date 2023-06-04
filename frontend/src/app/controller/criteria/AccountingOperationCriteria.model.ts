import {AccountingOperationTypeCriteria} from './AccountingOperationTypeCriteria.model';
import {CompanyCriteria} from './CompanyCriteria.model';
import {AccountingOperationStatusCriteria} from './AccountingOperationStatusCriteria.model';
import {AccountingAccountCriteria} from './AccountingAccountCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class AccountingOperationCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
     public year: number;
     public yearMin: number;
     public yearMax: number;
     public month: number;
     public monthMin: number;
     public monthMax: number;
    public accountingOperationDate: Date;
    public accountingOperationDateFrom: Date;
    public accountingOperationDateTo: Date;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
  public company: CompanyCriteria ;
  public companys: Array<CompanyCriteria> ;
  public accountingAccount: AccountingAccountCriteria ;
  public accountingAccounts: Array<AccountingAccountCriteria> ;
  public accountingOperationType: AccountingOperationTypeCriteria ;
  public accountingOperationTypes: Array<AccountingOperationTypeCriteria> ;
  public accountingOperationStatus: AccountingOperationStatusCriteria ;
  public accountingOperationStatuss: Array<AccountingOperationStatusCriteria> ;

}

import {AccountingClassCriteria} from './AccountingClassCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SubAccountingClassCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
  public accountingClass: AccountingClassCriteria ;
  public accountingClasss: Array<AccountingClassCriteria> ;

}

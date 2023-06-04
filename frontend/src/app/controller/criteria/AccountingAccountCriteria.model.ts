import {SubAccountingClassCriteria} from './SubAccountingClassCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class AccountingAccountCriteria  extends   BaseCriteria  {

    public id: number;
    public libelle: string;
    public libelleLike: string;
    public code: string;
    public codeLike: string;
  public subAccountingClass: SubAccountingClassCriteria ;
  public subAccountingClasss: Array<SubAccountingClassCriteria> ;

}

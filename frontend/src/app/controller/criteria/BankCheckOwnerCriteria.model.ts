import {BankCriteria} from './BankCriteria.model';
import {CheckOwnerCriteria} from './CheckOwnerCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class BankCheckOwnerCriteria  extends   BaseCriteria  {

    public id: number;
  public checkOwner: CheckOwnerCriteria ;
  public checkOwners: Array<CheckOwnerCriteria> ;
  public bank: BankCriteria ;
  public banks: Array<BankCriteria> ;

}

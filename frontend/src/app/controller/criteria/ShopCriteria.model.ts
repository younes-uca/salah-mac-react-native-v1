import {StoreCriteria} from './StoreCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ShopCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public address: string;
    public addressLike: string;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;

}

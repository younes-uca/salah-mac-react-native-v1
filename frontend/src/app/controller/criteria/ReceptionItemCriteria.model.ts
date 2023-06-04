import {ProductCriteria} from './ProductCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {ReceptionCriteria} from './ReceptionCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ReceptionItemCriteria  extends   BaseCriteria  {

    public id: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public reception: ReceptionCriteria ;
  public receptions: Array<ReceptionCriteria> ;

}

import {ProductCriteria} from './ProductCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {DeliveryCriteria} from './DeliveryCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DeliveryItemCriteria  extends   BaseCriteria  {

    public id: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;
  public delivery: DeliveryCriteria ;
  public deliverys: Array<DeliveryCriteria> ;

}

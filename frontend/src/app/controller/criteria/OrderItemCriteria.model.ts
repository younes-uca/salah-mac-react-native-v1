import {OrderCriteria} from './OrderCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class OrderItemCriteria  extends   BaseCriteria  {

    public id: number;
     public price: number;
     public priceMin: number;
     public priceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public quantityReceived: number;
     public quantityReceivedMin: number;
     public quantityReceivedMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public order: OrderCriteria ;
  public orders: Array<OrderCriteria> ;

}

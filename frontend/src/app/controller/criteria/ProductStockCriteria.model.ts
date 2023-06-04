import {ShopCriteria} from './ShopCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ProductStockCriteria  extends   BaseCriteria  {

    public id: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public defectiveQuantity: number;
     public defectiveQuantityMin: number;
     public defectiveQuantityMax: number;
  public shop: ShopCriteria ;
  public shops: Array<ShopCriteria> ;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;

}

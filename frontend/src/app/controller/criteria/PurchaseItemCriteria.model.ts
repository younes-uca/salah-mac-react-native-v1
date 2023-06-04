import {PurchaseCriteria} from './PurchaseCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class PurchaseItemCriteria  extends   BaseCriteria  {

    public id: number;
     public unitPrice: number;
     public unitPriceMin: number;
     public unitPriceMax: number;
     public sellingPrice: number;
     public sellingPriceMin: number;
     public sellingPriceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public returnQuantity: number;
     public returnQuantityMin: number;
     public returnQuantityMax: number;
     public discount: number;
     public discountMin: number;
     public discountMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public purchase: PurchaseCriteria ;
  public purchases: Array<PurchaseCriteria> ;

}

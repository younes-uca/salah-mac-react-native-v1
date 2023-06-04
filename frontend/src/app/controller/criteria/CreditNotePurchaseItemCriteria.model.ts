import {ProductCriteria} from './ProductCriteria.model';
import {CreditNotePurchaseCriteria} from './CreditNotePurchaseCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class CreditNotePurchaseItemCriteria  extends   BaseCriteria  {

    public id: number;
     public amount: number;
     public amountMin: number;
     public amountMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public creditNotePurchase: CreditNotePurchaseCriteria ;
  public creditNotePurchases: Array<CreditNotePurchaseCriteria> ;

}

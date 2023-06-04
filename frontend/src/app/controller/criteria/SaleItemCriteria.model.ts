import {SaleCriteria} from './SaleCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SaleItemCriteria  extends   BaseCriteria  {

    public id: number;
     public unitPrice: number;
     public unitPriceMin: number;
     public unitPriceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public discount: number;
     public discountMin: number;
     public discountMax: number;
     public quantityReturned: number;
     public quantityReturnedMin: number;
     public quantityReturnedMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public sale: SaleCriteria ;
  public sales: Array<SaleCriteria> ;

}

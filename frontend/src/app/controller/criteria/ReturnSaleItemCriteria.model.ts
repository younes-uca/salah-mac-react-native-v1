import {ReturnSaleCriteria} from './ReturnSaleCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ReturnSaleItemCriteria  extends   BaseCriteria  {

    public id: number;
     public returnAmount: number;
     public returnAmountMin: number;
     public returnAmountMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public returnSale: ReturnSaleCriteria ;
  public returnSales: Array<ReturnSaleCriteria> ;

}

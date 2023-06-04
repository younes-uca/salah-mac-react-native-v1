import {DemandCriteria} from './DemandCriteria.model';
import {ProductCriteria} from './ProductCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class DemandItemCriteria  extends   BaseCriteria  {

    public id: number;
     public price: number;
     public priceMin: number;
     public priceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public poundQuantity: number;
     public poundQuantityMin: number;
     public poundQuantityMax: number;
  public product: ProductCriteria ;
  public products: Array<ProductCriteria> ;
  public demand: DemandCriteria ;
  public demands: Array<DemandCriteria> ;

}

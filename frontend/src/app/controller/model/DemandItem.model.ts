import {DemandDto} from './Demand.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DemandItemDto  extends BaseDto{

    public id: number;
    public price: number;
    public quantity: number;
    public poundQuantity: number;
    public priceMax: string ;
    public priceMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public poundQuantityMax: string ;
    public poundQuantityMin: string ;
    public product: ProductDto ;
    public demand: DemandDto ;

}

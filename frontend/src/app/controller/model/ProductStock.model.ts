import {ShopDto} from './Shop.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ProductStockDto  extends BaseDto{

    public id: number;
    public quantity: number;
    public defectiveQuantity: number;
    public quantityMax: string ;
    public quantityMin: string ;
    public defectiveQuantityMax: string ;
    public defectiveQuantityMin: string ;
    public shop: ShopDto ;
    public product: ProductDto ;

}

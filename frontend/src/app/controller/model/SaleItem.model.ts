import {SaleDto} from './Sale.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SaleItemDto  extends BaseDto{

    public id: number;
    public unitPrice: number;
    public quantity: number;
    public discount: number;
    public quantityReturned: number;
    public unitPriceMax: string ;
    public unitPriceMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public discountMax: string ;
    public discountMin: string ;
    public quantityReturnedMax: string ;
    public quantityReturnedMin: string ;
    public product: ProductDto ;
    public sale: SaleDto ;

}

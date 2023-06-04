import {PurchaseDto} from './Purchase.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class PurchaseItemDto  extends BaseDto{

    public id: number;
    public unitPrice: number;
    public sellingPrice: number;
    public quantity: number;
    public returnQuantity: number;
    public discount: number;
    public unitPriceMax: string ;
    public unitPriceMin: string ;
    public sellingPriceMax: string ;
    public sellingPriceMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public returnQuantityMax: string ;
    public returnQuantityMin: string ;
    public discountMax: string ;
    public discountMin: string ;
    public product: ProductDto ;
    public purchase: PurchaseDto ;

}

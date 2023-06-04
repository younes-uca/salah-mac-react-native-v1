import {ReturnSaleDto} from './ReturnSale.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ReturnSaleItemDto  extends BaseDto{

    public id: number;
    public returnAmount: number;
    public quantity: number;
    public returnAmountMax: string ;
    public returnAmountMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public product: ProductDto ;
    public returnSale: ReturnSaleDto ;

}

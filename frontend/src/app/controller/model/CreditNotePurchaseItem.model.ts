import {ProductDto} from './Product.model';
import {CreditNotePurchaseDto} from './CreditNotePurchase.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CreditNotePurchaseItemDto  extends BaseDto{

    public id: number;
    public amount: number;
    public quantity: number;
    public amountMax: string ;
    public amountMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public product: ProductDto ;
    public creditNotePurchase: CreditNotePurchaseDto ;

}

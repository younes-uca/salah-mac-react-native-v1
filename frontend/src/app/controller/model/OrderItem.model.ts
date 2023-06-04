import {OrderDto} from './Order.model';
import {ProductDto} from './Product.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class OrderItemDto  extends BaseDto{

    public id: number;
    public price: number;
    public quantity: number;
    public quantityReceived: number;
    public priceMax: string ;
    public priceMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public quantityReceivedMax: string ;
    public quantityReceivedMin: string ;
    public product: ProductDto ;
    public order: OrderDto ;

}

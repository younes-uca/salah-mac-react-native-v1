import {ProductDto} from './Product.model';
import {StoreDto} from './Store.model';
import {DeliveryDto} from './Delivery.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class DeliveryItemDto  extends BaseDto{

    public id: number;
    public quantity: number;
    public quantityMax: string ;
    public quantityMin: string ;
    public product: ProductDto ;
    public store: StoreDto ;
    public delivery: DeliveryDto ;

}

import {StoreDto} from './Store.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ShopDto  extends BaseDto{

    public id: number;
    public reference: string;
    public address: string;
    public store: StoreDto ;

}

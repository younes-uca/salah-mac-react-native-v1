import {SaleDto} from './Sale.model';
import {ReturnSaleItemDto} from './ReturnSaleItem.model';
import {ReturnStatusDto} from './ReturnStatus.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ReturnSaleDto  extends BaseDto{

    public id: number;
   public returnDate: Date;
    public amount: number;
    public returnDateMax: string ;
    public returnDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public sale: SaleDto ;
    public returnStatus: ReturnStatusDto ;
     public returnSaleItems: Array<ReturnSaleItemDto>;

}

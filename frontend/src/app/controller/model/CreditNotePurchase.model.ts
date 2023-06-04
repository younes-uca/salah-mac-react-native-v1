import {PurchaseDto} from './Purchase.model';
import {CreditNotePurchaseStatusDto} from './CreditNotePurchaseStatus.model';
import {CreditNotePurchaseItemDto} from './CreditNotePurchaseItem.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class CreditNotePurchaseDto  extends BaseDto{

    public id: number;
   public creditNoteDate: Date;
    public amount: number;
    public creditNoteDateMax: string ;
    public creditNoteDateMin: string ;
    public amountMax: string ;
    public amountMin: string ;
    public purchase: PurchaseDto ;
    public creditNotePurchaseStatus: CreditNotePurchaseStatusDto ;
     public creditNotePurchaseItems: Array<CreditNotePurchaseItemDto>;

}

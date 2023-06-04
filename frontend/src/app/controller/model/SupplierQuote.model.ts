import {SupplierDto} from './Supplier.model';
import {SupplierQuoteItemDto} from './SupplierQuoteItem.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class SupplierQuoteDto  extends BaseDto{

    public id: number;
    public reference: string;
   public quoteDate: Date;
    public total: number;
    public description: string;
    public quoteDateMax: string ;
    public quoteDateMin: string ;
    public totalMax: string ;
    public totalMin: string ;
    public supplier: SupplierDto ;
     public supplierQuoteItems: Array<SupplierQuoteItemDto>;

}

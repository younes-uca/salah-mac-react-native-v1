import {SupplierCriteria} from './SupplierCriteria.model';
import {SupplierQuoteItemCriteria} from './SupplierQuoteItemCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class SupplierQuoteCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public quoteDate: Date;
    public quoteDateFrom: Date;
    public quoteDateTo: Date;
     public total: number;
     public totalMin: number;
     public totalMax: number;
    public description: string;
    public descriptionLike: string;
  public supplier: SupplierCriteria ;
  public suppliers: Array<SupplierCriteria> ;
      public supplierQuoteItems: Array<SupplierQuoteItemCriteria>;

}

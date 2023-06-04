import {BrandCriteria} from './BrandCriteria.model';
import {StoreCriteria} from './StoreCriteria.model';
import {ProductCategoryCriteria} from './ProductCategoryCriteria.model';
import {MeasurementUnitCriteria} from './MeasurementUnitCriteria.model';
import {BaseCriteria} from 'src/app/zynerator/criteria/BaseCriteria.model';


export class ProductCriteria  extends   BaseCriteria  {

    public id: number;
    public reference: string;
    public referenceLike: string;
    public libelle: string;
    public libelleLike: string;
    public barcode: string;
    public barcodeLike: string;
    public description: string;
    public descriptionLike: string;
     public averagePurchasePrice: number;
     public averagePurchasePriceMin: number;
     public averagePurchasePriceMax: number;
     public quantity: number;
     public quantityMin: number;
     public quantityMax: number;
     public alertThreshold: number;
     public alertThresholdMin: number;
     public alertThresholdMax: number;
    public productPhotos: string;
    public productPhotosLike: string;
  public productCategory: ProductCategoryCriteria ;
  public productCategorys: Array<ProductCategoryCriteria> ;
  public measurementUnit: MeasurementUnitCriteria ;
  public measurementUnits: Array<MeasurementUnitCriteria> ;
  public brand: BrandCriteria ;
  public brands: Array<BrandCriteria> ;
  public store: StoreCriteria ;
  public stores: Array<StoreCriteria> ;

}

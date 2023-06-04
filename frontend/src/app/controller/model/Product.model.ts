import {BrandDto} from './Brand.model';
import {StoreDto} from './Store.model';
import {ProductCategoryDto} from './ProductCategory.model';
import {MeasurementUnitDto} from './MeasurementUnit.model';
import {BaseDto} from 'src/app/zynerator/dto/BaseDto.model';


export class ProductDto  extends BaseDto{

    public id: number;
    public reference: string;
    public libelle: string;
    public barcode: string;
    public description: string;
    public averagePurchasePrice: number;
    public quantity: number;
    public alertThreshold: number;
    public productPhotos: string;
    public averagePurchasePriceMax: string ;
    public averagePurchasePriceMin: string ;
    public quantityMax: string ;
    public quantityMin: string ;
    public alertThresholdMax: string ;
    public alertThresholdMin: string ;
    public productCategory: ProductCategoryDto ;
    public measurementUnit: MeasurementUnitDto ;
    public brand: BrandDto ;
    public store: StoreDto ;

}

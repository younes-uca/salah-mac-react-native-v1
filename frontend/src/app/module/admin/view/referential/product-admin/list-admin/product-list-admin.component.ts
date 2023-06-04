import {Component, OnInit} from '@angular/core';
import {ProductService} from 'src/app/controller/service/Product.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/ProductCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ProductCategoryService } from 'src/app/controller/service/ProductCategory.service';
import { MeasurementUnitService } from 'src/app/controller/service/MeasurementUnit.service';
import { BrandService } from 'src/app/controller/service/Brand.service';
import { StoreService } from 'src/app/controller/service/Store.service';

import {BrandDto} from 'src/app/controller/model/Brand.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';


@Component({
  selector: 'app-product-list-admin',
  templateUrl: './product-list-admin.component.html'
})
export class ProductListAdminComponent extends AbstractListController<ProductDto, ProductCriteria, ProductService>  implements OnInit {

    fileName = 'Product';

    productCategorys :Array<ProductCategoryDto>;
    measurementUnits :Array<MeasurementUnitDto>;
    brands :Array<BrandDto>;
    stores :Array<StoreDto>;
  
    constructor(productService: ProductService, private productCategoryService: ProductCategoryService, private measurementUnitService: MeasurementUnitService, private brandService: BrandService, private storeService: StoreService) {
        super(productService);
        this.pdfName='Product.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadProductCategory();
      this.loadMeasurementUnit();
      this.loadBrand();
      this.loadStore();
    }

    public async loadProducts(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.service.findAll().subscribe(products => this.items = products,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'libelle', header: 'Libelle'},
            {field: 'productCategory?.libelle', header: 'Product category'},
            {field: 'barcode', header: 'Barcode'},
            {field: 'description', header: 'Description'},
            {field: 'averagePurchasePrice', header: 'Average purchase price'},
            {field: 'quantity', header: 'Quantity'},
            {field: 'alertThreshold', header: 'Alert threshold'},
            {field: 'measurementUnit?.libelle', header: 'Measurement unit'},
            {field: 'brand?.libelle', header: 'Brand'},
            {field: 'store?.libelle', header: 'Store'},
            {field: 'productPhotos', header: 'Product photos'},
        ];
    }


    public async loadProductCategory(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.productCategoryService.findAllOptimized().subscribe(productCategorys => this.productCategorys = productCategorys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadMeasurementUnit(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.measurementUnitService.findAllOptimized().subscribe(measurementUnits => this.measurementUnits = measurementUnits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadBrand(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.brandService.findAllOptimized().subscribe(brands => this.brands = brands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Product', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ProductDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Libelle': e.libelle ,
                'Product category': e.productCategory?.libelle ,
                 'Barcode': e.barcode ,
                 'Description': e.description ,
                 'Average purchase price': e.averagePurchasePrice ,
                 'Quantity': e.quantity ,
                 'Alert threshold': e.alertThreshold ,
                'Measurement unit': e.measurementUnit?.libelle ,
                'Brand': e.brand?.libelle ,
                'Store': e.store?.libelle ,
                 'Product photos': e.productPhotos ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        //'Product category': this.criteria.productCategory?.libelle ? this.criteria.productCategory?.libelle : environment.emptyForExport ,
            'Barcode': this.criteria.barcode ? this.criteria.barcode : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Average purchase price Min': this.criteria.averagePurchasePriceMin ? this.criteria.averagePurchasePriceMin : environment.emptyForExport ,
            'Average purchase price Max': this.criteria.averagePurchasePriceMax ? this.criteria.averagePurchasePriceMax : environment.emptyForExport ,
            'Quantity Min': this.criteria.quantityMin ? this.criteria.quantityMin : environment.emptyForExport ,
            'Quantity Max': this.criteria.quantityMax ? this.criteria.quantityMax : environment.emptyForExport ,
            'Alert threshold Min': this.criteria.alertThresholdMin ? this.criteria.alertThresholdMin : environment.emptyForExport ,
            'Alert threshold Max': this.criteria.alertThresholdMax ? this.criteria.alertThresholdMax : environment.emptyForExport ,
        //'Measurement unit': this.criteria.measurementUnit?.libelle ? this.criteria.measurementUnit?.libelle : environment.emptyForExport ,
        //'Brand': this.criteria.brand?.libelle ? this.criteria.brand?.libelle : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
            'Product photos': this.criteria.productPhotos ? this.criteria.productPhotos : environment.emptyForExport ,
        }];
      }
}

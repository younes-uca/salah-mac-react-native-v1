import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ProductService} from 'src/app/controller/service/Product.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductCriteria} from 'src/app/controller/criteria/ProductCriteria.model';

import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {ProductCategoryService} from 'src/app/controller/service/ProductCategory.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {BrandDto} from 'src/app/controller/model/Brand.model';
import {BrandService} from 'src/app/controller/service/Brand.service';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';
import {MeasurementUnitService} from 'src/app/controller/service/MeasurementUnit.service';
@Component({
  selector: 'app-product-view-admin',
  templateUrl: './product-view-admin.component.html'
})
export class ProductViewAdminComponent extends AbstractViewController<ProductDto, ProductCriteria, ProductService> implements OnInit {


    constructor(private productService: ProductService, private productCategoryService: ProductCategoryService, private storeService: StoreService, private brandService: BrandService, private measurementUnitService: MeasurementUnitService){
        super(productService);
    }

    ngOnInit(): void {
        this.productCategory = new ProductCategoryDto();
        this.productCategoryService.findAll().subscribe((data) => this.productCategorys = data);
        this.measurementUnit = new MeasurementUnitDto();
        this.measurementUnitService.findAll().subscribe((data) => this.measurementUnits = data);
        this.brand = new BrandDto();
        this.brandService.findAll().subscribe((data) => this.brands = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
    }


    get measurementUnit(): MeasurementUnitDto {
       return this.measurementUnitService.item;
    }
    set measurementUnit(value: MeasurementUnitDto) {
        this.measurementUnitService.item = value;
    }
    get measurementUnits():Array<MeasurementUnitDto> {
       return this.measurementUnitService.items;
    }
    set measurementUnits(value: Array<MeasurementUnitDto>) {
        this.measurementUnitService.items = value;
    }
    get productCategory(): ProductCategoryDto {
       return this.productCategoryService.item;
    }
    set productCategory(value: ProductCategoryDto) {
        this.productCategoryService.item = value;
    }
    get productCategorys():Array<ProductCategoryDto> {
       return this.productCategoryService.items;
    }
    set productCategorys(value: Array<ProductCategoryDto>) {
        this.productCategoryService.items = value;
    }
    get brand(): BrandDto {
       return this.brandService.item;
    }
    set brand(value: BrandDto) {
        this.brandService.item = value;
    }
    get brands():Array<BrandDto> {
       return this.brandService.items;
    }
    set brands(value: Array<BrandDto>) {
        this.brandService.items = value;
    }
    get store(): StoreDto {
       return this.storeService.item;
    }
    set store(value: StoreDto) {
        this.storeService.item = value;
    }
    get stores():Array<StoreDto> {
       return this.storeService.items;
    }
    set stores(value: Array<StoreDto>) {
        this.storeService.items = value;
    }


}

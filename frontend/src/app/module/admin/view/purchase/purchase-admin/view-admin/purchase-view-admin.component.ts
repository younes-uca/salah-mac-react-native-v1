import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/PurchaseCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {PurchaseItemDto} from 'src/app/controller/model/PurchaseItem.model';
import {PurchaseItemService} from 'src/app/controller/service/PurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';
@Component({
  selector: 'app-purchase-view-admin',
  templateUrl: './purchase-view-admin.component.html'
})
export class PurchaseViewAdminComponent extends AbstractViewController<PurchaseDto, PurchaseCriteria, PurchaseService> implements OnInit {

    purchaseItems = new PurchaseItemDto();
    purchaseItemss: Array<PurchaseItemDto> = [];

    constructor(private purchaseService: PurchaseService, private storeService: StoreService, private supplierService: SupplierService, private purchaseItemService: PurchaseItemService, private productService: ProductService, private purchaseStatusService: PurchaseStatusService){
        super(purchaseService);
    }

    ngOnInit(): void {
        this.purchaseItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.supplier = new SupplierDto();
        this.supplierService.findAll().subscribe((data) => this.suppliers = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.purchaseStatus = new PurchaseStatusDto();
        this.purchaseStatusService.findAll().subscribe((data) => this.purchaseStatuss = data);
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products():Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get supplier(): SupplierDto {
       return this.supplierService.item;
    }
    set supplier(value: SupplierDto) {
        this.supplierService.item = value;
    }
    get suppliers():Array<SupplierDto> {
       return this.supplierService.items;
    }
    set suppliers(value: Array<SupplierDto>) {
        this.supplierService.items = value;
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
    get purchaseStatus(): PurchaseStatusDto {
       return this.purchaseStatusService.item;
    }
    set purchaseStatus(value: PurchaseStatusDto) {
        this.purchaseStatusService.item = value;
    }
    get purchaseStatuss():Array<PurchaseStatusDto> {
       return this.purchaseStatusService.items;
    }
    set purchaseStatuss(value: Array<PurchaseStatusDto>) {
        this.purchaseStatusService.items = value;
    }


}

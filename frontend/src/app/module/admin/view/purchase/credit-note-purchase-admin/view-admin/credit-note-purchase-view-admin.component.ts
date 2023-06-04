import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CreditNotePurchaseService} from 'src/app/controller/service/CreditNotePurchase.service';
import {CreditNotePurchaseDto} from 'src/app/controller/model/CreditNotePurchase.model';
import {CreditNotePurchaseCriteria} from 'src/app/controller/criteria/CreditNotePurchaseCriteria.model';

import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusService} from 'src/app/controller/service/CreditNotePurchaseStatus.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {CreditNotePurchaseItemDto} from 'src/app/controller/model/CreditNotePurchaseItem.model';
import {CreditNotePurchaseItemService} from 'src/app/controller/service/CreditNotePurchaseItem.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-credit-note-purchase-view-admin',
  templateUrl: './credit-note-purchase-view-admin.component.html'
})
export class CreditNotePurchaseViewAdminComponent extends AbstractViewController<CreditNotePurchaseDto, CreditNotePurchaseCriteria, CreditNotePurchaseService> implements OnInit {

    creditNotePurchaseItems = new CreditNotePurchaseItemDto();
    creditNotePurchaseItemss: Array<CreditNotePurchaseItemDto> = [];

    constructor(private creditNotePurchaseService: CreditNotePurchaseService, private creditNotePurchaseStatusService: CreditNotePurchaseStatusService, private purchaseService: PurchaseService, private creditNotePurchaseItemService: CreditNotePurchaseItemService, private productService: ProductService){
        super(creditNotePurchaseService);
    }

    ngOnInit(): void {
        this.creditNotePurchaseItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.purchase = new PurchaseDto();
        this.purchaseService.findAll().subscribe((data) => this.purchases = data);
        this.creditNotePurchaseStatus = new CreditNotePurchaseStatusDto();
        this.creditNotePurchaseStatusService.findAll().subscribe((data) => this.creditNotePurchaseStatuss = data);
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
    get creditNotePurchaseStatus(): CreditNotePurchaseStatusDto {
       return this.creditNotePurchaseStatusService.item;
    }
    set creditNotePurchaseStatus(value: CreditNotePurchaseStatusDto) {
        this.creditNotePurchaseStatusService.item = value;
    }
    get creditNotePurchaseStatuss():Array<CreditNotePurchaseStatusDto> {
       return this.creditNotePurchaseStatusService.items;
    }
    set creditNotePurchaseStatuss(value: Array<CreditNotePurchaseStatusDto>) {
        this.creditNotePurchaseStatusService.items = value;
    }
    get purchase(): PurchaseDto {
       return this.purchaseService.item;
    }
    set purchase(value: PurchaseDto) {
        this.purchaseService.item = value;
    }
    get purchases():Array<PurchaseDto> {
       return this.purchaseService.items;
    }
    set purchases(value: Array<PurchaseDto>) {
        this.purchaseService.items = value;
    }


}

import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReceptionService} from 'src/app/controller/service/Reception.service';
import {ReceptionDto} from 'src/app/controller/model/Reception.model';
import {ReceptionCriteria} from 'src/app/controller/criteria/ReceptionCriteria.model';

import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderService} from 'src/app/controller/service/Order.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {ReceptionItemDto} from 'src/app/controller/model/ReceptionItem.model';
import {ReceptionItemService} from 'src/app/controller/service/ReceptionItem.service';
@Component({
  selector: 'app-reception-view-admin',
  templateUrl: './reception-view-admin.component.html'
})
export class ReceptionViewAdminComponent extends AbstractViewController<ReceptionDto, ReceptionCriteria, ReceptionService> implements OnInit {

    receptionItems = new ReceptionItemDto();
    receptionItemss: Array<ReceptionItemDto> = [];

    constructor(private receptionService: ReceptionService, private receptionStatusService: ReceptionStatusService, private storeService: StoreService, private orderService: OrderService, private productService: ProductService, private receptionItemService: ReceptionItemService){
        super(receptionService);
    }

    ngOnInit(): void {
        this.receptionItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.receptionItems.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.order = new OrderDto();
        this.orderService.findAll().subscribe((data) => this.orders = data);
        this.receptionStatus = new ReceptionStatusDto();
        this.receptionStatusService.findAll().subscribe((data) => this.receptionStatuss = data);
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
    get receptionStatus(): ReceptionStatusDto {
       return this.receptionStatusService.item;
    }
    set receptionStatus(value: ReceptionStatusDto) {
        this.receptionStatusService.item = value;
    }
    get receptionStatuss():Array<ReceptionStatusDto> {
       return this.receptionStatusService.items;
    }
    set receptionStatuss(value: Array<ReceptionStatusDto>) {
        this.receptionStatusService.items = value;
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
    get order(): OrderDto {
       return this.orderService.item;
    }
    set order(value: OrderDto) {
        this.orderService.item = value;
    }
    get orders():Array<OrderDto> {
       return this.orderService.items;
    }
    set orders(value: Array<OrderDto>) {
        this.orderService.items = value;
    }


}

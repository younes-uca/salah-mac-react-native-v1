import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DeliveryService} from 'src/app/controller/service/Delivery.service';
import {DeliveryDto} from 'src/app/controller/model/Delivery.model';
import {DeliveryCriteria} from 'src/app/controller/criteria/DeliveryCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {DeliveryItemDto} from 'src/app/controller/model/DeliveryItem.model';
import {DeliveryItemService} from 'src/app/controller/service/DeliveryItem.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandService} from 'src/app/controller/service/Demand.service';
@Component({
  selector: 'app-delivery-view-admin',
  templateUrl: './delivery-view-admin.component.html'
})
export class DeliveryViewAdminComponent extends AbstractViewController<DeliveryDto, DeliveryCriteria, DeliveryService> implements OnInit {

    deliveryItems = new DeliveryItemDto();
    deliveryItemss: Array<DeliveryItemDto> = [];

    constructor(private deliveryService: DeliveryService, private storeService: StoreService, private deliveryStatusService: DeliveryStatusService, private clientService: ClientService, private productService: ProductService, private deliveryItemService: DeliveryItemService, private demandService: DemandService){
        super(deliveryService);
    }

    ngOnInit(): void {
        this.deliveryItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.deliveryItems.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.demand = new DemandDto();
        this.demandService.findAll().subscribe((data) => this.demands = data);
        this.deliveryStatus = new DeliveryStatusDto();
        this.deliveryStatusService.findAll().subscribe((data) => this.deliveryStatuss = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
    }


    get demand(): DemandDto {
       return this.demandService.item;
    }
    set demand(value: DemandDto) {
        this.demandService.item = value;
    }
    get demands():Array<DemandDto> {
       return this.demandService.items;
    }
    set demands(value: Array<DemandDto>) {
        this.demandService.items = value;
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
    get client(): ClientDto {
       return this.clientService.item;
    }
    set client(value: ClientDto) {
        this.clientService.item = value;
    }
    get clients():Array<ClientDto> {
       return this.clientService.items;
    }
    set clients(value: Array<ClientDto>) {
        this.clientService.items = value;
    }
    get deliveryStatus(): DeliveryStatusDto {
       return this.deliveryStatusService.item;
    }
    set deliveryStatus(value: DeliveryStatusDto) {
        this.deliveryStatusService.item = value;
    }
    get deliveryStatuss():Array<DeliveryStatusDto> {
       return this.deliveryStatusService.items;
    }
    set deliveryStatuss(value: Array<DeliveryStatusDto>) {
        this.deliveryStatusService.items = value;
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

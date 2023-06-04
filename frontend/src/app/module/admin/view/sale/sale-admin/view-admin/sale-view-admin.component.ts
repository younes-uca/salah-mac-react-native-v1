import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SaleService} from 'src/app/controller/service/Sale.service';
import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleCriteria} from 'src/app/controller/criteria/SaleCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SaleItemDto} from 'src/app/controller/model/SaleItem.model';
import {SaleItemService} from 'src/app/controller/service/SaleItem.service';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {SaleStatusService} from 'src/app/controller/service/SaleStatus.service';
@Component({
  selector: 'app-sale-view-admin',
  templateUrl: './sale-view-admin.component.html'
})
export class SaleViewAdminComponent extends AbstractViewController<SaleDto, SaleCriteria, SaleService> implements OnInit {

    saleItems = new SaleItemDto();
    saleItemss: Array<SaleItemDto> = [];

    constructor(private saleService: SaleService, private storeService: StoreService, private saleItemService: SaleItemService, private clientService: ClientService, private productService: ProductService, private saleStatusService: SaleStatusService){
        super(saleService);
    }

    ngOnInit(): void {
        this.saleItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.saleStatus = new SaleStatusDto();
        this.saleStatusService.findAll().subscribe((data) => this.saleStatuss = data);
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
    get saleStatus(): SaleStatusDto {
       return this.saleStatusService.item;
    }
    set saleStatus(value: SaleStatusDto) {
        this.saleStatusService.item = value;
    }
    get saleStatuss():Array<SaleStatusDto> {
       return this.saleStatusService.items;
    }
    set saleStatuss(value: Array<SaleStatusDto>) {
        this.saleStatusService.items = value;
    }


}

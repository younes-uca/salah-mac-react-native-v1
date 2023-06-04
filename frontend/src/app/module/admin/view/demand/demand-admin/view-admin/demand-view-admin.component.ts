import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DemandService} from 'src/app/controller/service/Demand.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandCriteria} from 'src/app/controller/criteria/DemandCriteria.model';

import {ClientDto} from 'src/app/controller/model/Client.model';
import {ClientService} from 'src/app/controller/service/Client.service';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {DemandStatusService} from 'src/app/controller/service/DemandStatus.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
import {DemandItemDto} from 'src/app/controller/model/DemandItem.model';
import {DemandItemService} from 'src/app/controller/service/DemandItem.service';
@Component({
  selector: 'app-demand-view-admin',
  templateUrl: './demand-view-admin.component.html'
})
export class DemandViewAdminComponent extends AbstractViewController<DemandDto, DemandCriteria, DemandService> implements OnInit {

    demandItems = new DemandItemDto();
    demandItemss: Array<DemandItemDto> = [];

    constructor(private demandService: DemandService, private clientService: ClientService, private demandStatusService: DemandStatusService, private productService: ProductService, private demandItemService: DemandItemService){
        super(demandService);
    }

    ngOnInit(): void {
        this.demandItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.client = new ClientDto();
        this.clientService.findAll().subscribe((data) => this.clients = data);
        this.demandStatus = new DemandStatusDto();
        this.demandStatusService.findAll().subscribe((data) => this.demandStatuss = data);
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
    get demandStatus(): DemandStatusDto {
       return this.demandStatusService.item;
    }
    set demandStatus(value: DemandStatusDto) {
        this.demandStatusService.item = value;
    }
    get demandStatuss():Array<DemandStatusDto> {
       return this.demandStatusService.items;
    }
    set demandStatuss(value: Array<DemandStatusDto>) {
        this.demandStatusService.items = value;
    }


}

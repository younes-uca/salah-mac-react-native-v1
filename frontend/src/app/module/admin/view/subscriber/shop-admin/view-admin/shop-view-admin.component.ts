import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ShopService} from 'src/app/controller/service/Shop.service';
import {ShopDto} from 'src/app/controller/model/Shop.model';
import {ShopCriteria} from 'src/app/controller/criteria/ShopCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-shop-view-admin',
  templateUrl: './shop-view-admin.component.html'
})
export class ShopViewAdminComponent extends AbstractViewController<ShopDto, ShopCriteria, ShopService> implements OnInit {


    constructor(private shopService: ShopService, private storeService: StoreService){
        super(shopService);
    }

    ngOnInit(): void {
        this.store = new StoreDto();
        this.storeService.findAll().subscribe((data) => this.stores = data);
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

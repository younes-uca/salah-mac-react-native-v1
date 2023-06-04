import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CompanyService} from 'src/app/controller/service/Company.service';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyCriteria} from 'src/app/controller/criteria/CompanyCriteria.model';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';
import {SubscriberService} from 'src/app/controller/service/Subscriber.service';
@Component({
  selector: 'app-company-view-admin',
  templateUrl: './company-view-admin.component.html'
})
export class CompanyViewAdminComponent extends AbstractViewController<CompanyDto, CompanyCriteria, CompanyService> implements OnInit {

    stores = new StoreDto();
    storess: Array<StoreDto> = [];

    constructor(private companyService: CompanyService, private storeService: StoreService, private subscriberService: SubscriberService){
        super(companyService);
    }

    ngOnInit(): void {
        this.subscriber = new SubscriberDto();
        this.subscriberService.findAll().subscribe((data) => this.subscribers = data);
    }


    get subscriber(): SubscriberDto {
       return this.subscriberService.item;
    }
    set subscriber(value: SubscriberDto) {
        this.subscriberService.item = value;
    }
    get subscribers():Array<SubscriberDto> {
       return this.subscriberService.items;
    }
    set subscribers(value: Array<SubscriberDto>) {
        this.subscriberService.items = value;
    }


}

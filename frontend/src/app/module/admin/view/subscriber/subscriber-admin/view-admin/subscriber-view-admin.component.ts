import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubscriberService} from 'src/app/controller/service/Subscriber.service';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';
import {SubscriberCriteria} from 'src/app/controller/criteria/SubscriberCriteria.model';

import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreService} from 'src/app/controller/service/Store.service';
@Component({
  selector: 'app-subscriber-view-admin',
  templateUrl: './subscriber-view-admin.component.html'
})
export class SubscriberViewAdminComponent extends AbstractViewController<SubscriberDto, SubscriberCriteria, SubscriberService> implements OnInit {

    companys = new CompanyDto();
    companyss: Array<CompanyDto> = [];

    constructor(private subscriberService: SubscriberService, private companyService: CompanyService){
        super(subscriberService);
    }

    ngOnInit(): void {
    }




}

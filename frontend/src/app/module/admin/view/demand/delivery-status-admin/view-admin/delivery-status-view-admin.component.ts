import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusCriteria} from 'src/app/controller/criteria/DeliveryStatusCriteria.model';

@Component({
  selector: 'app-delivery-status-view-admin',
  templateUrl: './delivery-status-view-admin.component.html'
})
export class DeliveryStatusViewAdminComponent extends AbstractViewController<DeliveryStatusDto, DeliveryStatusCriteria, DeliveryStatusService> implements OnInit {


    constructor(private deliveryStatusService: DeliveryStatusService){
        super(deliveryStatusService);
    }

    ngOnInit(): void {
    }




}

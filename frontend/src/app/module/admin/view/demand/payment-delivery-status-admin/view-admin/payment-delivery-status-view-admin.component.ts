import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentDeliveryStatusService} from 'src/app/controller/service/PaymentDeliveryStatus.service';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {PaymentDeliveryStatusCriteria} from 'src/app/controller/criteria/PaymentDeliveryStatusCriteria.model';

@Component({
  selector: 'app-payment-delivery-status-view-admin',
  templateUrl: './payment-delivery-status-view-admin.component.html'
})
export class PaymentDeliveryStatusViewAdminComponent extends AbstractViewController<PaymentDeliveryStatusDto, PaymentDeliveryStatusCriteria, PaymentDeliveryStatusService> implements OnInit {


    constructor(private paymentDeliveryStatusService: PaymentDeliveryStatusService){
        super(paymentDeliveryStatusService);
    }

    ngOnInit(): void {
    }




}

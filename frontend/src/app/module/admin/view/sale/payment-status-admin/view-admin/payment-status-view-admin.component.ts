import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentStatusService} from 'src/app/controller/service/PaymentStatus.service';
import {PaymentStatusDto} from 'src/app/controller/model/PaymentStatus.model';
import {PaymentStatusCriteria} from 'src/app/controller/criteria/PaymentStatusCriteria.model';

@Component({
  selector: 'app-payment-status-view-admin',
  templateUrl: './payment-status-view-admin.component.html'
})
export class PaymentStatusViewAdminComponent extends AbstractViewController<PaymentStatusDto, PaymentStatusCriteria, PaymentStatusService> implements OnInit {


    constructor(private paymentStatusService: PaymentStatusService){
        super(paymentStatusService);
    }

    ngOnInit(): void {
    }




}

import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeCriteria} from 'src/app/controller/criteria/PaymentModeCriteria.model';

@Component({
  selector: 'app-payment-mode-view-admin',
  templateUrl: './payment-mode-view-admin.component.html'
})
export class PaymentModeViewAdminComponent extends AbstractViewController<PaymentModeDto, PaymentModeCriteria, PaymentModeService> implements OnInit {


    constructor(private paymentModeService: PaymentModeService){
        super(paymentModeService);
    }

    ngOnInit(): void {
    }




}

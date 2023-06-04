import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodCriteria} from 'src/app/controller/criteria/PaymentMethodCriteria.model';

@Component({
  selector: 'app-payment-method-view-admin',
  templateUrl: './payment-method-view-admin.component.html'
})
export class PaymentMethodViewAdminComponent extends AbstractViewController<PaymentMethodDto, PaymentMethodCriteria, PaymentMethodService> implements OnInit {


    constructor(private paymentMethodService: PaymentMethodService){
        super(paymentMethodService);
    }

    ngOnInit(): void {
    }




}

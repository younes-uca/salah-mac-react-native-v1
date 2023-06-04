import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentDeliveryStatusService} from 'src/app/controller/service/PaymentDeliveryStatus.service';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {PaymentDeliveryStatusCriteria} from 'src/app/controller/criteria/PaymentDeliveryStatusCriteria.model';
@Component({
  selector: 'app-payment-delivery-status-create-admin',
  templateUrl: './payment-delivery-status-create-admin.component.html'
})
export class PaymentDeliveryStatusCreateAdminComponent extends AbstractCreateController<PaymentDeliveryStatusDto, PaymentDeliveryStatusCriteria, PaymentDeliveryStatusService>  implements OnInit {




    constructor( private paymentDeliveryStatusService: PaymentDeliveryStatusService ) {
        super(paymentDeliveryStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

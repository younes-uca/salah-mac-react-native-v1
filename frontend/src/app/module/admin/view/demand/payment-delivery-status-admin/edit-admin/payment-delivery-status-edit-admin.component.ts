import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaymentDeliveryStatusService} from 'src/app/controller/service/PaymentDeliveryStatus.service';
import {PaymentDeliveryStatusDto} from 'src/app/controller/model/PaymentDeliveryStatus.model';
import {PaymentDeliveryStatusCriteria} from 'src/app/controller/criteria/PaymentDeliveryStatusCriteria.model';



@Component({
  selector: 'app-payment-delivery-status-edit-admin',
  templateUrl: './payment-delivery-status-edit-admin.component.html'
})
export class PaymentDeliveryStatusEditAdminComponent extends AbstractEditController<PaymentDeliveryStatusDto, PaymentDeliveryStatusCriteria, PaymentDeliveryStatusService>   implements OnInit {






    constructor( private paymentDeliveryStatusService: PaymentDeliveryStatusService ) {
        super(paymentDeliveryStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

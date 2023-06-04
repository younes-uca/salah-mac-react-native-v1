import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentStatusService} from 'src/app/controller/service/PaymentStatus.service';
import {PaymentStatusDto} from 'src/app/controller/model/PaymentStatus.model';
import {PaymentStatusCriteria} from 'src/app/controller/criteria/PaymentStatusCriteria.model';
@Component({
  selector: 'app-payment-status-create-admin',
  templateUrl: './payment-status-create-admin.component.html'
})
export class PaymentStatusCreateAdminComponent extends AbstractCreateController<PaymentStatusDto, PaymentStatusCriteria, PaymentStatusService>  implements OnInit {




    constructor( private paymentStatusService: PaymentStatusService ) {
        super(paymentStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

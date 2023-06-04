import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeCriteria} from 'src/app/controller/criteria/PaymentModeCriteria.model';
@Component({
  selector: 'app-payment-mode-create-admin',
  templateUrl: './payment-mode-create-admin.component.html'
})
export class PaymentModeCreateAdminComponent extends AbstractCreateController<PaymentModeDto, PaymentModeCriteria, PaymentModeService>  implements OnInit {




    constructor( private paymentModeService: PaymentModeService ) {
        super(paymentModeService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

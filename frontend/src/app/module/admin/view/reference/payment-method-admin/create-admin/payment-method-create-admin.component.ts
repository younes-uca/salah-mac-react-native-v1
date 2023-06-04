import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodCriteria} from 'src/app/controller/criteria/PaymentMethodCriteria.model';
@Component({
  selector: 'app-payment-method-create-admin',
  templateUrl: './payment-method-create-admin.component.html'
})
export class PaymentMethodCreateAdminComponent extends AbstractCreateController<PaymentMethodDto, PaymentMethodCriteria, PaymentMethodService>  implements OnInit {




    constructor( private paymentMethodService: PaymentMethodService ) {
        super(paymentMethodService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

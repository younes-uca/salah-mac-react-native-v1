import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaymentMethodService} from 'src/app/controller/service/PaymentMethod.service';
import {PaymentMethodDto} from 'src/app/controller/model/PaymentMethod.model';
import {PaymentMethodCriteria} from 'src/app/controller/criteria/PaymentMethodCriteria.model';



@Component({
  selector: 'app-payment-method-edit-admin',
  templateUrl: './payment-method-edit-admin.component.html'
})
export class PaymentMethodEditAdminComponent extends AbstractEditController<PaymentMethodDto, PaymentMethodCriteria, PaymentMethodService>   implements OnInit {






    constructor( private paymentMethodService: PaymentMethodService ) {
        super(paymentMethodService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeCriteria} from 'src/app/controller/criteria/PaymentModeCriteria.model';



@Component({
  selector: 'app-payment-mode-edit-admin',
  templateUrl: './payment-mode-edit-admin.component.html'
})
export class PaymentModeEditAdminComponent extends AbstractEditController<PaymentModeDto, PaymentModeCriteria, PaymentModeService>   implements OnInit {






    constructor( private paymentModeService: PaymentModeService ) {
        super(paymentModeService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

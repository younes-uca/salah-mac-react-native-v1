import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {LatePaymentRateService} from 'src/app/controller/service/LatePaymentRate.service';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {LatePaymentRateCriteria} from 'src/app/controller/criteria/LatePaymentRateCriteria.model';
@Component({
  selector: 'app-late-payment-rate-create-admin',
  templateUrl: './late-payment-rate-create-admin.component.html'
})
export class LatePaymentRateCreateAdminComponent extends AbstractCreateController<LatePaymentRateDto, LatePaymentRateCriteria, LatePaymentRateService>  implements OnInit {




    constructor( private latePaymentRateService: LatePaymentRateService ) {
        super(latePaymentRateService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

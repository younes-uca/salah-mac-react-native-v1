import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {LatePaymentRateService} from 'src/app/controller/service/LatePaymentRate.service';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {LatePaymentRateCriteria} from 'src/app/controller/criteria/LatePaymentRateCriteria.model';



@Component({
  selector: 'app-late-payment-rate-edit-admin',
  templateUrl: './late-payment-rate-edit-admin.component.html'
})
export class LatePaymentRateEditAdminComponent extends AbstractEditController<LatePaymentRateDto, LatePaymentRateCriteria, LatePaymentRateService>   implements OnInit {






    constructor( private latePaymentRateService: LatePaymentRateService ) {
        super(latePaymentRateService);
    }

    ngOnInit(): void {
}
    public prepareEdit() {
        this.item.minApplicationDate = this.latePaymentRateService.format(this.item.minApplicationDate);
        this.item.maxApplicationDate = this.latePaymentRateService.format(this.item.maxApplicationDate);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

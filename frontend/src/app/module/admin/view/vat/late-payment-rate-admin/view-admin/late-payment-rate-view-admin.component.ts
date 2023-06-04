import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {LatePaymentRateService} from 'src/app/controller/service/LatePaymentRate.service';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {LatePaymentRateCriteria} from 'src/app/controller/criteria/LatePaymentRateCriteria.model';

@Component({
  selector: 'app-late-payment-rate-view-admin',
  templateUrl: './late-payment-rate-view-admin.component.html'
})
export class LatePaymentRateViewAdminComponent extends AbstractViewController<LatePaymentRateDto, LatePaymentRateCriteria, LatePaymentRateService> implements OnInit {


    constructor(private latePaymentRateService: LatePaymentRateService){
        super(latePaymentRateService);
    }

    ngOnInit(): void {
    }




}

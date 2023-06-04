import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {StatusPaymentDemandService} from 'src/app/controller/service/StatusPaymentDemand.service';
import {StatusPaymentDemandDto} from 'src/app/controller/model/StatusPaymentDemand.model';
import {StatusPaymentDemandCriteria} from 'src/app/controller/criteria/StatusPaymentDemandCriteria.model';

@Component({
  selector: 'app-status-payment-demand-view-admin',
  templateUrl: './status-payment-demand-view-admin.component.html'
})
export class StatusPaymentDemandViewAdminComponent extends AbstractViewController<StatusPaymentDemandDto, StatusPaymentDemandCriteria, StatusPaymentDemandService> implements OnInit {


    constructor(private statusPaymentDemandService: StatusPaymentDemandService){
        super(statusPaymentDemandService);
    }

    ngOnInit(): void {
    }




}

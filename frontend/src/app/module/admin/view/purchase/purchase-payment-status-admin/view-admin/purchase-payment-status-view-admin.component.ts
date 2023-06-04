import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchasePaymentStatusService} from 'src/app/controller/service/PurchasePaymentStatus.service';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PurchasePaymentStatusCriteria} from 'src/app/controller/criteria/PurchasePaymentStatusCriteria.model';

@Component({
  selector: 'app-purchase-payment-status-view-admin',
  templateUrl: './purchase-payment-status-view-admin.component.html'
})
export class PurchasePaymentStatusViewAdminComponent extends AbstractViewController<PurchasePaymentStatusDto, PurchasePaymentStatusCriteria, PurchasePaymentStatusService> implements OnInit {


    constructor(private purchasePaymentStatusService: PurchasePaymentStatusService){
        super(purchasePaymentStatusService);
    }

    ngOnInit(): void {
    }




}

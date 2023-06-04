import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusCriteria} from 'src/app/controller/criteria/PurchaseStatusCriteria.model';

@Component({
  selector: 'app-purchase-status-view-admin',
  templateUrl: './purchase-status-view-admin.component.html'
})
export class PurchaseStatusViewAdminComponent extends AbstractViewController<PurchaseStatusDto, PurchaseStatusCriteria, PurchaseStatusService> implements OnInit {


    constructor(private purchaseStatusService: PurchaseStatusService){
        super(purchaseStatusService);
    }

    ngOnInit(): void {
    }




}

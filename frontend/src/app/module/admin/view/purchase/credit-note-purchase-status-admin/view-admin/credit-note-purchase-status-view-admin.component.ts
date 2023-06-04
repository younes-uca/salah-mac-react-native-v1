import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CreditNotePurchaseStatusService} from 'src/app/controller/service/CreditNotePurchaseStatus.service';
import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusCriteria} from 'src/app/controller/criteria/CreditNotePurchaseStatusCriteria.model';

@Component({
  selector: 'app-credit-note-purchase-status-view-admin',
  templateUrl: './credit-note-purchase-status-view-admin.component.html'
})
export class CreditNotePurchaseStatusViewAdminComponent extends AbstractViewController<CreditNotePurchaseStatusDto, CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusService> implements OnInit {


    constructor(private creditNotePurchaseStatusService: CreditNotePurchaseStatusService){
        super(creditNotePurchaseStatusService);
    }

    ngOnInit(): void {
    }




}

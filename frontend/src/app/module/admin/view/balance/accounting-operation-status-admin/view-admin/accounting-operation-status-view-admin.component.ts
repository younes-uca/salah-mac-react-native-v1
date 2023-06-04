import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AccountingOperationStatusService} from 'src/app/controller/service/AccountingOperationStatus.service';
import {AccountingOperationStatusDto} from 'src/app/controller/model/AccountingOperationStatus.model';
import {AccountingOperationStatusCriteria} from 'src/app/controller/criteria/AccountingOperationStatusCriteria.model';

@Component({
  selector: 'app-accounting-operation-status-view-admin',
  templateUrl: './accounting-operation-status-view-admin.component.html'
})
export class AccountingOperationStatusViewAdminComponent extends AbstractViewController<AccountingOperationStatusDto, AccountingOperationStatusCriteria, AccountingOperationStatusService> implements OnInit {


    constructor(private accountingOperationStatusService: AccountingOperationStatusService){
        super(accountingOperationStatusService);
    }

    ngOnInit(): void {
    }




}

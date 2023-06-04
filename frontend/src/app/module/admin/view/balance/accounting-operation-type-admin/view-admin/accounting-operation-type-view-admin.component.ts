import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AccountingOperationTypeService} from 'src/app/controller/service/AccountingOperationType.service';
import {AccountingOperationTypeDto} from 'src/app/controller/model/AccountingOperationType.model';
import {AccountingOperationTypeCriteria} from 'src/app/controller/criteria/AccountingOperationTypeCriteria.model';

@Component({
  selector: 'app-accounting-operation-type-view-admin',
  templateUrl: './accounting-operation-type-view-admin.component.html'
})
export class AccountingOperationTypeViewAdminComponent extends AbstractViewController<AccountingOperationTypeDto, AccountingOperationTypeCriteria, AccountingOperationTypeService> implements OnInit {


    constructor(private accountingOperationTypeService: AccountingOperationTypeService){
        super(accountingOperationTypeService);
    }

    ngOnInit(): void {
    }




}

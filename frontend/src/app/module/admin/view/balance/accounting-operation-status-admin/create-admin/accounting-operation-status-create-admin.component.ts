import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AccountingOperationStatusService} from 'src/app/controller/service/AccountingOperationStatus.service';
import {AccountingOperationStatusDto} from 'src/app/controller/model/AccountingOperationStatus.model';
import {AccountingOperationStatusCriteria} from 'src/app/controller/criteria/AccountingOperationStatusCriteria.model';
@Component({
  selector: 'app-accounting-operation-status-create-admin',
  templateUrl: './accounting-operation-status-create-admin.component.html'
})
export class AccountingOperationStatusCreateAdminComponent extends AbstractCreateController<AccountingOperationStatusDto, AccountingOperationStatusCriteria, AccountingOperationStatusService>  implements OnInit {




    constructor( private accountingOperationStatusService: AccountingOperationStatusService ) {
        super(accountingOperationStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

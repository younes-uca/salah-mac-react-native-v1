import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AccountingOperationTypeService} from 'src/app/controller/service/AccountingOperationType.service';
import {AccountingOperationTypeDto} from 'src/app/controller/model/AccountingOperationType.model';
import {AccountingOperationTypeCriteria} from 'src/app/controller/criteria/AccountingOperationTypeCriteria.model';
@Component({
  selector: 'app-accounting-operation-type-create-admin',
  templateUrl: './accounting-operation-type-create-admin.component.html'
})
export class AccountingOperationTypeCreateAdminComponent extends AbstractCreateController<AccountingOperationTypeDto, AccountingOperationTypeCriteria, AccountingOperationTypeService>  implements OnInit {




    constructor( private accountingOperationTypeService: AccountingOperationTypeService ) {
        super(accountingOperationTypeService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

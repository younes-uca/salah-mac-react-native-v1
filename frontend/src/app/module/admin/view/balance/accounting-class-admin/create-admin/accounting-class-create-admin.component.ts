import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {AccountingClassService} from 'src/app/controller/service/AccountingClass.service';
import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';
import {AccountingClassCriteria} from 'src/app/controller/criteria/AccountingClassCriteria.model';
@Component({
  selector: 'app-accounting-class-create-admin',
  templateUrl: './accounting-class-create-admin.component.html'
})
export class AccountingClassCreateAdminComponent extends AbstractCreateController<AccountingClassDto, AccountingClassCriteria, AccountingClassService>  implements OnInit {




    constructor( private accountingClassService: AccountingClassService ) {
        super(accountingClassService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

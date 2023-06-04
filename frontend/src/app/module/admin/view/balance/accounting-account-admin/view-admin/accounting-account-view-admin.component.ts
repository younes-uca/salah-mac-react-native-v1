import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AccountingAccountService} from 'src/app/controller/service/AccountingAccount.service';
import {AccountingAccountDto} from 'src/app/controller/model/AccountingAccount.model';
import {AccountingAccountCriteria} from 'src/app/controller/criteria/AccountingAccountCriteria.model';

import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';
import {SubAccountingClassService} from 'src/app/controller/service/SubAccountingClass.service';
@Component({
  selector: 'app-accounting-account-view-admin',
  templateUrl: './accounting-account-view-admin.component.html'
})
export class AccountingAccountViewAdminComponent extends AbstractViewController<AccountingAccountDto, AccountingAccountCriteria, AccountingAccountService> implements OnInit {


    constructor(private accountingAccountService: AccountingAccountService, private subAccountingClassService: SubAccountingClassService){
        super(accountingAccountService);
    }

    ngOnInit(): void {
        this.subAccountingClass = new SubAccountingClassDto();
        this.subAccountingClassService.findAll().subscribe((data) => this.subAccountingClasss = data);
    }


    get subAccountingClass(): SubAccountingClassDto {
       return this.subAccountingClassService.item;
    }
    set subAccountingClass(value: SubAccountingClassDto) {
        this.subAccountingClassService.item = value;
    }
    get subAccountingClasss():Array<SubAccountingClassDto> {
       return this.subAccountingClassService.items;
    }
    set subAccountingClasss(value: Array<SubAccountingClassDto>) {
        this.subAccountingClassService.items = value;
    }


}

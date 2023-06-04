import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AccountingOperationService} from 'src/app/controller/service/AccountingOperation.service';
import {AccountingOperationDto} from 'src/app/controller/model/AccountingOperation.model';
import {AccountingOperationCriteria} from 'src/app/controller/criteria/AccountingOperationCriteria.model';

import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {AccountingAccountDto} from 'src/app/controller/model/AccountingAccount.model';
import {AccountingAccountService} from 'src/app/controller/service/AccountingAccount.service';
import {AccountingOperationStatusDto} from 'src/app/controller/model/AccountingOperationStatus.model';
import {AccountingOperationStatusService} from 'src/app/controller/service/AccountingOperationStatus.service';
import {AccountingOperationTypeDto} from 'src/app/controller/model/AccountingOperationType.model';
import {AccountingOperationTypeService} from 'src/app/controller/service/AccountingOperationType.service';
@Component({
  selector: 'app-accounting-operation-view-admin',
  templateUrl: './accounting-operation-view-admin.component.html'
})
export class AccountingOperationViewAdminComponent extends AbstractViewController<AccountingOperationDto, AccountingOperationCriteria, AccountingOperationService> implements OnInit {


    constructor(private accountingOperationService: AccountingOperationService, private companyService: CompanyService, private accountingAccountService: AccountingAccountService, private accountingOperationStatusService: AccountingOperationStatusService, private accountingOperationTypeService: AccountingOperationTypeService){
        super(accountingOperationService);
    }

    ngOnInit(): void {
        this.company = new CompanyDto();
        this.companyService.findAll().subscribe((data) => this.companys = data);
        this.accountingAccount = new AccountingAccountDto();
        this.accountingAccountService.findAll().subscribe((data) => this.accountingAccounts = data);
        this.accountingOperationType = new AccountingOperationTypeDto();
        this.accountingOperationTypeService.findAll().subscribe((data) => this.accountingOperationTypes = data);
        this.accountingOperationStatus = new AccountingOperationStatusDto();
        this.accountingOperationStatusService.findAll().subscribe((data) => this.accountingOperationStatuss = data);
    }


    get company(): CompanyDto {
       return this.companyService.item;
    }
    set company(value: CompanyDto) {
        this.companyService.item = value;
    }
    get companys():Array<CompanyDto> {
       return this.companyService.items;
    }
    set companys(value: Array<CompanyDto>) {
        this.companyService.items = value;
    }
    get accountingOperationStatus(): AccountingOperationStatusDto {
       return this.accountingOperationStatusService.item;
    }
    set accountingOperationStatus(value: AccountingOperationStatusDto) {
        this.accountingOperationStatusService.item = value;
    }
    get accountingOperationStatuss():Array<AccountingOperationStatusDto> {
       return this.accountingOperationStatusService.items;
    }
    set accountingOperationStatuss(value: Array<AccountingOperationStatusDto>) {
        this.accountingOperationStatusService.items = value;
    }
    get accountingOperationType(): AccountingOperationTypeDto {
       return this.accountingOperationTypeService.item;
    }
    set accountingOperationType(value: AccountingOperationTypeDto) {
        this.accountingOperationTypeService.item = value;
    }
    get accountingOperationTypes():Array<AccountingOperationTypeDto> {
       return this.accountingOperationTypeService.items;
    }
    set accountingOperationTypes(value: Array<AccountingOperationTypeDto>) {
        this.accountingOperationTypeService.items = value;
    }
    get accountingAccount(): AccountingAccountDto {
       return this.accountingAccountService.item;
    }
    set accountingAccount(value: AccountingAccountDto) {
        this.accountingAccountService.item = value;
    }
    get accountingAccounts():Array<AccountingAccountDto> {
       return this.accountingAccountService.items;
    }
    set accountingAccounts(value: Array<AccountingAccountDto>) {
        this.accountingAccountService.items = value;
    }


}

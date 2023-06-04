import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SubAccountingClassService} from 'src/app/controller/service/SubAccountingClass.service';
import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';
import {SubAccountingClassCriteria} from 'src/app/controller/criteria/SubAccountingClassCriteria.model';

import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';
import {AccountingClassService} from 'src/app/controller/service/AccountingClass.service';
@Component({
  selector: 'app-sub-accounting-class-view-admin',
  templateUrl: './sub-accounting-class-view-admin.component.html'
})
export class SubAccountingClassViewAdminComponent extends AbstractViewController<SubAccountingClassDto, SubAccountingClassCriteria, SubAccountingClassService> implements OnInit {


    constructor(private subAccountingClassService: SubAccountingClassService, private accountingClassService: AccountingClassService){
        super(subAccountingClassService);
    }

    ngOnInit(): void {
        this.accountingClass = new AccountingClassDto();
        this.accountingClassService.findAll().subscribe((data) => this.accountingClasss = data);
    }


    get accountingClass(): AccountingClassDto {
       return this.accountingClassService.item;
    }
    set accountingClass(value: AccountingClassDto) {
        this.accountingClassService.item = value;
    }
    get accountingClasss():Array<AccountingClassDto> {
       return this.accountingClassService.items;
    }
    set accountingClasss(value: Array<AccountingClassDto>) {
        this.accountingClassService.items = value;
    }


}

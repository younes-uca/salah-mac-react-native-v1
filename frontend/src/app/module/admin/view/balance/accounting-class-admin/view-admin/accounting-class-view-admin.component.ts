import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {AccountingClassService} from 'src/app/controller/service/AccountingClass.service';
import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';
import {AccountingClassCriteria} from 'src/app/controller/criteria/AccountingClassCriteria.model';

@Component({
  selector: 'app-accounting-class-view-admin',
  templateUrl: './accounting-class-view-admin.component.html'
})
export class AccountingClassViewAdminComponent extends AbstractViewController<AccountingClassDto, AccountingClassCriteria, AccountingClassService> implements OnInit {


    constructor(private accountingClassService: AccountingClassService){
        super(accountingClassService);
    }

    ngOnInit(): void {
    }




}

import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BankService} from 'src/app/controller/service/Bank.service';
import {BankDto} from 'src/app/controller/model/Bank.model';
import {BankCriteria} from 'src/app/controller/criteria/BankCriteria.model';

@Component({
  selector: 'app-bank-view-admin',
  templateUrl: './bank-view-admin.component.html'
})
export class BankViewAdminComponent extends AbstractViewController<BankDto, BankCriteria, BankService> implements OnInit {


    constructor(private bankService: BankService){
        super(bankService);
    }

    ngOnInit(): void {
    }




}

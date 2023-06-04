import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BalanceSheetStatusService} from 'src/app/controller/service/BalanceSheetStatus.service';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';
import {BalanceSheetStatusCriteria} from 'src/app/controller/criteria/BalanceSheetStatusCriteria.model';

@Component({
  selector: 'app-balance-sheet-status-view-admin',
  templateUrl: './balance-sheet-status-view-admin.component.html'
})
export class BalanceSheetStatusViewAdminComponent extends AbstractViewController<BalanceSheetStatusDto, BalanceSheetStatusCriteria, BalanceSheetStatusService> implements OnInit {


    constructor(private balanceSheetStatusService: BalanceSheetStatusService){
        super(balanceSheetStatusService);
    }

    ngOnInit(): void {
    }




}

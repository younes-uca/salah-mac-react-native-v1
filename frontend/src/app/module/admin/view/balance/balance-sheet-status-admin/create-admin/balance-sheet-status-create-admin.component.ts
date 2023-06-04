import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BalanceSheetStatusService} from 'src/app/controller/service/BalanceSheetStatus.service';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';
import {BalanceSheetStatusCriteria} from 'src/app/controller/criteria/BalanceSheetStatusCriteria.model';
@Component({
  selector: 'app-balance-sheet-status-create-admin',
  templateUrl: './balance-sheet-status-create-admin.component.html'
})
export class BalanceSheetStatusCreateAdminComponent extends AbstractCreateController<BalanceSheetStatusDto, BalanceSheetStatusCriteria, BalanceSheetStatusService>  implements OnInit {




    constructor( private balanceSheetStatusService: BalanceSheetStatusService ) {
        super(balanceSheetStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

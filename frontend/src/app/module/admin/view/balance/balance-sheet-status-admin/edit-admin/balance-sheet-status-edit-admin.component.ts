import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {BalanceSheetStatusService} from 'src/app/controller/service/BalanceSheetStatus.service';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';
import {BalanceSheetStatusCriteria} from 'src/app/controller/criteria/BalanceSheetStatusCriteria.model';



@Component({
  selector: 'app-balance-sheet-status-edit-admin',
  templateUrl: './balance-sheet-status-edit-admin.component.html'
})
export class BalanceSheetStatusEditAdminComponent extends AbstractEditController<BalanceSheetStatusDto, BalanceSheetStatusCriteria, BalanceSheetStatusService>   implements OnInit {






    constructor( private balanceSheetStatusService: BalanceSheetStatusService ) {
        super(balanceSheetStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

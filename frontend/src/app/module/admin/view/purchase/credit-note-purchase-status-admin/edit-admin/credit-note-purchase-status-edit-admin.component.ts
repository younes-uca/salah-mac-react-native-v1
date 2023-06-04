import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CreditNotePurchaseStatusService} from 'src/app/controller/service/CreditNotePurchaseStatus.service';
import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseStatusCriteria} from 'src/app/controller/criteria/CreditNotePurchaseStatusCriteria.model';



@Component({
  selector: 'app-credit-note-purchase-status-edit-admin',
  templateUrl: './credit-note-purchase-status-edit-admin.component.html'
})
export class CreditNotePurchaseStatusEditAdminComponent extends AbstractEditController<CreditNotePurchaseStatusDto, CreditNotePurchaseStatusCriteria, CreditNotePurchaseStatusService>   implements OnInit {






    constructor( private creditNotePurchaseStatusService: CreditNotePurchaseStatusService ) {
        super(creditNotePurchaseStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

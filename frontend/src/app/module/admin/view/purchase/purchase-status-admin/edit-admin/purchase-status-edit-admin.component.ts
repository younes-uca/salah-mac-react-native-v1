import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusCriteria} from 'src/app/controller/criteria/PurchaseStatusCriteria.model';



@Component({
  selector: 'app-purchase-status-edit-admin',
  templateUrl: './purchase-status-edit-admin.component.html'
})
export class PurchaseStatusEditAdminComponent extends AbstractEditController<PurchaseStatusDto, PurchaseStatusCriteria, PurchaseStatusService>   implements OnInit {






    constructor( private purchaseStatusService: PurchaseStatusService ) {
        super(purchaseStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

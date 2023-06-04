import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PurchaseStatusService} from 'src/app/controller/service/PurchaseStatus.service';
import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {PurchaseStatusCriteria} from 'src/app/controller/criteria/PurchaseStatusCriteria.model';
@Component({
  selector: 'app-purchase-status-create-admin',
  templateUrl: './purchase-status-create-admin.component.html'
})
export class PurchaseStatusCreateAdminComponent extends AbstractCreateController<PurchaseStatusDto, PurchaseStatusCriteria, PurchaseStatusService>  implements OnInit {




    constructor( private purchaseStatusService: PurchaseStatusService ) {
        super(purchaseStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

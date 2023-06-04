import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {PurchasePaymentStatusService} from 'src/app/controller/service/PurchasePaymentStatus.service';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PurchasePaymentStatusCriteria} from 'src/app/controller/criteria/PurchasePaymentStatusCriteria.model';



@Component({
  selector: 'app-purchase-payment-status-edit-admin',
  templateUrl: './purchase-payment-status-edit-admin.component.html'
})
export class PurchasePaymentStatusEditAdminComponent extends AbstractEditController<PurchasePaymentStatusDto, PurchasePaymentStatusCriteria, PurchasePaymentStatusService>   implements OnInit {






    constructor( private purchasePaymentStatusService: PurchasePaymentStatusService ) {
        super(purchasePaymentStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

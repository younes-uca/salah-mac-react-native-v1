import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {PurchasePaymentStatusService} from 'src/app/controller/service/PurchasePaymentStatus.service';
import {PurchasePaymentStatusDto} from 'src/app/controller/model/PurchasePaymentStatus.model';
import {PurchasePaymentStatusCriteria} from 'src/app/controller/criteria/PurchasePaymentStatusCriteria.model';
@Component({
  selector: 'app-purchase-payment-status-create-admin',
  templateUrl: './purchase-payment-status-create-admin.component.html'
})
export class PurchasePaymentStatusCreateAdminComponent extends AbstractCreateController<PurchasePaymentStatusDto, PurchasePaymentStatusCriteria, PurchasePaymentStatusService>  implements OnInit {




    constructor( private purchasePaymentStatusService: PurchasePaymentStatusService ) {
        super(purchasePaymentStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

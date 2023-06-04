import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusCriteria} from 'src/app/controller/criteria/DeliveryStatusCriteria.model';
@Component({
  selector: 'app-delivery-status-create-admin',
  templateUrl: './delivery-status-create-admin.component.html'
})
export class DeliveryStatusCreateAdminComponent extends AbstractCreateController<DeliveryStatusDto, DeliveryStatusCriteria, DeliveryStatusService>  implements OnInit {




    constructor( private deliveryStatusService: DeliveryStatusService ) {
        super(deliveryStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

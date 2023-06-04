import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusCriteria} from 'src/app/controller/criteria/DeliveryStatusCriteria.model';



@Component({
  selector: 'app-delivery-status-edit-admin',
  templateUrl: './delivery-status-edit-admin.component.html'
})
export class DeliveryStatusEditAdminComponent extends AbstractEditController<DeliveryStatusDto, DeliveryStatusCriteria, DeliveryStatusService>   implements OnInit {






    constructor( private deliveryStatusService: DeliveryStatusService ) {
        super(deliveryStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

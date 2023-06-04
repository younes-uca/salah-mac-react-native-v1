import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerCriteria} from 'src/app/controller/criteria/CheckOwnerCriteria.model';
@Component({
  selector: 'app-check-owner-create-admin',
  templateUrl: './check-owner-create-admin.component.html'
})
export class CheckOwnerCreateAdminComponent extends AbstractCreateController<CheckOwnerDto, CheckOwnerCriteria, CheckOwnerService>  implements OnInit {




    constructor( private checkOwnerService: CheckOwnerService ) {
        super(checkOwnerService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

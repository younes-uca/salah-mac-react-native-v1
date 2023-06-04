import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerCriteria} from 'src/app/controller/criteria/CheckOwnerCriteria.model';



@Component({
  selector: 'app-check-owner-edit-admin',
  templateUrl: './check-owner-edit-admin.component.html'
})
export class CheckOwnerEditAdminComponent extends AbstractEditController<CheckOwnerDto, CheckOwnerCriteria, CheckOwnerService>   implements OnInit {






    constructor( private checkOwnerService: CheckOwnerService ) {
        super(checkOwnerService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

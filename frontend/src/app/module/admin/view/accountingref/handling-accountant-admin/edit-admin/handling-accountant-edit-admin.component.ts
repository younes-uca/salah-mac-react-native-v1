import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantCriteria} from 'src/app/controller/criteria/HandlingAccountantCriteria.model';



@Component({
  selector: 'app-handling-accountant-edit-admin',
  templateUrl: './handling-accountant-edit-admin.component.html'
})
export class HandlingAccountantEditAdminComponent extends AbstractEditController<HandlingAccountantDto, HandlingAccountantCriteria, HandlingAccountantService>   implements OnInit {






    constructor( private handlingAccountantService: HandlingAccountantService ) {
        super(handlingAccountantService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantCriteria} from 'src/app/controller/criteria/HandlingAccountantCriteria.model';
@Component({
  selector: 'app-handling-accountant-create-admin',
  templateUrl: './handling-accountant-create-admin.component.html'
})
export class HandlingAccountantCreateAdminComponent extends AbstractCreateController<HandlingAccountantDto, HandlingAccountantCriteria, HandlingAccountantService>  implements OnInit {




    constructor( private handlingAccountantService: HandlingAccountantService ) {
        super(handlingAccountantService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

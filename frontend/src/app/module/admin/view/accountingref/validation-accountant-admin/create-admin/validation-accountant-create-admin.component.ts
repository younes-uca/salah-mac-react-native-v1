import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ValidationAccountantService} from 'src/app/controller/service/ValidationAccountant.service';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';
import {ValidationAccountantCriteria} from 'src/app/controller/criteria/ValidationAccountantCriteria.model';
@Component({
  selector: 'app-validation-accountant-create-admin',
  templateUrl: './validation-accountant-create-admin.component.html'
})
export class ValidationAccountantCreateAdminComponent extends AbstractCreateController<ValidationAccountantDto, ValidationAccountantCriteria, ValidationAccountantService>  implements OnInit {




    constructor( private validationAccountantService: ValidationAccountantService ) {
        super(validationAccountantService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ValidationAccountantService} from 'src/app/controller/service/ValidationAccountant.service';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';
import {ValidationAccountantCriteria} from 'src/app/controller/criteria/ValidationAccountantCriteria.model';

@Component({
  selector: 'app-validation-accountant-view-admin',
  templateUrl: './validation-accountant-view-admin.component.html'
})
export class ValidationAccountantViewAdminComponent extends AbstractViewController<ValidationAccountantDto, ValidationAccountantCriteria, ValidationAccountantService> implements OnInit {


    constructor(private validationAccountantService: ValidationAccountantService){
        super(validationAccountantService);
    }

    ngOnInit(): void {
    }




}

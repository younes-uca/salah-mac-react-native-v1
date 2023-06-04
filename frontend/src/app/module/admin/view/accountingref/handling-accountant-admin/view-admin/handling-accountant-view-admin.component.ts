import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantCriteria} from 'src/app/controller/criteria/HandlingAccountantCriteria.model';

@Component({
  selector: 'app-handling-accountant-view-admin',
  templateUrl: './handling-accountant-view-admin.component.html'
})
export class HandlingAccountantViewAdminComponent extends AbstractViewController<HandlingAccountantDto, HandlingAccountantCriteria, HandlingAccountantService> implements OnInit {


    constructor(private handlingAccountantService: HandlingAccountantService){
        super(handlingAccountantService);
    }

    ngOnInit(): void {
    }




}

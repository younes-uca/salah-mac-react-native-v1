import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusCriteria} from 'src/app/controller/criteria/ReceptionStatusCriteria.model';
@Component({
  selector: 'app-reception-status-create-admin',
  templateUrl: './reception-status-create-admin.component.html'
})
export class ReceptionStatusCreateAdminComponent extends AbstractCreateController<ReceptionStatusDto, ReceptionStatusCriteria, ReceptionStatusService>  implements OnInit {




    constructor( private receptionStatusService: ReceptionStatusService ) {
        super(receptionStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

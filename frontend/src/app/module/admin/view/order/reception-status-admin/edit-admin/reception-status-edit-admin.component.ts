import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusCriteria} from 'src/app/controller/criteria/ReceptionStatusCriteria.model';



@Component({
  selector: 'app-reception-status-edit-admin',
  templateUrl: './reception-status-edit-admin.component.html'
})
export class ReceptionStatusEditAdminComponent extends AbstractEditController<ReceptionStatusDto, ReceptionStatusCriteria, ReceptionStatusService>   implements OnInit {






    constructor( private receptionStatusService: ReceptionStatusService ) {
        super(receptionStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

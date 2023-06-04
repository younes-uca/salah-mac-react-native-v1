import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {DemandStatusService} from 'src/app/controller/service/DemandStatus.service';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {DemandStatusCriteria} from 'src/app/controller/criteria/DemandStatusCriteria.model';



@Component({
  selector: 'app-demand-status-edit-admin',
  templateUrl: './demand-status-edit-admin.component.html'
})
export class DemandStatusEditAdminComponent extends AbstractEditController<DemandStatusDto, DemandStatusCriteria, DemandStatusService>   implements OnInit {






    constructor( private demandStatusService: DemandStatusService ) {
        super(demandStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

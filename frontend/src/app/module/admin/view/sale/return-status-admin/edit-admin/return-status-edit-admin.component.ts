import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusCriteria} from 'src/app/controller/criteria/ReturnStatusCriteria.model';



@Component({
  selector: 'app-return-status-edit-admin',
  templateUrl: './return-status-edit-admin.component.html'
})
export class ReturnStatusEditAdminComponent extends AbstractEditController<ReturnStatusDto, ReturnStatusCriteria, ReturnStatusService>   implements OnInit {






    constructor( private returnStatusService: ReturnStatusService ) {
        super(returnStatusService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

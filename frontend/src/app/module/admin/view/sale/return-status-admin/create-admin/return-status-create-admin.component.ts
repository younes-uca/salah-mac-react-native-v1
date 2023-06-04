import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusCriteria} from 'src/app/controller/criteria/ReturnStatusCriteria.model';
@Component({
  selector: 'app-return-status-create-admin',
  templateUrl: './return-status-create-admin.component.html'
})
export class ReturnStatusCreateAdminComponent extends AbstractCreateController<ReturnStatusDto, ReturnStatusCriteria, ReturnStatusService>  implements OnInit {




    constructor( private returnStatusService: ReturnStatusService ) {
        super(returnStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

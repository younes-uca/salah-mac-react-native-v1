import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SaleStatusService} from 'src/app/controller/service/SaleStatus.service';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {SaleStatusCriteria} from 'src/app/controller/criteria/SaleStatusCriteria.model';
@Component({
  selector: 'app-sale-status-create-admin',
  templateUrl: './sale-status-create-admin.component.html'
})
export class SaleStatusCreateAdminComponent extends AbstractCreateController<SaleStatusDto, SaleStatusCriteria, SaleStatusService>  implements OnInit {




    constructor( private saleStatusService: SaleStatusService ) {
        super(saleStatusService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

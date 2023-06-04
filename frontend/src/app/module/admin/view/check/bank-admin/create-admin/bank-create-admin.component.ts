import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BankService} from 'src/app/controller/service/Bank.service';
import {BankDto} from 'src/app/controller/model/Bank.model';
import {BankCriteria} from 'src/app/controller/criteria/BankCriteria.model';
@Component({
  selector: 'app-bank-create-admin',
  templateUrl: './bank-create-admin.component.html'
})
export class BankCreateAdminComponent extends AbstractCreateController<BankDto, BankCriteria, BankService>  implements OnInit {




    constructor( private bankService: BankService ) {
        super(bankService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {CorporateTaxRateService} from 'src/app/controller/service/CorporateTaxRate.service';
import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {CorporateTaxRateCriteria} from 'src/app/controller/criteria/CorporateTaxRateCriteria.model';
@Component({
  selector: 'app-corporate-tax-rate-create-admin',
  templateUrl: './corporate-tax-rate-create-admin.component.html'
})
export class CorporateTaxRateCreateAdminComponent extends AbstractCreateController<CorporateTaxRateDto, CorporateTaxRateCriteria, CorporateTaxRateService>  implements OnInit {




    constructor( private corporateTaxRateService: CorporateTaxRateService ) {
        super(corporateTaxRateService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

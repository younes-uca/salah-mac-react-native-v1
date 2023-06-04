import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {CorporateTaxRateService} from 'src/app/controller/service/CorporateTaxRate.service';
import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {CorporateTaxRateCriteria} from 'src/app/controller/criteria/CorporateTaxRateCriteria.model';



@Component({
  selector: 'app-corporate-tax-rate-edit-admin',
  templateUrl: './corporate-tax-rate-edit-admin.component.html'
})
export class CorporateTaxRateEditAdminComponent extends AbstractEditController<CorporateTaxRateDto, CorporateTaxRateCriteria, CorporateTaxRateService>   implements OnInit {






    constructor( private corporateTaxRateService: CorporateTaxRateService ) {
        super(corporateTaxRateService);
    }

    ngOnInit(): void {
}
    public prepareEdit() {
        this.item.minApplicationDate = this.corporateTaxRateService.format(this.item.minApplicationDate);
        this.item.maxApplicationDate = this.corporateTaxRateService.format(this.item.maxApplicationDate);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

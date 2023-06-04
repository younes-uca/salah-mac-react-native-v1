import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CorporateTaxRateService} from 'src/app/controller/service/CorporateTaxRate.service';
import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {CorporateTaxRateCriteria} from 'src/app/controller/criteria/CorporateTaxRateCriteria.model';

@Component({
  selector: 'app-corporate-tax-rate-view-admin',
  templateUrl: './corporate-tax-rate-view-admin.component.html'
})
export class CorporateTaxRateViewAdminComponent extends AbstractViewController<CorporateTaxRateDto, CorporateTaxRateCriteria, CorporateTaxRateService> implements OnInit {


    constructor(private corporateTaxRateService: CorporateTaxRateService){
        super(corporateTaxRateService);
    }

    ngOnInit(): void {
    }




}

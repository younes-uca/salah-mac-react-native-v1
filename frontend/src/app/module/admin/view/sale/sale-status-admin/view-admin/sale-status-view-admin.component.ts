import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SaleStatusService} from 'src/app/controller/service/SaleStatus.service';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {SaleStatusCriteria} from 'src/app/controller/criteria/SaleStatusCriteria.model';

@Component({
  selector: 'app-sale-status-view-admin',
  templateUrl: './sale-status-view-admin.component.html'
})
export class SaleStatusViewAdminComponent extends AbstractViewController<SaleStatusDto, SaleStatusCriteria, SaleStatusService> implements OnInit {


    constructor(private saleStatusService: SaleStatusService){
        super(saleStatusService);
    }

    ngOnInit(): void {
    }




}

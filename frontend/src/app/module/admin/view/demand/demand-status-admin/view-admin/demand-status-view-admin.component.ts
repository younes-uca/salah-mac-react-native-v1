import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DemandStatusService} from 'src/app/controller/service/DemandStatus.service';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {DemandStatusCriteria} from 'src/app/controller/criteria/DemandStatusCriteria.model';

@Component({
  selector: 'app-demand-status-view-admin',
  templateUrl: './demand-status-view-admin.component.html'
})
export class DemandStatusViewAdminComponent extends AbstractViewController<DemandStatusDto, DemandStatusCriteria, DemandStatusService> implements OnInit {


    constructor(private demandStatusService: DemandStatusService){
        super(demandStatusService);
    }

    ngOnInit(): void {
    }




}

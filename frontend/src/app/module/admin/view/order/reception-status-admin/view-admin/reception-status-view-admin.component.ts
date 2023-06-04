import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusCriteria} from 'src/app/controller/criteria/ReceptionStatusCriteria.model';

@Component({
  selector: 'app-reception-status-view-admin',
  templateUrl: './reception-status-view-admin.component.html'
})
export class ReceptionStatusViewAdminComponent extends AbstractViewController<ReceptionStatusDto, ReceptionStatusCriteria, ReceptionStatusService> implements OnInit {


    constructor(private receptionStatusService: ReceptionStatusService){
        super(receptionStatusService);
    }

    ngOnInit(): void {
    }




}

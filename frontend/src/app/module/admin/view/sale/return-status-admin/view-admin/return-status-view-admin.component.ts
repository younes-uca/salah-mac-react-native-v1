import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusCriteria} from 'src/app/controller/criteria/ReturnStatusCriteria.model';

@Component({
  selector: 'app-return-status-view-admin',
  templateUrl: './return-status-view-admin.component.html'
})
export class ReturnStatusViewAdminComponent extends AbstractViewController<ReturnStatusDto, ReturnStatusCriteria, ReturnStatusService> implements OnInit {


    constructor(private returnStatusService: ReturnStatusService){
        super(returnStatusService);
    }

    ngOnInit(): void {
    }




}

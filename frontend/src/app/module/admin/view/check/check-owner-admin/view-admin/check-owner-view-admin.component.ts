import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerCriteria} from 'src/app/controller/criteria/CheckOwnerCriteria.model';

@Component({
  selector: 'app-check-owner-view-admin',
  templateUrl: './check-owner-view-admin.component.html'
})
export class CheckOwnerViewAdminComponent extends AbstractViewController<CheckOwnerDto, CheckOwnerCriteria, CheckOwnerService> implements OnInit {


    constructor(private checkOwnerService: CheckOwnerService){
        super(checkOwnerService);
    }

    ngOnInit(): void {
    }




}

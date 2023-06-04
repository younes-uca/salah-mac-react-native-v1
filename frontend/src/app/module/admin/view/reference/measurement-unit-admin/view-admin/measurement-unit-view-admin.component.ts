import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {MeasurementUnitService} from 'src/app/controller/service/MeasurementUnit.service';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';
import {MeasurementUnitCriteria} from 'src/app/controller/criteria/MeasurementUnitCriteria.model';

@Component({
  selector: 'app-measurement-unit-view-admin',
  templateUrl: './measurement-unit-view-admin.component.html'
})
export class MeasurementUnitViewAdminComponent extends AbstractViewController<MeasurementUnitDto, MeasurementUnitCriteria, MeasurementUnitService> implements OnInit {


    constructor(private measurementUnitService: MeasurementUnitService){
        super(measurementUnitService);
    }

    ngOnInit(): void {
    }




}

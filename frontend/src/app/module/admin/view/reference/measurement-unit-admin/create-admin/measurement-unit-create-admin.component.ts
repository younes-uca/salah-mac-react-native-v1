import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {MeasurementUnitService} from 'src/app/controller/service/MeasurementUnit.service';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';
import {MeasurementUnitCriteria} from 'src/app/controller/criteria/MeasurementUnitCriteria.model';
@Component({
  selector: 'app-measurement-unit-create-admin',
  templateUrl: './measurement-unit-create-admin.component.html'
})
export class MeasurementUnitCreateAdminComponent extends AbstractCreateController<MeasurementUnitDto, MeasurementUnitCriteria, MeasurementUnitService>  implements OnInit {




    constructor( private measurementUnitService: MeasurementUnitService ) {
        super(measurementUnitService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

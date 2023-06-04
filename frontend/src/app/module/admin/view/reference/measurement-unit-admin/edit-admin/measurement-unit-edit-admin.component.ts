import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {MeasurementUnitService} from 'src/app/controller/service/MeasurementUnit.service';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';
import {MeasurementUnitCriteria} from 'src/app/controller/criteria/MeasurementUnitCriteria.model';



@Component({
  selector: 'app-measurement-unit-edit-admin',
  templateUrl: './measurement-unit-edit-admin.component.html'
})
export class MeasurementUnitEditAdminComponent extends AbstractEditController<MeasurementUnitDto, MeasurementUnitCriteria, MeasurementUnitService>   implements OnInit {






    constructor( private measurementUnitService: MeasurementUnitService ) {
        super(measurementUnitService);
    }

    ngOnInit(): void {
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }







}

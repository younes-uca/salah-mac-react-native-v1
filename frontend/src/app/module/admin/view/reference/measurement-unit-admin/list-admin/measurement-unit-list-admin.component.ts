import {Component, OnInit} from '@angular/core';
import {MeasurementUnitService} from 'src/app/controller/service/MeasurementUnit.service';
import {MeasurementUnitDto} from 'src/app/controller/model/MeasurementUnit.model';
import {MeasurementUnitCriteria} from 'src/app/controller/criteria/MeasurementUnitCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-measurement-unit-list-admin',
  templateUrl: './measurement-unit-list-admin.component.html'
})
export class MeasurementUnitListAdminComponent extends AbstractListController<MeasurementUnitDto, MeasurementUnitCriteria, MeasurementUnitService>  implements OnInit {

    fileName = 'MeasurementUnit';

  
    constructor(measurementUnitService: MeasurementUnitService) {
        super(measurementUnitService);
        this.pdfName='MeasurementUnit.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadMeasurementUnits(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('MeasurementUnit', 'list');
        isPermistted ? this.service.findAll().subscribe(measurementUnits => this.items = measurementUnits,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: MeasurementUnitDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}

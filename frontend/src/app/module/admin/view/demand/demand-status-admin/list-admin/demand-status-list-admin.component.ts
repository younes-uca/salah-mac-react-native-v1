import {Component, OnInit} from '@angular/core';
import {DemandStatusService} from 'src/app/controller/service/DemandStatus.service';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {DemandStatusCriteria} from 'src/app/controller/criteria/DemandStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-demand-status-list-admin',
  templateUrl: './demand-status-list-admin.component.html'
})
export class DemandStatusListAdminComponent extends AbstractListController<DemandStatusDto, DemandStatusCriteria, DemandStatusService>  implements OnInit {

    fileName = 'DemandStatus';

  
    constructor(demandStatusService: DemandStatusService) {
        super(demandStatusService);
        this.pdfName='DemandStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadDemandStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DemandStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(demandStatuss => this.items = demandStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: DemandStatusDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
                 'Style': e.style ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Style': this.criteria.style ? this.criteria.style : environment.emptyForExport ,
        }];
      }
}

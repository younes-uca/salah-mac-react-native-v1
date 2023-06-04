import {Component, OnInit} from '@angular/core';
import {ReceptionStatusService} from 'src/app/controller/service/ReceptionStatus.service';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionStatusCriteria} from 'src/app/controller/criteria/ReceptionStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-reception-status-list-admin',
  templateUrl: './reception-status-list-admin.component.html'
})
export class ReceptionStatusListAdminComponent extends AbstractListController<ReceptionStatusDto, ReceptionStatusCriteria, ReceptionStatusService>  implements OnInit {

    fileName = 'ReceptionStatus';

  
    constructor(receptionStatusService: ReceptionStatusService) {
        super(receptionStatusService);
        this.pdfName='ReceptionStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadReceptionStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ReceptionStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(receptionStatuss => this.items = receptionStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: ReceptionStatusDto) {
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

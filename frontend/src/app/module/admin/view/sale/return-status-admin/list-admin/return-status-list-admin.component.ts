import {Component, OnInit} from '@angular/core';
import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusCriteria} from 'src/app/controller/criteria/ReturnStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-return-status-list-admin',
  templateUrl: './return-status-list-admin.component.html'
})
export class ReturnStatusListAdminComponent extends AbstractListController<ReturnStatusDto, ReturnStatusCriteria, ReturnStatusService>  implements OnInit {

    fileName = 'ReturnStatus';

  
    constructor(returnStatusService: ReturnStatusService) {
        super(returnStatusService);
        this.pdfName='ReturnStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadReturnStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ReturnStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(returnStatuss => this.items = returnStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: ReturnStatusDto) {
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

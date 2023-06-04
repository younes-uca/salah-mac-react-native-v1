import {Component, OnInit} from '@angular/core';
import {SaleStatusService} from 'src/app/controller/service/SaleStatus.service';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {SaleStatusCriteria} from 'src/app/controller/criteria/SaleStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-sale-status-list-admin',
  templateUrl: './sale-status-list-admin.component.html'
})
export class SaleStatusListAdminComponent extends AbstractListController<SaleStatusDto, SaleStatusCriteria, SaleStatusService>  implements OnInit {

    fileName = 'SaleStatus';

  
    constructor(saleStatusService: SaleStatusService) {
        super(saleStatusService);
        this.pdfName='SaleStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadSaleStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SaleStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(saleStatuss => this.items = saleStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: SaleStatusDto) {
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

import {Component, OnInit} from '@angular/core';
import {StatusPaymentDemandService} from 'src/app/controller/service/StatusPaymentDemand.service';
import {StatusPaymentDemandDto} from 'src/app/controller/model/StatusPaymentDemand.model';
import {StatusPaymentDemandCriteria} from 'src/app/controller/criteria/StatusPaymentDemandCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-status-payment-demand-list-admin',
  templateUrl: './status-payment-demand-list-admin.component.html'
})
export class StatusPaymentDemandListAdminComponent extends AbstractListController<StatusPaymentDemandDto, StatusPaymentDemandCriteria, StatusPaymentDemandService>  implements OnInit {

    fileName = 'StatusPaymentDemand';

  
    constructor(statusPaymentDemandService: StatusPaymentDemandService) {
        super(statusPaymentDemandService);
        this.pdfName='StatusPaymentDemand.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadStatusPaymentDemands(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('StatusPaymentDemand', 'list');
        isPermistted ? this.service.findAll().subscribe(statusPaymentDemands => this.items = statusPaymentDemands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: StatusPaymentDemandDto) {
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

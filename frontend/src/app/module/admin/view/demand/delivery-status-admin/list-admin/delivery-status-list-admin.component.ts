import {Component, OnInit} from '@angular/core';
import {DeliveryStatusService} from 'src/app/controller/service/DeliveryStatus.service';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {DeliveryStatusCriteria} from 'src/app/controller/criteria/DeliveryStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-delivery-status-list-admin',
  templateUrl: './delivery-status-list-admin.component.html'
})
export class DeliveryStatusListAdminComponent extends AbstractListController<DeliveryStatusDto, DeliveryStatusCriteria, DeliveryStatusService>  implements OnInit {

    fileName = 'DeliveryStatus';

  
    constructor(deliveryStatusService: DeliveryStatusService) {
        super(deliveryStatusService);
        this.pdfName='DeliveryStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadDeliveryStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DeliveryStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(deliveryStatuss => this.items = deliveryStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: DeliveryStatusDto) {
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

import {Component, OnInit} from '@angular/core';
import {OrderStatusService} from 'src/app/controller/service/OrderStatus.service';
import {OrderStatusDto} from 'src/app/controller/model/OrderStatus.model';
import {OrderStatusCriteria} from 'src/app/controller/criteria/OrderStatusCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-order-status-list-admin',
  templateUrl: './order-status-list-admin.component.html'
})
export class OrderStatusListAdminComponent extends AbstractListController<OrderStatusDto, OrderStatusCriteria, OrderStatusService>  implements OnInit {

    fileName = 'OrderStatus';

  
    constructor(orderStatusService: OrderStatusService) {
        super(orderStatusService);
        this.pdfName='OrderStatus.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadOrderStatuss(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderStatus', 'list');
        isPermistted ? this.service.findAll().subscribe(orderStatuss => this.items = orderStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: OrderStatusDto) {
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

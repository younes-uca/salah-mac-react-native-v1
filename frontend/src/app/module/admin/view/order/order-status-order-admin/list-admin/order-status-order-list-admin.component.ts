import {Component, OnInit} from '@angular/core';
import {OrderStatusOrderService} from 'src/app/controller/service/OrderStatusOrder.service';
import {OrderStatusOrderDto} from 'src/app/controller/model/OrderStatusOrder.model';
import {OrderStatusOrderCriteria} from 'src/app/controller/criteria/OrderStatusOrderCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-order-status-order-list-admin',
  templateUrl: './order-status-order-list-admin.component.html'
})
export class OrderStatusOrderListAdminComponent extends AbstractListController<OrderStatusOrderDto, OrderStatusOrderCriteria, OrderStatusOrderService>  implements OnInit {

    fileName = 'OrderStatusOrder';

  
    constructor(orderStatusOrderService: OrderStatusOrderService) {
        super(orderStatusOrderService);
        this.pdfName='OrderStatusOrder.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadOrderStatusOrders(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderStatusOrder', 'list');
        isPermistted ? this.service.findAll().subscribe(orderStatusOrders => this.items = orderStatusOrders,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
            {field: 'style', header: 'Style'},
        ];
    }



	public initDuplicate(res: OrderStatusOrderDto) {
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

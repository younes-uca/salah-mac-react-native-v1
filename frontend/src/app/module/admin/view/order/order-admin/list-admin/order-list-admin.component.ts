import {Component, OnInit} from '@angular/core';
import {OrderService} from 'src/app/controller/service/Order.service';
import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderCriteria} from 'src/app/controller/criteria/OrderCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClientService } from 'src/app/controller/service/Client.service';
import { OrderStatusService } from 'src/app/controller/service/OrderStatus.service';

import {OrderItemDto} from 'src/app/controller/model/OrderItem.model';
import {ClientDto} from 'src/app/controller/model/Client.model';
import {OrderStatusDto} from 'src/app/controller/model/OrderStatus.model';


@Component({
  selector: 'app-order-list-admin',
  templateUrl: './order-list-admin.component.html'
})
export class OrderListAdminComponent extends AbstractListController<OrderDto, OrderCriteria, OrderService>  implements OnInit {

    fileName = 'Order';

    clients :Array<ClientDto>;
    orderStatuss :Array<OrderStatusDto>;
  
    constructor(orderService: OrderService, private clientService: ClientService, private orderStatusService: OrderStatusService) {
        super(orderService);
        this.pdfName='Order.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClient();
      this.loadOrderStatus();
    }

    public async loadOrders(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Order', 'list');
        isPermistted ? this.service.findAll().subscribe(orders => this.items = orders,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'orderDate', header: 'Order date'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaid', header: 'Total paid'},
            {field: 'totalPaidCheck', header: 'Total paid check'},
            {field: 'totalPaidCash', header: 'Total paid cash'},
            {field: 'client?.name', header: 'Client'},
            {field: 'orderStatus?.libelle', header: 'Order status'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Order', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadOrderStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Order', 'list');
        isPermistted ? this.orderStatusService.findAllOptimized().subscribe(orderStatuss => this.orderStatuss = orderStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: OrderDto) {
        if (res.orderItems != null) {
             res.orderItems.forEach(d => { d.order = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Order date': this.datePipe.transform(e.orderDate , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Total paid': e.totalPaid ,
                 'Total paid check': e.totalPaidCheck ,
                 'Total paid cash': e.totalPaidCash ,
                'Client': e.client?.name ,
                'Order status': e.orderStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Order date Min': this.criteria.orderDateFrom ? this.datePipe.transform(this.criteria.orderDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Order date Max': this.criteria.orderDateTo ? this.datePipe.transform(this.criteria.orderDateTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paid Min': this.criteria.totalPaidMin ? this.criteria.totalPaidMin : environment.emptyForExport ,
            'Total paid Max': this.criteria.totalPaidMax ? this.criteria.totalPaidMax : environment.emptyForExport ,
            'Total paid check Min': this.criteria.totalPaidCheckMin ? this.criteria.totalPaidCheckMin : environment.emptyForExport ,
            'Total paid check Max': this.criteria.totalPaidCheckMax ? this.criteria.totalPaidCheckMax : environment.emptyForExport ,
            'Total paid cash Min': this.criteria.totalPaidCashMin ? this.criteria.totalPaidCashMin : environment.emptyForExport ,
            'Total paid cash Max': this.criteria.totalPaidCashMax ? this.criteria.totalPaidCashMax : environment.emptyForExport ,
        //'Client': this.criteria.client?.name ? this.criteria.client?.name : environment.emptyForExport ,
        //'Order status': this.criteria.orderStatus?.libelle ? this.criteria.orderStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

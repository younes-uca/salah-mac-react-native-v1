import {Component, OnInit} from '@angular/core';
import {OrderPaymentService} from 'src/app/controller/service/OrderPayment.service';
import {OrderPaymentDto} from 'src/app/controller/model/OrderPayment.model';
import {OrderPaymentCriteria} from 'src/app/controller/criteria/OrderPaymentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { OrderService } from 'src/app/controller/service/Order.service';
import { PaymentModeService } from 'src/app/controller/service/PaymentMode.service';
import { OrderStatusOrderService } from 'src/app/controller/service/OrderStatusOrder.service';

import {OrderDto} from 'src/app/controller/model/Order.model';
import {OrderStatusOrderDto} from 'src/app/controller/model/OrderStatusOrder.model';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';


@Component({
  selector: 'app-order-payment-list-admin',
  templateUrl: './order-payment-list-admin.component.html'
})
export class OrderPaymentListAdminComponent extends AbstractListController<OrderPaymentDto, OrderPaymentCriteria, OrderPaymentService>  implements OnInit {

    fileName = 'OrderPayment';

     yesOrNoVireCheck :any[] =[];
    orders :Array<OrderDto>;
    paymentModes :Array<PaymentModeDto>;
    orderStatusOrders :Array<OrderStatusOrderDto>;
  
    constructor(orderPaymentService: OrderPaymentService, private orderService: OrderService, private paymentModeService: PaymentModeService, private orderStatusOrderService: OrderStatusOrderService) {
        super(orderPaymentService);
        this.pdfName='OrderPayment.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadOrder();
      this.loadPaymentMode();
      this.loadOrderStatusOrder();
    this.yesOrNoVireCheck =  [{label: 'VireCheck', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadOrderPayments(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderPayment', 'list');
        isPermistted ? this.service.findAll().subscribe(orderPayments => this.items = orderPayments,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'paymentDate', header: 'Payment date'},
            {field: 'amount', header: 'Amount'},
            {field: 'order?.reference', header: 'Order'},
            {field: 'paymentMode?.libelle', header: 'Payment mode'},
            {field: 'vireCheck', header: 'Vire check'},
            {field: 'orderStatusOrder?.libelle', header: 'Order status order'},
        ];
    }


    public async loadOrder(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderPayment', 'list');
        isPermistted ? this.orderService.findAllOptimized().subscribe(orders => this.orders = orders,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentMode(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderPayment', 'list');
        isPermistted ? this.paymentModeService.findAllOptimized().subscribe(paymentModes => this.paymentModes = paymentModes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadOrderStatusOrder(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('OrderPayment', 'list');
        isPermistted ? this.orderStatusOrderService.findAllOptimized().subscribe(orderStatusOrders => this.orderStatusOrders = orderStatusOrders,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: OrderPaymentDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Payment date': this.datePipe.transform(e.paymentDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Order': e.order?.reference ,
                'Payment mode': e.paymentMode?.libelle ,
                 'Description': e.description ,
                'Vire check': e.vireCheck? 'Vrai' : 'Faux' ,
                'Order status order': e.orderStatusOrder?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Payment date Min': this.criteria.paymentDateFrom ? this.datePipe.transform(this.criteria.paymentDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Payment date Max': this.criteria.paymentDateTo ? this.datePipe.transform(this.criteria.paymentDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Order': this.criteria.order?.reference ? this.criteria.order?.reference : environment.emptyForExport ,
        //'Payment mode': this.criteria.paymentMode?.libelle ? this.criteria.paymentMode?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Vire check': this.criteria.vireCheck ? (this.criteria.vireCheck ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Order status order': this.criteria.orderStatusOrder?.libelle ? this.criteria.orderStatusOrder?.libelle : environment.emptyForExport ,
        }];
      }
}

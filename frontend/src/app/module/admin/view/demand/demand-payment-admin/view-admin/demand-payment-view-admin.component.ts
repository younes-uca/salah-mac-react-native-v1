import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {DemandPaymentService} from 'src/app/controller/service/DemandPayment.service';
import {DemandPaymentDto} from 'src/app/controller/model/DemandPayment.model';
import {DemandPaymentCriteria} from 'src/app/controller/criteria/DemandPaymentCriteria.model';

import {StatusPaymentDemandDto} from 'src/app/controller/model/StatusPaymentDemand.model';
import {StatusPaymentDemandService} from 'src/app/controller/service/StatusPaymentDemand.service';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';
import {PaymentModeService} from 'src/app/controller/service/PaymentMode.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandService} from 'src/app/controller/service/Demand.service';
@Component({
  selector: 'app-demand-payment-view-admin',
  templateUrl: './demand-payment-view-admin.component.html'
})
export class DemandPaymentViewAdminComponent extends AbstractViewController<DemandPaymentDto, DemandPaymentCriteria, DemandPaymentService> implements OnInit {


    constructor(private demandPaymentService: DemandPaymentService, private statusPaymentDemandService: StatusPaymentDemandService, private paymentModeService: PaymentModeService, private demandService: DemandService){
        super(demandPaymentService);
    }

    ngOnInit(): void {
        this.demand = new DemandDto();
        this.demandService.findAll().subscribe((data) => this.demands = data);
        this.paymentMode = new PaymentModeDto();
        this.paymentModeService.findAll().subscribe((data) => this.paymentModes = data);
        this.statusPaymentDemand = new StatusPaymentDemandDto();
        this.statusPaymentDemandService.findAll().subscribe((data) => this.statusPaymentDemands = data);
    }


    get demand(): DemandDto {
       return this.demandService.item;
    }
    set demand(value: DemandDto) {
        this.demandService.item = value;
    }
    get demands():Array<DemandDto> {
       return this.demandService.items;
    }
    set demands(value: Array<DemandDto>) {
        this.demandService.items = value;
    }
    get paymentMode(): PaymentModeDto {
       return this.paymentModeService.item;
    }
    set paymentMode(value: PaymentModeDto) {
        this.paymentModeService.item = value;
    }
    get paymentModes():Array<PaymentModeDto> {
       return this.paymentModeService.items;
    }
    set paymentModes(value: Array<PaymentModeDto>) {
        this.paymentModeService.items = value;
    }
    get statusPaymentDemand(): StatusPaymentDemandDto {
       return this.statusPaymentDemandService.item;
    }
    set statusPaymentDemand(value: StatusPaymentDemandDto) {
        this.statusPaymentDemandService.item = value;
    }
    get statusPaymentDemands():Array<StatusPaymentDemandDto> {
       return this.statusPaymentDemandService.items;
    }
    set statusPaymentDemands(value: Array<StatusPaymentDemandDto>) {
        this.statusPaymentDemandService.items = value;
    }


}

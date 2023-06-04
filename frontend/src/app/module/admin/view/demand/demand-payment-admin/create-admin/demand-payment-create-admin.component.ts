import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

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
  selector: 'app-demand-payment-create-admin',
  templateUrl: './demand-payment-create-admin.component.html'
})
export class DemandPaymentCreateAdminComponent extends AbstractCreateController<DemandPaymentDto, DemandPaymentCriteria, DemandPaymentService>  implements OnInit {



    private _validStatusPaymentDemandLibelle = true;
    private _validStatusPaymentDemandCode = true;

    constructor( private demandPaymentService: DemandPaymentService , private statusPaymentDemandService: StatusPaymentDemandService, private paymentModeService: PaymentModeService, private demandService: DemandService) {
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





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateDemand(demand: string) {
    const isPermistted = await this.roleService.isPermitted('Demand', 'add');
    if(isPermistted) {
         this.demand = new DemandDto();
         this.createDemandDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get demand(): DemandDto {
        return this.demandService.item;
    }
    set demand(value: DemandDto) {
        this.demandService.item = value;
    }
    get demands(): Array<DemandDto> {
        return this.demandService.items;
    }
    set demands(value: Array<DemandDto>) {
        this.demandService.items = value;
    }
    get createDemandDialog(): boolean {
       return this.demandService.createDialog;
    }
    set createDemandDialog(value: boolean) {
        this.demandService.createDialog= value;
    }
    get paymentMode(): PaymentModeDto {
        return this.paymentModeService.item;
    }
    set paymentMode(value: PaymentModeDto) {
        this.paymentModeService.item = value;
    }
    get paymentModes(): Array<PaymentModeDto> {
        return this.paymentModeService.items;
    }
    set paymentModes(value: Array<PaymentModeDto>) {
        this.paymentModeService.items = value;
    }
    get createPaymentModeDialog(): boolean {
       return this.paymentModeService.createDialog;
    }
    set createPaymentModeDialog(value: boolean) {
        this.paymentModeService.createDialog= value;
    }
    get statusPaymentDemand(): StatusPaymentDemandDto {
        return this.statusPaymentDemandService.item;
    }
    set statusPaymentDemand(value: StatusPaymentDemandDto) {
        this.statusPaymentDemandService.item = value;
    }
    get statusPaymentDemands(): Array<StatusPaymentDemandDto> {
        return this.statusPaymentDemandService.items;
    }
    set statusPaymentDemands(value: Array<StatusPaymentDemandDto>) {
        this.statusPaymentDemandService.items = value;
    }
    get createStatusPaymentDemandDialog(): boolean {
       return this.statusPaymentDemandService.createDialog;
    }
    set createStatusPaymentDemandDialog(value: boolean) {
        this.statusPaymentDemandService.createDialog= value;
    }




    get validStatusPaymentDemandLibelle(): boolean {
        return this._validStatusPaymentDemandLibelle;
    }
    set validStatusPaymentDemandLibelle(value: boolean) {
        this._validStatusPaymentDemandLibelle = value;
    }
    get validStatusPaymentDemandCode(): boolean {
        return this._validStatusPaymentDemandCode;
    }
    set validStatusPaymentDemandCode(value: boolean) {
        this._validStatusPaymentDemandCode = value;
    }


}

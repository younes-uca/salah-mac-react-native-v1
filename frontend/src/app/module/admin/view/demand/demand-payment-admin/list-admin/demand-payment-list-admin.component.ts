import {Component, OnInit} from '@angular/core';
import {DemandPaymentService} from 'src/app/controller/service/DemandPayment.service';
import {DemandPaymentDto} from 'src/app/controller/model/DemandPayment.model';
import {DemandPaymentCriteria} from 'src/app/controller/criteria/DemandPaymentCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { DemandService } from 'src/app/controller/service/Demand.service';
import { PaymentModeService } from 'src/app/controller/service/PaymentMode.service';
import { StatusPaymentDemandService } from 'src/app/controller/service/StatusPaymentDemand.service';

import {DemandDto} from 'src/app/controller/model/Demand.model';
import {StatusPaymentDemandDto} from 'src/app/controller/model/StatusPaymentDemand.model';
import {PaymentModeDto} from 'src/app/controller/model/PaymentMode.model';


@Component({
  selector: 'app-demand-payment-list-admin',
  templateUrl: './demand-payment-list-admin.component.html'
})
export class DemandPaymentListAdminComponent extends AbstractListController<DemandPaymentDto, DemandPaymentCriteria, DemandPaymentService>  implements OnInit {

    fileName = 'DemandPayment';

     yesOrNoVireCheck :any[] =[];
    demands :Array<DemandDto>;
    paymentModes :Array<PaymentModeDto>;
    statusPaymentDemands :Array<StatusPaymentDemandDto>;
  
    constructor(demandPaymentService: DemandPaymentService, private demandService: DemandService, private paymentModeService: PaymentModeService, private statusPaymentDemandService: StatusPaymentDemandService) {
        super(demandPaymentService);
        this.pdfName='DemandPayment.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDemand();
      this.loadPaymentMode();
      this.loadStatusPaymentDemand();
    this.yesOrNoVireCheck =  [{label: 'VireCheck', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadDemandPayments(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DemandPayment', 'list');
        isPermistted ? this.service.findAll().subscribe(demandPayments => this.items = demandPayments,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'paymentDate', header: 'Payment date'},
            {field: 'amount', header: 'Amount'},
            {field: 'demand?.reference', header: 'Demand'},
            {field: 'paymentMode?.libelle', header: 'Payment mode'},
            {field: 'vireCheck', header: 'Vire check'},
            {field: 'statusPaymentDemand?.libelle', header: 'Status payment demand'},
        ];
    }


    public async loadDemand(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DemandPayment', 'list');
        isPermistted ? this.demandService.findAllOptimized().subscribe(demands => this.demands = demands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPaymentMode(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DemandPayment', 'list');
        isPermistted ? this.paymentModeService.findAllOptimized().subscribe(paymentModes => this.paymentModes = paymentModes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadStatusPaymentDemand(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('DemandPayment', 'list');
        isPermistted ? this.statusPaymentDemandService.findAllOptimized().subscribe(statusPaymentDemands => this.statusPaymentDemands = statusPaymentDemands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DemandPaymentDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Payment date': this.datePipe.transform(e.paymentDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Demand': e.demand?.reference ,
                'Payment mode': e.paymentMode?.libelle ,
                 'Description': e.description ,
                'Vire check': e.vireCheck? 'Vrai' : 'Faux' ,
                'Status payment demand': e.statusPaymentDemand?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Payment date Min': this.criteria.paymentDateFrom ? this.datePipe.transform(this.criteria.paymentDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Payment date Max': this.criteria.paymentDateTo ? this.datePipe.transform(this.criteria.paymentDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Demand': this.criteria.demand?.reference ? this.criteria.demand?.reference : environment.emptyForExport ,
        //'Payment mode': this.criteria.paymentMode?.libelle ? this.criteria.paymentMode?.libelle : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Vire check': this.criteria.vireCheck ? (this.criteria.vireCheck ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Status payment demand': this.criteria.statusPaymentDemand?.libelle ? this.criteria.statusPaymentDemand?.libelle : environment.emptyForExport ,
        }];
      }
}

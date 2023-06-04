import {Component, OnInit} from '@angular/core';
import {DemandService} from 'src/app/controller/service/Demand.service';
import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DemandCriteria} from 'src/app/controller/criteria/DemandCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ClientService } from 'src/app/controller/service/Client.service';
import { DemandStatusService } from 'src/app/controller/service/DemandStatus.service';

import {DemandItemDto} from 'src/app/controller/model/DemandItem.model';
import {DemandStatusDto} from 'src/app/controller/model/DemandStatus.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-demand-list-admin',
  templateUrl: './demand-list-admin.component.html'
})
export class DemandListAdminComponent extends AbstractListController<DemandDto, DemandCriteria, DemandService>  implements OnInit {

    fileName = 'Demand';

    clients :Array<ClientDto>;
    demandStatuss :Array<DemandStatusDto>;
  
    constructor(demandService: DemandService, private clientService: ClientService, private demandStatusService: DemandStatusService) {
        super(demandService);
        this.pdfName='Demand.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadClient();
      this.loadDemandStatus();
    }

    public async loadDemands(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demand', 'list');
        isPermistted ? this.service.findAll().subscribe(demands => this.items = demands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'demandDate', header: 'Demand date'},
            {field: 'totalCheck', header: 'Total check'},
            {field: 'totalCash', header: 'Total cash'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaid', header: 'Total paid'},
            {field: 'client?.name', header: 'Client'},
            {field: 'demandStatus?.libelle', header: 'Demand status'},
        ];
    }


    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demand', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadDemandStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Demand', 'list');
        isPermistted ? this.demandStatusService.findAllOptimized().subscribe(demandStatuss => this.demandStatuss = demandStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DemandDto) {
        if (res.demandItems != null) {
             res.demandItems.forEach(d => { d.demand = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Demand date': this.datePipe.transform(e.demandDate , 'dd/MM/yyyy hh:mm'),
                 'Total check': e.totalCheck ,
                 'Total cash': e.totalCash ,
                 'Total': e.total ,
                 'Total paid': e.totalPaid ,
                'Client': e.client?.name ,
                'Demand status': e.demandStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Demand date Min': this.criteria.demandDateFrom ? this.datePipe.transform(this.criteria.demandDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Demand date Max': this.criteria.demandDateTo ? this.datePipe.transform(this.criteria.demandDateTo , this.dateFormat) : environment.emptyForExport ,
            'Total check Min': this.criteria.totalCheckMin ? this.criteria.totalCheckMin : environment.emptyForExport ,
            'Total check Max': this.criteria.totalCheckMax ? this.criteria.totalCheckMax : environment.emptyForExport ,
            'Total cash Min': this.criteria.totalCashMin ? this.criteria.totalCashMin : environment.emptyForExport ,
            'Total cash Max': this.criteria.totalCashMax ? this.criteria.totalCashMax : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paid Min': this.criteria.totalPaidMin ? this.criteria.totalPaidMin : environment.emptyForExport ,
            'Total paid Max': this.criteria.totalPaidMax ? this.criteria.totalPaidMax : environment.emptyForExport ,
        //'Client': this.criteria.client?.name ? this.criteria.client?.name : environment.emptyForExport ,
        //'Demand status': this.criteria.demandStatus?.libelle ? this.criteria.demandStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

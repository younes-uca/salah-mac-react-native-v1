import {Component, OnInit} from '@angular/core';
import {DeliveryService} from 'src/app/controller/service/Delivery.service';
import {DeliveryDto} from 'src/app/controller/model/Delivery.model';
import {DeliveryCriteria} from 'src/app/controller/criteria/DeliveryCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { DemandService } from 'src/app/controller/service/Demand.service';
import { DeliveryStatusService } from 'src/app/controller/service/DeliveryStatus.service';
import { ClientService } from 'src/app/controller/service/Client.service';

import {DemandDto} from 'src/app/controller/model/Demand.model';
import {DeliveryItemDto} from 'src/app/controller/model/DeliveryItem.model';
import {DeliveryStatusDto} from 'src/app/controller/model/DeliveryStatus.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-delivery-list-admin',
  templateUrl: './delivery-list-admin.component.html'
})
export class DeliveryListAdminComponent extends AbstractListController<DeliveryDto, DeliveryCriteria, DeliveryService>  implements OnInit {

    fileName = 'Delivery';

    demands :Array<DemandDto>;
    deliveryStatuss :Array<DeliveryStatusDto>;
    clients :Array<ClientDto>;
  
    constructor(deliveryService: DeliveryService, private demandService: DemandService, private deliveryStatusService: DeliveryStatusService, private clientService: ClientService) {
        super(deliveryService);
        this.pdfName='Delivery.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadDemand();
      this.loadDeliveryStatus();
      this.loadClient();
    }

    public async loadDeliverys(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Delivery', 'list');
        isPermistted ? this.service.findAll().subscribe(deliverys => this.items = deliverys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'demand?.reference', header: 'Demand'},
            {field: 'deliveryDate', header: 'Delivery date'},
            {field: 'deliveryStatus?.libelle', header: 'Delivery status'},
            {field: 'client?.name', header: 'Client'},
        ];
    }


    public async loadDemand(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Delivery', 'list');
        isPermistted ? this.demandService.findAllOptimized().subscribe(demands => this.demands = demands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadDeliveryStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Delivery', 'list');
        isPermistted ? this.deliveryStatusService.findAllOptimized().subscribe(deliveryStatuss => this.deliveryStatuss = deliveryStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Delivery', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: DeliveryDto) {
        if (res.deliveryItems != null) {
             res.deliveryItems.forEach(d => { d.delivery = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Demand': e.demand?.reference ,
                'Delivery date': this.datePipe.transform(e.deliveryDate , 'dd/MM/yyyy hh:mm'),
                'Delivery status': e.deliveryStatus?.libelle ,
                'Client': e.client?.name ,
            }
        });

        this.criteriaData = [{
        //'Demand': this.criteria.demand?.reference ? this.criteria.demand?.reference : environment.emptyForExport ,
            'Delivery date Min': this.criteria.deliveryDateFrom ? this.datePipe.transform(this.criteria.deliveryDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Delivery date Max': this.criteria.deliveryDateTo ? this.datePipe.transform(this.criteria.deliveryDateTo , this.dateFormat) : environment.emptyForExport ,
        //'Delivery status': this.criteria.deliveryStatus?.libelle ? this.criteria.deliveryStatus?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.name ? this.criteria.client?.name : environment.emptyForExport ,
        }];
      }
}

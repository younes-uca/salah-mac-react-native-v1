import {Component, OnInit} from '@angular/core';
import {SaleService} from 'src/app/controller/service/Sale.service';
import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleCriteria} from 'src/app/controller/criteria/SaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { StoreService } from 'src/app/controller/service/Store.service';
import { ClientService } from 'src/app/controller/service/Client.service';
import { SaleStatusService } from 'src/app/controller/service/SaleStatus.service';

import {SaleItemDto} from 'src/app/controller/model/SaleItem.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {SaleStatusDto} from 'src/app/controller/model/SaleStatus.model';
import {ClientDto} from 'src/app/controller/model/Client.model';


@Component({
  selector: 'app-sale-list-admin',
  templateUrl: './sale-list-admin.component.html'
})
export class SaleListAdminComponent extends AbstractListController<SaleDto, SaleCriteria, SaleService>  implements OnInit {

    fileName = 'Sale';

    stores :Array<StoreDto>;
    clients :Array<ClientDto>;
    saleStatuss :Array<SaleStatusDto>;
  
    constructor(saleService: SaleService, private storeService: StoreService, private clientService: ClientService, private saleStatusService: SaleStatusService) {
        super(saleService);
        this.pdfName='Sale.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadStore();
      this.loadClient();
      this.loadSaleStatus();
    }

    public async loadSales(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Sale', 'list');
        isPermistted ? this.service.findAll().subscribe(sales => this.items = sales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'saleDate', header: 'Sale date'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaid', header: 'Total paid'},
            {field: 'store?.libelle', header: 'Store'},
            {field: 'client?.name', header: 'Client'},
            {field: 'saleStatus?.libelle', header: 'Sale status'},
        ];
    }


    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Sale', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadClient(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Sale', 'list');
        isPermistted ? this.clientService.findAllOptimized().subscribe(clients => this.clients = clients,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadSaleStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Sale', 'list');
        isPermistted ? this.saleStatusService.findAllOptimized().subscribe(saleStatuss => this.saleStatuss = saleStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SaleDto) {
        if (res.saleItems != null) {
             res.saleItems.forEach(d => { d.sale = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Sale date': this.datePipe.transform(e.saleDate , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Total paid': e.totalPaid ,
                 'Description': e.description ,
                'Store': e.store?.libelle ,
                'Client': e.client?.name ,
                'Sale status': e.saleStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Sale date Min': this.criteria.saleDateFrom ? this.datePipe.transform(this.criteria.saleDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Sale date Max': this.criteria.saleDateTo ? this.datePipe.transform(this.criteria.saleDateTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paid Min': this.criteria.totalPaidMin ? this.criteria.totalPaidMin : environment.emptyForExport ,
            'Total paid Max': this.criteria.totalPaidMax ? this.criteria.totalPaidMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        //'Client': this.criteria.client?.name ? this.criteria.client?.name : environment.emptyForExport ,
        //'Sale status': this.criteria.saleStatus?.libelle ? this.criteria.saleStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

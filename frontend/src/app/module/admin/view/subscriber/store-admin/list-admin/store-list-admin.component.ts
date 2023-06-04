import {Component, OnInit} from '@angular/core';
import {StoreService} from 'src/app/controller/service/Store.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreCriteria} from 'src/app/controller/criteria/StoreCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CompanyService } from 'src/app/controller/service/Company.service';

import {CompanyDto} from 'src/app/controller/model/Company.model';


@Component({
  selector: 'app-store-list-admin',
  templateUrl: './store-list-admin.component.html'
})
export class StoreListAdminComponent extends AbstractListController<StoreDto, StoreCriteria, StoreService>  implements OnInit {

    fileName = 'Store';

    companys :Array<CompanyDto>;
  
    constructor(storeService: StoreService, private companyService: CompanyService) {
        super(storeService);
        this.pdfName='Store.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCompany();
    }

    public async loadStores(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Store', 'list');
        isPermistted ? this.service.findAll().subscribe(stores => this.items = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'reference', header: 'Reference'},
            {field: 'company?.ice', header: 'Company'},
        ];
    }


    public async loadCompany(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Store', 'list');
        isPermistted ? this.companyService.findAllOptimized().subscribe(companys => this.companys = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: StoreDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Reference': e.reference ,
                'Company': e.company?.ice ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
        //'Company': this.criteria.company?.ice ? this.criteria.company?.ice : environment.emptyForExport ,
        }];
      }
}

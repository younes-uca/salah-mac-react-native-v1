import {Component, OnInit} from '@angular/core';
import {PurchaseService} from 'src/app/controller/service/Purchase.service';
import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {PurchaseCriteria} from 'src/app/controller/criteria/PurchaseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SupplierService } from 'src/app/controller/service/Supplier.service';
import { StoreService } from 'src/app/controller/service/Store.service';
import { PurchaseStatusService } from 'src/app/controller/service/PurchaseStatus.service';

import {PurchaseStatusDto} from 'src/app/controller/model/PurchaseStatus.model';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {PurchaseItemDto} from 'src/app/controller/model/PurchaseItem.model';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';


@Component({
  selector: 'app-purchase-list-admin',
  templateUrl: './purchase-list-admin.component.html'
})
export class PurchaseListAdminComponent extends AbstractListController<PurchaseDto, PurchaseCriteria, PurchaseService>  implements OnInit {

    fileName = 'Purchase';

    suppliers :Array<SupplierDto>;
    stores :Array<StoreDto>;
    purchaseStatuss :Array<PurchaseStatusDto>;
  
    constructor(purchaseService: PurchaseService, private supplierService: SupplierService, private storeService: StoreService, private purchaseStatusService: PurchaseStatusService) {
        super(purchaseService);
        this.pdfName='Purchase.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSupplier();
      this.loadStore();
      this.loadPurchaseStatus();
    }

    public async loadPurchases(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.service.findAll().subscribe(purchases => this.items = purchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'purchaseDate', header: 'Purchase date'},
            {field: 'total', header: 'Total'},
            {field: 'totalPaid', header: 'Total paid'},
            {field: 'supplier?.name', header: 'Supplier'},
            {field: 'store?.libelle', header: 'Store'},
            {field: 'purchaseStatus?.libelle', header: 'Purchase status'},
        ];
    }


    public async loadSupplier(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.supplierService.findAllOptimized().subscribe(suppliers => this.suppliers = suppliers,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadStore(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.storeService.findAllOptimized().subscribe(stores => this.stores = stores,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadPurchaseStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Purchase', 'list');
        isPermistted ? this.purchaseStatusService.findAllOptimized().subscribe(purchaseStatuss => this.purchaseStatuss = purchaseStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: PurchaseDto) {
        if (res.purchaseItems != null) {
             res.purchaseItems.forEach(d => { d.purchase = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Purchase date': this.datePipe.transform(e.purchaseDate , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Total paid': e.totalPaid ,
                 'Description': e.description ,
                'Supplier': e.supplier?.name ,
                'Store': e.store?.libelle ,
                'Purchase status': e.purchaseStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Purchase date Min': this.criteria.purchaseDateFrom ? this.datePipe.transform(this.criteria.purchaseDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Purchase date Max': this.criteria.purchaseDateTo ? this.datePipe.transform(this.criteria.purchaseDateTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Total paid Min': this.criteria.totalPaidMin ? this.criteria.totalPaidMin : environment.emptyForExport ,
            'Total paid Max': this.criteria.totalPaidMax ? this.criteria.totalPaidMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Supplier': this.criteria.supplier?.name ? this.criteria.supplier?.name : environment.emptyForExport ,
        //'Store': this.criteria.store?.libelle ? this.criteria.store?.libelle : environment.emptyForExport ,
        //'Purchase status': this.criteria.purchaseStatus?.libelle ? this.criteria.purchaseStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

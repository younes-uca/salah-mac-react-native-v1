import {Component, OnInit} from '@angular/core';
import {CreditNotePurchaseService} from 'src/app/controller/service/CreditNotePurchase.service';
import {CreditNotePurchaseDto} from 'src/app/controller/model/CreditNotePurchase.model';
import {CreditNotePurchaseCriteria} from 'src/app/controller/criteria/CreditNotePurchaseCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { PurchaseService } from 'src/app/controller/service/Purchase.service';
import { CreditNotePurchaseStatusService } from 'src/app/controller/service/CreditNotePurchaseStatus.service';

import {PurchaseDto} from 'src/app/controller/model/Purchase.model';
import {CreditNotePurchaseStatusDto} from 'src/app/controller/model/CreditNotePurchaseStatus.model';
import {CreditNotePurchaseItemDto} from 'src/app/controller/model/CreditNotePurchaseItem.model';


@Component({
  selector: 'app-credit-note-purchase-list-admin',
  templateUrl: './credit-note-purchase-list-admin.component.html'
})
export class CreditNotePurchaseListAdminComponent extends AbstractListController<CreditNotePurchaseDto, CreditNotePurchaseCriteria, CreditNotePurchaseService>  implements OnInit {

    fileName = 'CreditNotePurchase';

    purchases :Array<PurchaseDto>;
    creditNotePurchaseStatuss :Array<CreditNotePurchaseStatusDto>;
  
    constructor(creditNotePurchaseService: CreditNotePurchaseService, private purchaseService: PurchaseService, private creditNotePurchaseStatusService: CreditNotePurchaseStatusService) {
        super(creditNotePurchaseService);
        this.pdfName='CreditNotePurchase.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadPurchase();
      this.loadCreditNotePurchaseStatus();
    }

    public async loadCreditNotePurchases(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CreditNotePurchase', 'list');
        isPermistted ? this.service.findAll().subscribe(creditNotePurchases => this.items = creditNotePurchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'creditNoteDate', header: 'Credit note date'},
            {field: 'amount', header: 'Amount'},
            {field: 'purchase?.reference', header: 'Purchase'},
            {field: 'creditNotePurchaseStatus?.libelle', header: 'Credit note purchase status'},
        ];
    }


    public async loadPurchase(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CreditNotePurchase', 'list');
        isPermistted ? this.purchaseService.findAllOptimized().subscribe(purchases => this.purchases = purchases,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadCreditNotePurchaseStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CreditNotePurchase', 'list');
        isPermistted ? this.creditNotePurchaseStatusService.findAllOptimized().subscribe(creditNotePurchaseStatuss => this.creditNotePurchaseStatuss = creditNotePurchaseStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: CreditNotePurchaseDto) {
        if (res.creditNotePurchaseItems != null) {
             res.creditNotePurchaseItems.forEach(d => { d.creditNotePurchase = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Credit note date': this.datePipe.transform(e.creditNoteDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Purchase': e.purchase?.reference ,
                'Credit note purchase status': e.creditNotePurchaseStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Credit note date Min': this.criteria.creditNoteDateFrom ? this.datePipe.transform(this.criteria.creditNoteDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Credit note date Max': this.criteria.creditNoteDateTo ? this.datePipe.transform(this.criteria.creditNoteDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Purchase': this.criteria.purchase?.reference ? this.criteria.purchase?.reference : environment.emptyForExport ,
        //'Credit note purchase status': this.criteria.creditNotePurchaseStatus?.libelle ? this.criteria.creditNotePurchaseStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

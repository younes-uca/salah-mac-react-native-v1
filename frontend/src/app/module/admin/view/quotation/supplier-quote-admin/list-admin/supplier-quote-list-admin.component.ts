import {Component, OnInit} from '@angular/core';
import {SupplierQuoteService} from 'src/app/controller/service/SupplierQuote.service';
import {SupplierQuoteDto} from 'src/app/controller/model/SupplierQuote.model';
import {SupplierQuoteCriteria} from 'src/app/controller/criteria/SupplierQuoteCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SupplierService } from 'src/app/controller/service/Supplier.service';

import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierQuoteItemDto} from 'src/app/controller/model/SupplierQuoteItem.model';


@Component({
  selector: 'app-supplier-quote-list-admin',
  templateUrl: './supplier-quote-list-admin.component.html'
})
export class SupplierQuoteListAdminComponent extends AbstractListController<SupplierQuoteDto, SupplierQuoteCriteria, SupplierQuoteService>  implements OnInit {

    fileName = 'SupplierQuote';

    suppliers :Array<SupplierDto>;
  
    constructor(supplierQuoteService: SupplierQuoteService, private supplierService: SupplierService) {
        super(supplierQuoteService);
        this.pdfName='SupplierQuote.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSupplier();
    }

    public async loadSupplierQuotes(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SupplierQuote', 'list');
        isPermistted ? this.service.findAll().subscribe(supplierQuotes => this.items = supplierQuotes,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'quoteDate', header: 'Quote date'},
            {field: 'total', header: 'Total'},
            {field: 'supplier?.name', header: 'Supplier'},
        ];
    }


    public async loadSupplier(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('SupplierQuote', 'list');
        isPermistted ? this.supplierService.findAllOptimized().subscribe(suppliers => this.suppliers = suppliers,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: SupplierQuoteDto) {
        if (res.supplierQuoteItems != null) {
             res.supplierQuoteItems.forEach(d => { d.supplierQuote = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Quote date': this.datePipe.transform(e.quoteDate , 'dd/MM/yyyy hh:mm'),
                 'Total': e.total ,
                 'Description': e.description ,
                'Supplier': e.supplier?.name ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Quote date Min': this.criteria.quoteDateFrom ? this.datePipe.transform(this.criteria.quoteDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Quote date Max': this.criteria.quoteDateTo ? this.datePipe.transform(this.criteria.quoteDateTo , this.dateFormat) : environment.emptyForExport ,
            'Total Min': this.criteria.totalMin ? this.criteria.totalMin : environment.emptyForExport ,
            'Total Max': this.criteria.totalMax ? this.criteria.totalMax : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Supplier': this.criteria.supplier?.name ? this.criteria.supplier?.name : environment.emptyForExport ,
        }];
      }
}

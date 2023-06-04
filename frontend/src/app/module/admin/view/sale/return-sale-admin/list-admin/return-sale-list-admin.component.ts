import {Component, OnInit} from '@angular/core';
import {ReturnSaleService} from 'src/app/controller/service/ReturnSale.service';
import {ReturnSaleDto} from 'src/app/controller/model/ReturnSale.model';
import {ReturnSaleCriteria} from 'src/app/controller/criteria/ReturnSaleCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SaleService } from 'src/app/controller/service/Sale.service';
import { ReturnStatusService } from 'src/app/controller/service/ReturnStatus.service';

import {SaleDto} from 'src/app/controller/model/Sale.model';
import {ReturnSaleItemDto} from 'src/app/controller/model/ReturnSaleItem.model';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';


@Component({
  selector: 'app-return-sale-list-admin',
  templateUrl: './return-sale-list-admin.component.html'
})
export class ReturnSaleListAdminComponent extends AbstractListController<ReturnSaleDto, ReturnSaleCriteria, ReturnSaleService>  implements OnInit {

    fileName = 'ReturnSale';

    sales :Array<SaleDto>;
    returnStatuss :Array<ReturnStatusDto>;
  
    constructor(returnSaleService: ReturnSaleService, private saleService: SaleService, private returnStatusService: ReturnStatusService) {
        super(returnSaleService);
        this.pdfName='ReturnSale.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSale();
      this.loadReturnStatus();
    }

    public async loadReturnSales(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ReturnSale', 'list');
        isPermistted ? this.service.findAll().subscribe(returnSales => this.items = returnSales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'returnDate', header: 'Return date'},
            {field: 'amount', header: 'Amount'},
            {field: 'sale?.reference', header: 'Sale'},
            {field: 'returnStatus?.libelle', header: 'Return status'},
        ];
    }


    public async loadSale(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ReturnSale', 'list');
        isPermistted ? this.saleService.findAllOptimized().subscribe(sales => this.sales = sales,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadReturnStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ReturnSale', 'list');
        isPermistted ? this.returnStatusService.findAllOptimized().subscribe(returnStatuss => this.returnStatuss = returnStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ReturnSaleDto) {
        if (res.returnSaleItems != null) {
             res.returnSaleItems.forEach(d => { d.returnSale = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Return date': this.datePipe.transform(e.returnDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
                'Sale': e.sale?.reference ,
                'Return status': e.returnStatus?.libelle ,
            }
        });

        this.criteriaData = [{
            'Return date Min': this.criteria.returnDateFrom ? this.datePipe.transform(this.criteria.returnDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Return date Max': this.criteria.returnDateTo ? this.datePipe.transform(this.criteria.returnDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        //'Sale': this.criteria.sale?.reference ? this.criteria.sale?.reference : environment.emptyForExport ,
        //'Return status': this.criteria.returnStatus?.libelle ? this.criteria.returnStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

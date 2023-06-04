import {Component, OnInit} from '@angular/core';
import {LatePaymentRateService} from 'src/app/controller/service/LatePaymentRate.service';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {LatePaymentRateCriteria} from 'src/app/controller/criteria/LatePaymentRateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-late-payment-rate-list-admin',
  templateUrl: './late-payment-rate-list-admin.component.html'
})
export class LatePaymentRateListAdminComponent extends AbstractListController<LatePaymentRateDto, LatePaymentRateCriteria, LatePaymentRateService>  implements OnInit {

    fileName = 'LatePaymentRate';

  
    constructor(latePaymentRateService: LatePaymentRateService) {
        super(latePaymentRateService);
        this.pdfName='LatePaymentRate.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadLatePaymentRates(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('LatePaymentRate', 'list');
        isPermistted ? this.service.findAll().subscribe(latePaymentRates => this.items = latePaymentRates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'minApplicationDate', header: 'Min application date'},
            {field: 'maxApplicationDate', header: 'Max application date'},
            {field: 'amount', header: 'Amount'},
        ];
    }



	public initDuplicate(res: LatePaymentRateDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Min application date': this.datePipe.transform(e.minApplicationDate , 'dd/MM/yyyy hh:mm'),
                'Max application date': this.datePipe.transform(e.maxApplicationDate , 'dd/MM/yyyy hh:mm'),
                 'Amount': e.amount ,
            }
        });

        this.criteriaData = [{
            'Min application date Min': this.criteria.minApplicationDateFrom ? this.datePipe.transform(this.criteria.minApplicationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Min application date Max': this.criteria.minApplicationDateTo ? this.datePipe.transform(this.criteria.minApplicationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Max application date Min': this.criteria.maxApplicationDateFrom ? this.datePipe.transform(this.criteria.maxApplicationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Max application date Max': this.criteria.maxApplicationDateTo ? this.datePipe.transform(this.criteria.maxApplicationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Amount Min': this.criteria.amountMin ? this.criteria.amountMin : environment.emptyForExport ,
            'Amount Max': this.criteria.amountMax ? this.criteria.amountMax : environment.emptyForExport ,
        }];
      }
}

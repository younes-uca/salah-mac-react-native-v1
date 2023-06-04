import {Component, OnInit} from '@angular/core';
import {CorporateTaxRateService} from 'src/app/controller/service/CorporateTaxRate.service';
import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {CorporateTaxRateCriteria} from 'src/app/controller/criteria/CorporateTaxRateCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-corporate-tax-rate-list-admin',
  templateUrl: './corporate-tax-rate-list-admin.component.html'
})
export class CorporateTaxRateListAdminComponent extends AbstractListController<CorporateTaxRateDto, CorporateTaxRateCriteria, CorporateTaxRateService>  implements OnInit {

    fileName = 'CorporateTaxRate';

  
    constructor(corporateTaxRateService: CorporateTaxRateService) {
        super(corporateTaxRateService);
        this.pdfName='CorporateTaxRate.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadCorporateTaxRates(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CorporateTaxRate', 'list');
        isPermistted ? this.service.findAll().subscribe(corporateTaxRates => this.items = corporateTaxRates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'minimumIncome', header: 'Minimum income'},
            {field: 'maximumIncome', header: 'Maximum income'},
            {field: 'minApplicationDate', header: 'Min application date'},
            {field: 'maxApplicationDate', header: 'Max application date'},
            {field: 'percentage', header: 'Percentage'},
        ];
    }



	public initDuplicate(res: CorporateTaxRateDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Minimum income': e.minimumIncome ,
                 'Maximum income': e.maximumIncome ,
                'Min application date': this.datePipe.transform(e.minApplicationDate , 'dd/MM/yyyy hh:mm'),
                'Max application date': this.datePipe.transform(e.maxApplicationDate , 'dd/MM/yyyy hh:mm'),
                 'Percentage': e.percentage ,
            }
        });

        this.criteriaData = [{
            'Minimum income Min': this.criteria.minimumIncomeMin ? this.criteria.minimumIncomeMin : environment.emptyForExport ,
            'Minimum income Max': this.criteria.minimumIncomeMax ? this.criteria.minimumIncomeMax : environment.emptyForExport ,
            'Maximum income Min': this.criteria.maximumIncomeMin ? this.criteria.maximumIncomeMin : environment.emptyForExport ,
            'Maximum income Max': this.criteria.maximumIncomeMax ? this.criteria.maximumIncomeMax : environment.emptyForExport ,
            'Min application date Min': this.criteria.minApplicationDateFrom ? this.datePipe.transform(this.criteria.minApplicationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Min application date Max': this.criteria.minApplicationDateTo ? this.datePipe.transform(this.criteria.minApplicationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Max application date Min': this.criteria.maxApplicationDateFrom ? this.datePipe.transform(this.criteria.maxApplicationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Max application date Max': this.criteria.maxApplicationDateTo ? this.datePipe.transform(this.criteria.maxApplicationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Percentage Min': this.criteria.percentageMin ? this.criteria.percentageMin : environment.emptyForExport ,
            'Percentage Max': this.criteria.percentageMax ? this.criteria.percentageMax : environment.emptyForExport ,
        }];
      }
}

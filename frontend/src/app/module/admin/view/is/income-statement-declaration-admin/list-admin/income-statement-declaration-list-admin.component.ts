import {Component, OnInit} from '@angular/core';
import {IncomeStatementDeclarationService} from 'src/app/controller/service/IncomeStatementDeclaration.service';
import {IncomeStatementDeclarationDto} from 'src/app/controller/model/IncomeStatementDeclaration.model';
import {IncomeStatementDeclarationCriteria} from 'src/app/controller/criteria/IncomeStatementDeclarationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CompanyService } from 'src/app/controller/service/Company.service';
import { CorporateTaxRateService } from 'src/app/controller/service/CorporateTaxRate.service';
import { HandlingAccountantService } from 'src/app/controller/service/HandlingAccountant.service';
import { ValidationAccountantService } from 'src/app/controller/service/ValidationAccountant.service';

import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';


@Component({
  selector: 'app-income-statement-declaration-list-admin',
  templateUrl: './income-statement-declaration-list-admin.component.html'
})
export class IncomeStatementDeclarationListAdminComponent extends AbstractListController<IncomeStatementDeclarationDto, IncomeStatementDeclarationCriteria, IncomeStatementDeclarationService>  implements OnInit {

    fileName = 'IncomeStatementDeclaration';

    companys :Array<CompanyDto>;
    corporateTaxRates :Array<CorporateTaxRateDto>;
    handlingAccountants :Array<HandlingAccountantDto>;
    validationAccountants :Array<ValidationAccountantDto>;
  
    constructor(incomeStatementDeclarationService: IncomeStatementDeclarationService, private companyService: CompanyService, private corporateTaxRateService: CorporateTaxRateService, private handlingAccountantService: HandlingAccountantService, private validationAccountantService: ValidationAccountantService) {
        super(incomeStatementDeclarationService);
        this.pdfName='IncomeStatementDeclaration.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCompany();
      this.loadCorporateTaxRate();
      this.loadHandlingAccountant();
      this.loadValidationAccountant();
    }

    public async loadIncomeStatementDeclarations(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('IncomeStatementDeclaration', 'list');
        isPermistted ? this.service.findAll().subscribe(incomeStatementDeclarations => this.items = incomeStatementDeclarations,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'declarationDate', header: 'Declaration date'},
            {field: 'quarter', header: 'Quarter'},
            {field: 'year', header: 'Year'},
            {field: 'company?.ice', header: 'Company'},
            {field: 'totalExpense', header: 'Total expense'},
            {field: 'totalRevenue', header: 'Total revenue'},
            {field: 'incomeBeforeTax', header: 'Income before tax'},
            {field: 'corporateTaxRate?.id', header: 'Corporate tax rate'},
            {field: 'taxAmount', header: 'Tax amount'},
            {field: 'incomeAfterTax', header: 'Income after tax'},
            {field: 'handlingAccountant?.cin', header: 'Handling accountant'},
            {field: 'validationAccountant?.cin', header: 'Validation accountant'},
        ];
    }


    public async loadCompany(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('IncomeStatementDeclaration', 'list');
        isPermistted ? this.companyService.findAllOptimized().subscribe(companys => this.companys = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadCorporateTaxRate(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('IncomeStatementDeclaration', 'list');
        isPermistted ? this.corporateTaxRateService.findAll().subscribe(corporateTaxRates => this.corporateTaxRates = corporateTaxRates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadHandlingAccountant(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('IncomeStatementDeclaration', 'list');
        isPermistted ? this.handlingAccountantService.findAllOptimized().subscribe(handlingAccountants => this.handlingAccountants = handlingAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadValidationAccountant(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('IncomeStatementDeclaration', 'list');
        isPermistted ? this.validationAccountantService.findAllOptimized().subscribe(validationAccountants => this.validationAccountants = validationAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: IncomeStatementDeclarationDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Declaration date': this.datePipe.transform(e.declarationDate , 'dd/MM/yyyy hh:mm'),
                 'Quarter': e.quarter ,
                 'Year': e.year ,
                'Company': e.company?.ice ,
                 'Total expense': e.totalExpense ,
                 'Total revenue': e.totalRevenue ,
                 'Income before tax': e.incomeBeforeTax ,
                'Corporate tax rate': e.corporateTaxRate?.id ,
                 'Tax amount': e.taxAmount ,
                 'Income after tax': e.incomeAfterTax ,
                'Handling accountant': e.handlingAccountant?.cin ,
                'Validation accountant': e.validationAccountant?.cin ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Declaration date Min': this.criteria.declarationDateFrom ? this.datePipe.transform(this.criteria.declarationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Declaration date Max': this.criteria.declarationDateTo ? this.datePipe.transform(this.criteria.declarationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Quarter Min': this.criteria.quarterMin ? this.criteria.quarterMin : environment.emptyForExport ,
            'Quarter Max': this.criteria.quarterMax ? this.criteria.quarterMax : environment.emptyForExport ,
            'Year Min': this.criteria.yearMin ? this.criteria.yearMin : environment.emptyForExport ,
            'Year Max': this.criteria.yearMax ? this.criteria.yearMax : environment.emptyForExport ,
        //'Company': this.criteria.company?.ice ? this.criteria.company?.ice : environment.emptyForExport ,
            'Total expense Min': this.criteria.totalExpenseMin ? this.criteria.totalExpenseMin : environment.emptyForExport ,
            'Total expense Max': this.criteria.totalExpenseMax ? this.criteria.totalExpenseMax : environment.emptyForExport ,
            'Total revenue Min': this.criteria.totalRevenueMin ? this.criteria.totalRevenueMin : environment.emptyForExport ,
            'Total revenue Max': this.criteria.totalRevenueMax ? this.criteria.totalRevenueMax : environment.emptyForExport ,
            'Income before tax Min': this.criteria.incomeBeforeTaxMin ? this.criteria.incomeBeforeTaxMin : environment.emptyForExport ,
            'Income before tax Max': this.criteria.incomeBeforeTaxMax ? this.criteria.incomeBeforeTaxMax : environment.emptyForExport ,
        //'Corporate tax rate': this.criteria.corporateTaxRate?.id ? this.criteria.corporateTaxRate?.id : environment.emptyForExport ,
            'Tax amount Min': this.criteria.taxAmountMin ? this.criteria.taxAmountMin : environment.emptyForExport ,
            'Tax amount Max': this.criteria.taxAmountMax ? this.criteria.taxAmountMax : environment.emptyForExport ,
            'Income after tax Min': this.criteria.incomeAfterTaxMin ? this.criteria.incomeAfterTaxMin : environment.emptyForExport ,
            'Income after tax Max': this.criteria.incomeAfterTaxMax ? this.criteria.incomeAfterTaxMax : environment.emptyForExport ,
        //'Handling accountant': this.criteria.handlingAccountant?.cin ? this.criteria.handlingAccountant?.cin : environment.emptyForExport ,
        //'Validation accountant': this.criteria.validationAccountant?.cin ? this.criteria.validationAccountant?.cin : environment.emptyForExport ,
        }];
      }
}

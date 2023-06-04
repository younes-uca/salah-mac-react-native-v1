import {Component, OnInit} from '@angular/core';
import {VatDeclarationService} from 'src/app/controller/service/VatDeclaration.service';
import {VatDeclarationDto} from 'src/app/controller/model/VatDeclaration.model';
import {VatDeclarationCriteria} from 'src/app/controller/criteria/VatDeclarationCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CompanyService } from 'src/app/controller/service/Company.service';
import { LatePaymentRateService } from 'src/app/controller/service/LatePaymentRate.service';
import { HandlingAccountantService } from 'src/app/controller/service/HandlingAccountant.service';
import { ValidationAccountantService } from 'src/app/controller/service/ValidationAccountant.service';

import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';


@Component({
  selector: 'app-vat-declaration-list-admin',
  templateUrl: './vat-declaration-list-admin.component.html'
})
export class VatDeclarationListAdminComponent extends AbstractListController<VatDeclarationDto, VatDeclarationCriteria, VatDeclarationService>  implements OnInit {

    fileName = 'VatDeclaration';

    companys :Array<CompanyDto>;
    latePaymentRates :Array<LatePaymentRateDto>;
    handlingAccountants :Array<HandlingAccountantDto>;
    validationAccountants :Array<ValidationAccountantDto>;
  
    constructor(vatDeclarationService: VatDeclarationService, private companyService: CompanyService, private latePaymentRateService: LatePaymentRateService, private handlingAccountantService: HandlingAccountantService, private validationAccountantService: ValidationAccountantService) {
        super(vatDeclarationService);
        this.pdfName='VatDeclaration.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCompany();
      this.loadLatePaymentRate();
      this.loadHandlingAccountant();
      this.loadValidationAccountant();
    }

    public async loadVatDeclarations(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('VatDeclaration', 'list');
        isPermistted ? this.service.findAll().subscribe(vatDeclarations => this.items = vatDeclarations,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'declarationDate', header: 'Declaration date'},
            {field: 'quarter', header: 'Quarter'},
            {field: 'year', header: 'Year'},
            {field: 'company?.ice', header: 'Company'},
            {field: 'totalCollectedVat', header: 'Total collected vat'},
            {field: 'totalDueVat', header: 'Total due vat'},
            {field: 'vatDifference', header: 'Vat difference'},
            {field: 'latePaymentRate?.id', header: 'Late payment rate'},
            {field: 'vatAmount', header: 'Vat amount'},
            {field: 'handlingAccountant?.cin', header: 'Handling accountant'},
            {field: 'validationAccountant?.cin', header: 'Validation accountant'},
        ];
    }


    public async loadCompany(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('VatDeclaration', 'list');
        isPermistted ? this.companyService.findAllOptimized().subscribe(companys => this.companys = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadLatePaymentRate(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('VatDeclaration', 'list');
        isPermistted ? this.latePaymentRateService.findAll().subscribe(latePaymentRates => this.latePaymentRates = latePaymentRates,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadHandlingAccountant(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('VatDeclaration', 'list');
        isPermistted ? this.handlingAccountantService.findAllOptimized().subscribe(handlingAccountants => this.handlingAccountants = handlingAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadValidationAccountant(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('VatDeclaration', 'list');
        isPermistted ? this.validationAccountantService.findAllOptimized().subscribe(validationAccountants => this.validationAccountants = validationAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: VatDeclarationDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                'Declaration date': this.datePipe.transform(e.declarationDate , 'dd/MM/yyyy hh:mm'),
                 'Quarter': e.quarter ,
                 'Year': e.year ,
                'Company': e.company?.ice ,
                 'Total collected vat': e.totalCollectedVat ,
                 'Total due vat': e.totalDueVat ,
                 'Vat difference': e.vatDifference ,
                'Late payment rate': e.latePaymentRate?.id ,
                 'Vat amount': e.vatAmount ,
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
            'Total collected vat Min': this.criteria.totalCollectedVatMin ? this.criteria.totalCollectedVatMin : environment.emptyForExport ,
            'Total collected vat Max': this.criteria.totalCollectedVatMax ? this.criteria.totalCollectedVatMax : environment.emptyForExport ,
            'Total due vat Min': this.criteria.totalDueVatMin ? this.criteria.totalDueVatMin : environment.emptyForExport ,
            'Total due vat Max': this.criteria.totalDueVatMax ? this.criteria.totalDueVatMax : environment.emptyForExport ,
            'Vat difference Min': this.criteria.vatDifferenceMin ? this.criteria.vatDifferenceMin : environment.emptyForExport ,
            'Vat difference Max': this.criteria.vatDifferenceMax ? this.criteria.vatDifferenceMax : environment.emptyForExport ,
        //'Late payment rate': this.criteria.latePaymentRate?.id ? this.criteria.latePaymentRate?.id : environment.emptyForExport ,
            'Vat amount Min': this.criteria.vatAmountMin ? this.criteria.vatAmountMin : environment.emptyForExport ,
            'Vat amount Max': this.criteria.vatAmountMax ? this.criteria.vatAmountMax : environment.emptyForExport ,
        //'Handling accountant': this.criteria.handlingAccountant?.cin ? this.criteria.handlingAccountant?.cin : environment.emptyForExport ,
        //'Validation accountant': this.criteria.validationAccountant?.cin ? this.criteria.validationAccountant?.cin : environment.emptyForExport ,
        }];
      }
}

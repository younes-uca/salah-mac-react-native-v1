import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {IncomeStatementDeclarationService} from 'src/app/controller/service/IncomeStatementDeclaration.service';
import {IncomeStatementDeclarationDto} from 'src/app/controller/model/IncomeStatementDeclaration.model';
import {IncomeStatementDeclarationCriteria} from 'src/app/controller/criteria/IncomeStatementDeclarationCriteria.model';

import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';
import {ValidationAccountantService} from 'src/app/controller/service/ValidationAccountant.service';
import {CorporateTaxRateDto} from 'src/app/controller/model/CorporateTaxRate.model';
import {CorporateTaxRateService} from 'src/app/controller/service/CorporateTaxRate.service';
@Component({
  selector: 'app-income-statement-declaration-view-admin',
  templateUrl: './income-statement-declaration-view-admin.component.html'
})
export class IncomeStatementDeclarationViewAdminComponent extends AbstractViewController<IncomeStatementDeclarationDto, IncomeStatementDeclarationCriteria, IncomeStatementDeclarationService> implements OnInit {


    constructor(private incomeStatementDeclarationService: IncomeStatementDeclarationService, private companyService: CompanyService, private handlingAccountantService: HandlingAccountantService, private validationAccountantService: ValidationAccountantService, private corporateTaxRateService: CorporateTaxRateService){
        super(incomeStatementDeclarationService);
    }

    ngOnInit(): void {
        this.company = new CompanyDto();
        this.companyService.findAll().subscribe((data) => this.companys = data);
        this.corporateTaxRate = new CorporateTaxRateDto();
        this.corporateTaxRateService.findAll().subscribe((data) => this.corporateTaxRates = data);
        this.handlingAccountant = new HandlingAccountantDto();
        this.handlingAccountantService.findAll().subscribe((data) => this.handlingAccountants = data);
        this.validationAccountant = new ValidationAccountantDto();
        this.validationAccountantService.findAll().subscribe((data) => this.validationAccountants = data);
    }


    get company(): CompanyDto {
       return this.companyService.item;
    }
    set company(value: CompanyDto) {
        this.companyService.item = value;
    }
    get companys():Array<CompanyDto> {
       return this.companyService.items;
    }
    set companys(value: Array<CompanyDto>) {
        this.companyService.items = value;
    }
    get corporateTaxRate(): CorporateTaxRateDto {
       return this.corporateTaxRateService.item;
    }
    set corporateTaxRate(value: CorporateTaxRateDto) {
        this.corporateTaxRateService.item = value;
    }
    get corporateTaxRates():Array<CorporateTaxRateDto> {
       return this.corporateTaxRateService.items;
    }
    set corporateTaxRates(value: Array<CorporateTaxRateDto>) {
        this.corporateTaxRateService.items = value;
    }
    get handlingAccountant(): HandlingAccountantDto {
       return this.handlingAccountantService.item;
    }
    set handlingAccountant(value: HandlingAccountantDto) {
        this.handlingAccountantService.item = value;
    }
    get handlingAccountants():Array<HandlingAccountantDto> {
       return this.handlingAccountantService.items;
    }
    set handlingAccountants(value: Array<HandlingAccountantDto>) {
        this.handlingAccountantService.items = value;
    }
    get validationAccountant(): ValidationAccountantDto {
       return this.validationAccountantService.item;
    }
    set validationAccountant(value: ValidationAccountantDto) {
        this.validationAccountantService.item = value;
    }
    get validationAccountants():Array<ValidationAccountantDto> {
       return this.validationAccountantService.items;
    }
    set validationAccountants(value: Array<ValidationAccountantDto>) {
        this.validationAccountantService.items = value;
    }


}

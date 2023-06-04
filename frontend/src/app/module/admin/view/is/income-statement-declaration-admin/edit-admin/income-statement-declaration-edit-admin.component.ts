import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

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
  selector: 'app-income-statement-declaration-edit-admin',
  templateUrl: './income-statement-declaration-edit-admin.component.html'
})
export class IncomeStatementDeclarationEditAdminComponent extends AbstractEditController<IncomeStatementDeclarationDto, IncomeStatementDeclarationCriteria, IncomeStatementDeclarationService>   implements OnInit {






    constructor( private incomeStatementDeclarationService: IncomeStatementDeclarationService , private companyService: CompanyService, private handlingAccountantService: HandlingAccountantService, private validationAccountantService: ValidationAccountantService, private corporateTaxRateService: CorporateTaxRateService) {
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
    public prepareEdit() {
        this.item.declarationDate = this.incomeStatementDeclarationService.format(this.item.declarationDate);
    }



    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateCorporateTaxRate(corporateTaxRate: string) {
        const isPermistted = await this.roleService.isPermitted('CorporateTaxRate', 'edit');
        if(isPermistted) {
             this.corporateTaxRate = new CorporateTaxRateDto();
             this.createCorporateTaxRateDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get company(): CompanyDto {
       return this.companyService.item;
   }
  set company(value: CompanyDto) {
        this.companyService.item = value;
   }
   get companys(): Array<CompanyDto> {
        return this.companyService.items;
   }
   set companys(value: Array<CompanyDto>) {
        this.companyService.items = value;
   }
   get createCompanyDialog(): boolean {
       return this.companyService.createDialog;
   }
  set createCompanyDialog(value: boolean) {
       this.companyService.createDialog= value;
   }
   get corporateTaxRate(): CorporateTaxRateDto {
       return this.corporateTaxRateService.item;
   }
  set corporateTaxRate(value: CorporateTaxRateDto) {
        this.corporateTaxRateService.item = value;
   }
   get corporateTaxRates(): Array<CorporateTaxRateDto> {
        return this.corporateTaxRateService.items;
   }
   set corporateTaxRates(value: Array<CorporateTaxRateDto>) {
        this.corporateTaxRateService.items = value;
   }
   get createCorporateTaxRateDialog(): boolean {
       return this.corporateTaxRateService.createDialog;
   }
  set createCorporateTaxRateDialog(value: boolean) {
       this.corporateTaxRateService.createDialog= value;
   }
   get handlingAccountant(): HandlingAccountantDto {
       return this.handlingAccountantService.item;
   }
  set handlingAccountant(value: HandlingAccountantDto) {
        this.handlingAccountantService.item = value;
   }
   get handlingAccountants(): Array<HandlingAccountantDto> {
        return this.handlingAccountantService.items;
   }
   set handlingAccountants(value: Array<HandlingAccountantDto>) {
        this.handlingAccountantService.items = value;
   }
   get createHandlingAccountantDialog(): boolean {
       return this.handlingAccountantService.createDialog;
   }
  set createHandlingAccountantDialog(value: boolean) {
       this.handlingAccountantService.createDialog= value;
   }
   get validationAccountant(): ValidationAccountantDto {
       return this.validationAccountantService.item;
   }
  set validationAccountant(value: ValidationAccountantDto) {
        this.validationAccountantService.item = value;
   }
   get validationAccountants(): Array<ValidationAccountantDto> {
        return this.validationAccountantService.items;
   }
   set validationAccountants(value: Array<ValidationAccountantDto>) {
        this.validationAccountantService.items = value;
   }
   get createValidationAccountantDialog(): boolean {
       return this.validationAccountantService.createDialog;
   }
  set createValidationAccountantDialog(value: boolean) {
       this.validationAccountantService.createDialog= value;
   }



}

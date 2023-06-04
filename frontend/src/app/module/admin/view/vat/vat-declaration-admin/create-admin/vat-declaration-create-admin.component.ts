import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {VatDeclarationService} from 'src/app/controller/service/VatDeclaration.service';
import {VatDeclarationDto} from 'src/app/controller/model/VatDeclaration.model';
import {VatDeclarationCriteria} from 'src/app/controller/criteria/VatDeclarationCriteria.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';
import {ValidationAccountantService} from 'src/app/controller/service/ValidationAccountant.service';
import {LatePaymentRateDto} from 'src/app/controller/model/LatePaymentRate.model';
import {LatePaymentRateService} from 'src/app/controller/service/LatePaymentRate.service';
@Component({
  selector: 'app-vat-declaration-create-admin',
  templateUrl: './vat-declaration-create-admin.component.html'
})
export class VatDeclarationCreateAdminComponent extends AbstractCreateController<VatDeclarationDto, VatDeclarationCriteria, VatDeclarationService>  implements OnInit {




    constructor( private vatDeclarationService: VatDeclarationService , private companyService: CompanyService, private handlingAccountantService: HandlingAccountantService, private validationAccountantService: ValidationAccountantService, private latePaymentRateService: LatePaymentRateService) {
        super(vatDeclarationService);
    }

    ngOnInit(): void {
    this.company = new CompanyDto();
    this.companyService.findAll().subscribe((data) => this.companys = data);
    this.latePaymentRate = new LatePaymentRateDto();
    this.latePaymentRateService.findAll().subscribe((data) => this.latePaymentRates = data);
    this.handlingAccountant = new HandlingAccountantDto();
    this.handlingAccountantService.findAll().subscribe((data) => this.handlingAccountants = data);
    this.validationAccountant = new ValidationAccountantDto();
    this.validationAccountantService.findAll().subscribe((data) => this.validationAccountants = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateLatePaymentRate(latePaymentRate: string) {
    const isPermistted = await this.roleService.isPermitted('LatePaymentRate', 'add');
    if(isPermistted) {
         this.latePaymentRate = new LatePaymentRateDto();
         this.createLatePaymentRateDialog = true;
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
    get latePaymentRate(): LatePaymentRateDto {
        return this.latePaymentRateService.item;
    }
    set latePaymentRate(value: LatePaymentRateDto) {
        this.latePaymentRateService.item = value;
    }
    get latePaymentRates(): Array<LatePaymentRateDto> {
        return this.latePaymentRateService.items;
    }
    set latePaymentRates(value: Array<LatePaymentRateDto>) {
        this.latePaymentRateService.items = value;
    }
    get createLatePaymentRateDialog(): boolean {
       return this.latePaymentRateService.createDialog;
    }
    set createLatePaymentRateDialog(value: boolean) {
        this.latePaymentRateService.createDialog= value;
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

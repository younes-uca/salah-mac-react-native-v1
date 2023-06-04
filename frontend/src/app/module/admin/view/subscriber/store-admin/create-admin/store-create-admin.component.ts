import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {StoreService} from 'src/app/controller/service/Store.service';
import {StoreDto} from 'src/app/controller/model/Store.model';
import {StoreCriteria} from 'src/app/controller/criteria/StoreCriteria.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
@Component({
  selector: 'app-store-create-admin',
  templateUrl: './store-create-admin.component.html'
})
export class StoreCreateAdminComponent extends AbstractCreateController<StoreDto, StoreCriteria, StoreService>  implements OnInit {




    constructor( private storeService: StoreService , private companyService: CompanyService) {
        super(storeService);
    }

    ngOnInit(): void {
    this.company = new CompanyDto();
    this.companyService.findAll().subscribe((data) => this.companys = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateCompany(company: string) {
    const isPermistted = await this.roleService.isPermitted('Company', 'add');
    if(isPermistted) {
         this.company = new CompanyDto();
         this.createCompanyDialog = true;
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






}

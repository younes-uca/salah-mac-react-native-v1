import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BalanceSheetService} from 'src/app/controller/service/BalanceSheet.service';
import {BalanceSheetDto} from 'src/app/controller/model/BalanceSheet.model';
import {BalanceSheetCriteria} from 'src/app/controller/criteria/BalanceSheetCriteria.model';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {BalanceSheetStatusDto} from 'src/app/controller/model/BalanceSheetStatus.model';
import {BalanceSheetStatusService} from 'src/app/controller/service/BalanceSheetStatus.service';
@Component({
  selector: 'app-balance-sheet-create-admin',
  templateUrl: './balance-sheet-create-admin.component.html'
})
export class BalanceSheetCreateAdminComponent extends AbstractCreateController<BalanceSheetDto, BalanceSheetCriteria, BalanceSheetService>  implements OnInit {




    constructor( private balanceSheetService: BalanceSheetService , private companyService: CompanyService, private balanceSheetStatusService: BalanceSheetStatusService) {
        super(balanceSheetService);
    }

    ngOnInit(): void {
    this.company = new CompanyDto();
    this.companyService.findAll().subscribe((data) => this.companys = data);
    this.balanceSheetStatus = new BalanceSheetStatusDto();
    this.balanceSheetStatusService.findAll().subscribe((data) => this.balanceSheetStatuss = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateBalanceSheetStatus(balanceSheetStatus: string) {
    const isPermistted = await this.roleService.isPermitted('BalanceSheetStatus', 'add');
    if(isPermistted) {
         this.balanceSheetStatus = new BalanceSheetStatusDto();
         this.createBalanceSheetStatusDialog = true;
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
    get balanceSheetStatus(): BalanceSheetStatusDto {
        return this.balanceSheetStatusService.item;
    }
    set balanceSheetStatus(value: BalanceSheetStatusDto) {
        this.balanceSheetStatusService.item = value;
    }
    get balanceSheetStatuss(): Array<BalanceSheetStatusDto> {
        return this.balanceSheetStatusService.items;
    }
    set balanceSheetStatuss(value: Array<BalanceSheetStatusDto>) {
        this.balanceSheetStatusService.items = value;
    }
    get createBalanceSheetStatusDialog(): boolean {
       return this.balanceSheetStatusService.createDialog;
    }
    set createBalanceSheetStatusDialog(value: boolean) {
        this.balanceSheetStatusService.createDialog= value;
    }






}

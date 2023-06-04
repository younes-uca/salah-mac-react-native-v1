import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {BankCheckOwnerService} from 'src/app/controller/service/BankCheckOwner.service';
import {BankCheckOwnerDto} from 'src/app/controller/model/BankCheckOwner.model';
import {BankCheckOwnerCriteria} from 'src/app/controller/criteria/BankCheckOwnerCriteria.model';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {BankDto} from 'src/app/controller/model/Bank.model';
import {BankService} from 'src/app/controller/service/Bank.service';
@Component({
  selector: 'app-bank-check-owner-create-admin',
  templateUrl: './bank-check-owner-create-admin.component.html'
})
export class BankCheckOwnerCreateAdminComponent extends AbstractCreateController<BankCheckOwnerDto, BankCheckOwnerCriteria, BankCheckOwnerService>  implements OnInit {




    constructor( private bankCheckOwnerService: BankCheckOwnerService , private checkOwnerService: CheckOwnerService, private bankService: BankService) {
        super(bankCheckOwnerService);
    }

    ngOnInit(): void {
    this.checkOwner = new CheckOwnerDto();
    this.checkOwnerService.findAll().subscribe((data) => this.checkOwners = data);
    this.bank = new BankDto();
    this.bankService.findAll().subscribe((data) => this.banks = data);
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



    public async openCreateCheckOwner(checkOwner: string) {
    const isPermistted = await this.roleService.isPermitted('CheckOwner', 'add');
    if(isPermistted) {
         this.checkOwner = new CheckOwnerDto();
         this.createCheckOwnerDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }
    public async openCreateBank(bank: string) {
    const isPermistted = await this.roleService.isPermitted('Bank', 'add');
    if(isPermistted) {
         this.bank = new BankDto();
         this.createBankDialog = true;
    }else{
        this.messageService.add({
        severity: 'error', summary: 'erreur', detail: 'problème de permission'
        });
     }
    }

    get checkOwner(): CheckOwnerDto {
        return this.checkOwnerService.item;
    }
    set checkOwner(value: CheckOwnerDto) {
        this.checkOwnerService.item = value;
    }
    get checkOwners(): Array<CheckOwnerDto> {
        return this.checkOwnerService.items;
    }
    set checkOwners(value: Array<CheckOwnerDto>) {
        this.checkOwnerService.items = value;
    }
    get createCheckOwnerDialog(): boolean {
       return this.checkOwnerService.createDialog;
    }
    set createCheckOwnerDialog(value: boolean) {
        this.checkOwnerService.createDialog= value;
    }
    get bank(): BankDto {
        return this.bankService.item;
    }
    set bank(value: BankDto) {
        this.bankService.item = value;
    }
    get banks(): Array<BankDto> {
        return this.bankService.items;
    }
    set banks(value: Array<BankDto>) {
        this.bankService.items = value;
    }
    get createBankDialog(): boolean {
       return this.bankService.createDialog;
    }
    set createBankDialog(value: boolean) {
        this.bankService.createDialog= value;
    }






}

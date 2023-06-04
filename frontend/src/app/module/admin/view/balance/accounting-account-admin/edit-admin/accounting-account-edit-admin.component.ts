import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {AccountingAccountService} from 'src/app/controller/service/AccountingAccount.service';
import {AccountingAccountDto} from 'src/app/controller/model/AccountingAccount.model';
import {AccountingAccountCriteria} from 'src/app/controller/criteria/AccountingAccountCriteria.model';


import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';
import {SubAccountingClassService} from 'src/app/controller/service/SubAccountingClass.service';

@Component({
  selector: 'app-accounting-account-edit-admin',
  templateUrl: './accounting-account-edit-admin.component.html'
})
export class AccountingAccountEditAdminComponent extends AbstractEditController<AccountingAccountDto, AccountingAccountCriteria, AccountingAccountService>   implements OnInit {






    constructor( private accountingAccountService: AccountingAccountService , private subAccountingClassService: SubAccountingClassService) {
        super(accountingAccountService);
    }

    ngOnInit(): void {
    this.subAccountingClass = new SubAccountingClassDto();
    this.subAccountingClassService.findAll().subscribe((data) => this.subAccountingClasss = data);
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateSubAccountingClass(subAccountingClass: string) {
        const isPermistted = await this.roleService.isPermitted('SubAccountingClass', 'edit');
        if(isPermistted) {
             this.subAccountingClass = new SubAccountingClassDto();
             this.createSubAccountingClassDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get subAccountingClass(): SubAccountingClassDto {
       return this.subAccountingClassService.item;
   }
  set subAccountingClass(value: SubAccountingClassDto) {
        this.subAccountingClassService.item = value;
   }
   get subAccountingClasss(): Array<SubAccountingClassDto> {
        return this.subAccountingClassService.items;
   }
   set subAccountingClasss(value: Array<SubAccountingClassDto>) {
        this.subAccountingClassService.items = value;
   }
   get createSubAccountingClassDialog(): boolean {
       return this.subAccountingClassService.createDialog;
   }
  set createSubAccountingClassDialog(value: boolean) {
       this.subAccountingClassService.createDialog= value;
   }



}

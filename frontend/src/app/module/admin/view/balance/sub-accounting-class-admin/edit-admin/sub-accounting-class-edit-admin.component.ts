import {Component, OnInit, Input} from '@angular/core';


import {AbstractEditController} from 'src/app/zynerator/controller/AbstractEditController';

import {SubAccountingClassService} from 'src/app/controller/service/SubAccountingClass.service';
import {SubAccountingClassDto} from 'src/app/controller/model/SubAccountingClass.model';
import {SubAccountingClassCriteria} from 'src/app/controller/criteria/SubAccountingClassCriteria.model';


import {AccountingClassDto} from 'src/app/controller/model/AccountingClass.model';
import {AccountingClassService} from 'src/app/controller/service/AccountingClass.service';

@Component({
  selector: 'app-sub-accounting-class-edit-admin',
  templateUrl: './sub-accounting-class-edit-admin.component.html'
})
export class SubAccountingClassEditAdminComponent extends AbstractEditController<SubAccountingClassDto, SubAccountingClassCriteria, SubAccountingClassService>   implements OnInit {






    constructor( private subAccountingClassService: SubAccountingClassService , private accountingClassService: AccountingClassService) {
        super(subAccountingClassService);
    }

    ngOnInit(): void {
    this.accountingClass = new AccountingClassDto();
    this.accountingClassService.findAll().subscribe((data) => this.accountingClasss = data);
}


    public setValidation(value : boolean){
        }
    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }



   public async openCreateAccountingClass(accountingClass: string) {
        const isPermistted = await this.roleService.isPermitted('AccountingClass', 'edit');
        if(isPermistted) {
             this.accountingClass = new AccountingClassDto();
             this.createAccountingClassDialog = true;
        }else{
             this.messageService.add({
                severity: 'error', summary: 'erreur', detail: 'problème de permission'
            });
        }
    }

   get accountingClass(): AccountingClassDto {
       return this.accountingClassService.item;
   }
  set accountingClass(value: AccountingClassDto) {
        this.accountingClassService.item = value;
   }
   get accountingClasss(): Array<AccountingClassDto> {
        return this.accountingClassService.items;
   }
   set accountingClasss(value: Array<AccountingClassDto>) {
        this.accountingClassService.items = value;
   }
   get createAccountingClassDialog(): boolean {
       return this.accountingClassService.createDialog;
   }
  set createAccountingClassDialog(value: boolean) {
       this.accountingClassService.createDialog= value;
   }



}

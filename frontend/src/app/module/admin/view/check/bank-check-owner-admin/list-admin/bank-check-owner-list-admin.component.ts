import {Component, OnInit} from '@angular/core';
import {BankCheckOwnerService} from 'src/app/controller/service/BankCheckOwner.service';
import {BankCheckOwnerDto} from 'src/app/controller/model/BankCheckOwner.model';
import {BankCheckOwnerCriteria} from 'src/app/controller/criteria/BankCheckOwnerCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { CheckOwnerService } from 'src/app/controller/service/CheckOwner.service';
import { BankService } from 'src/app/controller/service/Bank.service';

import {BankDto} from 'src/app/controller/model/Bank.model';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';


@Component({
  selector: 'app-bank-check-owner-list-admin',
  templateUrl: './bank-check-owner-list-admin.component.html'
})
export class BankCheckOwnerListAdminComponent extends AbstractListController<BankCheckOwnerDto, BankCheckOwnerCriteria, BankCheckOwnerService>  implements OnInit {

    fileName = 'BankCheckOwner';

    checkOwners :Array<CheckOwnerDto>;
    banks :Array<BankDto>;
  
    constructor(bankCheckOwnerService: BankCheckOwnerService, private checkOwnerService: CheckOwnerService, private bankService: BankService) {
        super(bankCheckOwnerService);
        this.pdfName='BankCheckOwner.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadCheckOwner();
      this.loadBank();
    }

    public async loadBankCheckOwners(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BankCheckOwner', 'list');
        isPermistted ? this.service.findAll().subscribe(bankCheckOwners => this.items = bankCheckOwners,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'checkOwner?.name', header: 'Check owner'},
            {field: 'bank?.libelle', header: 'Bank'},
        ];
    }


    public async loadCheckOwner(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BankCheckOwner', 'list');
        isPermistted ? this.checkOwnerService.findAllOptimized().subscribe(checkOwners => this.checkOwners = checkOwners,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadBank(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('BankCheckOwner', 'list');
        isPermistted ? this.bankService.findAllOptimized().subscribe(banks => this.banks = banks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: BankCheckOwnerDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Check owner': e.checkOwner?.name ,
                'Bank': e.bank?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Check owner': this.criteria.checkOwner?.name ? this.criteria.checkOwner?.name : environment.emptyForExport ,
        //'Bank': this.criteria.bank?.libelle ? this.criteria.bank?.libelle : environment.emptyForExport ,
        }];
      }
}

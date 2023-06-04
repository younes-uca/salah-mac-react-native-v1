import {Component, OnInit} from '@angular/core';
import {BankService} from 'src/app/controller/service/Bank.service';
import {BankDto} from 'src/app/controller/model/Bank.model';
import {BankCriteria} from 'src/app/controller/criteria/BankCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-bank-list-admin',
  templateUrl: './bank-list-admin.component.html'
})
export class BankListAdminComponent extends AbstractListController<BankDto, BankCriteria, BankService>  implements OnInit {

    fileName = 'Bank';

  
    constructor(bankService: BankService) {
        super(bankService);
        this.pdfName='Bank.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadBanks(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Bank', 'list');
        isPermistted ? this.service.findAll().subscribe(banks => this.items = banks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: BankDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}

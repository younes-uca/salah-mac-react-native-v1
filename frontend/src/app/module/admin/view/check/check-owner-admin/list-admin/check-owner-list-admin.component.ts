import {Component, OnInit} from '@angular/core';
import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerCriteria} from 'src/app/controller/criteria/CheckOwnerCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-check-owner-list-admin',
  templateUrl: './check-owner-list-admin.component.html'
})
export class CheckOwnerListAdminComponent extends AbstractListController<CheckOwnerDto, CheckOwnerCriteria, CheckOwnerService>  implements OnInit {

    fileName = 'CheckOwner';

  
    constructor(checkOwnerService: CheckOwnerService) {
        super(checkOwnerService);
        this.pdfName='CheckOwner.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadCheckOwners(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('CheckOwner', 'list');
        isPermistted ? this.service.findAll().subscribe(checkOwners => this.items = checkOwners,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'name', header: 'Name'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: CheckOwnerDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Name': e.name ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}

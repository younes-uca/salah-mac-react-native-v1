import {Component, OnInit} from '@angular/core';
import {HandlingAccountantService} from 'src/app/controller/service/HandlingAccountant.service';
import {HandlingAccountantDto} from 'src/app/controller/model/HandlingAccountant.model';
import {HandlingAccountantCriteria} from 'src/app/controller/criteria/HandlingAccountantCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-handling-accountant-list-admin',
  templateUrl: './handling-accountant-list-admin.component.html'
})
export class HandlingAccountantListAdminComponent extends AbstractListController<HandlingAccountantDto, HandlingAccountantCriteria, HandlingAccountantService>  implements OnInit {

    fileName = 'HandlingAccountant';

  
    constructor(handlingAccountantService: HandlingAccountantService) {
        super(handlingAccountantService);
        this.pdfName='HandlingAccountant.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadHandlingAccountants(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('HandlingAccountant', 'list');
        isPermistted ? this.service.findAll().subscribe(handlingAccountants => this.items = handlingAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'lastName', header: 'Last name'},
            {field: 'firstName', header: 'First name'},
        ];
    }



	public initDuplicate(res: HandlingAccountantDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Cin': e.cin ,
                 'Last name': e.lastName ,
                 'First name': e.firstName ,
            }
        });

        this.criteriaData = [{
            'Cin': this.criteria.cin ? this.criteria.cin : environment.emptyForExport ,
            'Last name': this.criteria.lastName ? this.criteria.lastName : environment.emptyForExport ,
            'First name': this.criteria.firstName ? this.criteria.firstName : environment.emptyForExport ,
        }];
      }
}

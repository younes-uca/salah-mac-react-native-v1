import {Component, OnInit} from '@angular/core';
import {ValidationAccountantService} from 'src/app/controller/service/ValidationAccountant.service';
import {ValidationAccountantDto} from 'src/app/controller/model/ValidationAccountant.model';
import {ValidationAccountantCriteria} from 'src/app/controller/criteria/ValidationAccountantCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-validation-accountant-list-admin',
  templateUrl: './validation-accountant-list-admin.component.html'
})
export class ValidationAccountantListAdminComponent extends AbstractListController<ValidationAccountantDto, ValidationAccountantCriteria, ValidationAccountantService>  implements OnInit {

    fileName = 'ValidationAccountant';

  
    constructor(validationAccountantService: ValidationAccountantService) {
        super(validationAccountantService);
        this.pdfName='ValidationAccountant.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadValidationAccountants(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ValidationAccountant', 'list');
        isPermistted ? this.service.findAll().subscribe(validationAccountants => this.items = validationAccountants,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'cin', header: 'Cin'},
            {field: 'lastName', header: 'Last name'},
            {field: 'firstName', header: 'First name'},
        ];
    }



	public initDuplicate(res: ValidationAccountantDto) {
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

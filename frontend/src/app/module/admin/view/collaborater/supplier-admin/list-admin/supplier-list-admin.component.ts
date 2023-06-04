import {Component, OnInit} from '@angular/core';
import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierCriteria} from 'src/app/controller/criteria/SupplierCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-supplier-list-admin',
  templateUrl: './supplier-list-admin.component.html'
})
export class SupplierListAdminComponent extends AbstractListController<SupplierDto, SupplierCriteria, SupplierService>  implements OnInit {

    fileName = 'Supplier';

  
    constructor(supplierService: SupplierService) {
        super(supplierService);
        this.pdfName='Supplier.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadSuppliers(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Supplier', 'list');
        isPermistted ? this.service.findAll().subscribe(suppliers => this.items = suppliers,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'ice', header: 'Ice'},
            {field: 'name', header: 'Name'},
            {field: 'tel', header: 'Tel'},
            {field: 'email', header: 'Email'},
            {field: 'address', header: 'Address'},
            {field: 'debt', header: 'Debt'},
        ];
    }



	public initDuplicate(res: SupplierDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Ice': e.ice ,
                 'Name': e.name ,
                 'Tel': e.tel ,
                 'Email': e.email ,
                 'Address': e.address ,
                 'Description': e.description ,
                 'Debt': e.debt ,
            }
        });

        this.criteriaData = [{
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
            'Name': this.criteria.name ? this.criteria.name : environment.emptyForExport ,
            'Tel': this.criteria.tel ? this.criteria.tel : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Address': this.criteria.address ? this.criteria.address : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
            'Debt Min': this.criteria.debtMin ? this.criteria.debtMin : environment.emptyForExport ,
            'Debt Max': this.criteria.debtMax ? this.criteria.debtMax : environment.emptyForExport ,
        }];
      }
}

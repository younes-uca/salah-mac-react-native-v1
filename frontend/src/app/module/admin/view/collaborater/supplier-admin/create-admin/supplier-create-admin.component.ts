import {Component, OnInit, Input} from '@angular/core';

import { AbstractCreateController } from 'src/app/zynerator/controller/AbstractCreateController';

import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierCriteria} from 'src/app/controller/criteria/SupplierCriteria.model';
@Component({
  selector: 'app-supplier-create-admin',
  templateUrl: './supplier-create-admin.component.html'
})
export class SupplierCreateAdminComponent extends AbstractCreateController<SupplierDto, SupplierCriteria, SupplierService>  implements OnInit {




    constructor( private supplierService: SupplierService ) {
        super(supplierService);
    }

    ngOnInit(): void {
}





    public setValidation(value: boolean){
    }



    public validateForm(): void{
        this.errorMessages = new Array<string>();
    }










}

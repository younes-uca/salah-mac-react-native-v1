import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierCriteria} from 'src/app/controller/criteria/SupplierCriteria.model';

@Component({
  selector: 'app-supplier-view-admin',
  templateUrl: './supplier-view-admin.component.html'
})
export class SupplierViewAdminComponent extends AbstractViewController<SupplierDto, SupplierCriteria, SupplierService> implements OnInit {


    constructor(private supplierService: SupplierService){
        super(supplierService);
    }

    ngOnInit(): void {
    }




}

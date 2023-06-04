import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {SupplierQuoteService} from 'src/app/controller/service/SupplierQuote.service';
import {SupplierQuoteDto} from 'src/app/controller/model/SupplierQuote.model';
import {SupplierQuoteCriteria} from 'src/app/controller/criteria/SupplierQuoteCriteria.model';

import {SupplierQuoteItemDto} from 'src/app/controller/model/SupplierQuoteItem.model';
import {SupplierQuoteItemService} from 'src/app/controller/service/SupplierQuoteItem.service';
import {SupplierDto} from 'src/app/controller/model/Supplier.model';
import {SupplierService} from 'src/app/controller/service/Supplier.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-supplier-quote-view-admin',
  templateUrl: './supplier-quote-view-admin.component.html'
})
export class SupplierQuoteViewAdminComponent extends AbstractViewController<SupplierQuoteDto, SupplierQuoteCriteria, SupplierQuoteService> implements OnInit {

    supplierQuoteItems = new SupplierQuoteItemDto();
    supplierQuoteItemss: Array<SupplierQuoteItemDto> = [];

    constructor(private supplierQuoteService: SupplierQuoteService, private supplierQuoteItemService: SupplierQuoteItemService, private supplierService: SupplierService, private productService: ProductService){
        super(supplierQuoteService);
    }

    ngOnInit(): void {
        this.supplierQuoteItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.supplier = new SupplierDto();
        this.supplierService.findAll().subscribe((data) => this.suppliers = data);
    }


    get product(): ProductDto {
       return this.productService.item;
    }
    set product(value: ProductDto) {
        this.productService.item = value;
    }
    get products():Array<ProductDto> {
       return this.productService.items;
    }
    set products(value: Array<ProductDto>) {
        this.productService.items = value;
    }
    get supplier(): SupplierDto {
       return this.supplierService.item;
    }
    set supplier(value: SupplierDto) {
        this.supplierService.item = value;
    }
    get suppliers():Array<SupplierDto> {
       return this.supplierService.items;
    }
    set suppliers(value: Array<SupplierDto>) {
        this.supplierService.items = value;
    }


}

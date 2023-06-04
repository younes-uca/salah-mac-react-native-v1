import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {ReturnSaleService} from 'src/app/controller/service/ReturnSale.service';
import {ReturnSaleDto} from 'src/app/controller/model/ReturnSale.model';
import {ReturnSaleCriteria} from 'src/app/controller/criteria/ReturnSaleCriteria.model';

import {SaleDto} from 'src/app/controller/model/Sale.model';
import {SaleService} from 'src/app/controller/service/Sale.service';
import {ReturnSaleItemDto} from 'src/app/controller/model/ReturnSaleItem.model';
import {ReturnSaleItemService} from 'src/app/controller/service/ReturnSaleItem.service';
import {ReturnStatusDto} from 'src/app/controller/model/ReturnStatus.model';
import {ReturnStatusService} from 'src/app/controller/service/ReturnStatus.service';
import {ProductDto} from 'src/app/controller/model/Product.model';
import {ProductService} from 'src/app/controller/service/Product.service';
@Component({
  selector: 'app-return-sale-view-admin',
  templateUrl: './return-sale-view-admin.component.html'
})
export class ReturnSaleViewAdminComponent extends AbstractViewController<ReturnSaleDto, ReturnSaleCriteria, ReturnSaleService> implements OnInit {

    returnSaleItems = new ReturnSaleItemDto();
    returnSaleItemss: Array<ReturnSaleItemDto> = [];

    constructor(private returnSaleService: ReturnSaleService, private saleService: SaleService, private returnSaleItemService: ReturnSaleItemService, private returnStatusService: ReturnStatusService, private productService: ProductService){
        super(returnSaleService);
    }

    ngOnInit(): void {
        this.returnSaleItems.product = new ProductDto();
        this.productService.findAll().subscribe((data) => this.products = data);
        this.sale = new SaleDto();
        this.saleService.findAll().subscribe((data) => this.sales = data);
        this.returnStatus = new ReturnStatusDto();
        this.returnStatusService.findAll().subscribe((data) => this.returnStatuss = data);
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
    get returnStatus(): ReturnStatusDto {
       return this.returnStatusService.item;
    }
    set returnStatus(value: ReturnStatusDto) {
        this.returnStatusService.item = value;
    }
    get returnStatuss():Array<ReturnStatusDto> {
       return this.returnStatusService.items;
    }
    set returnStatuss(value: Array<ReturnStatusDto>) {
        this.returnStatusService.items = value;
    }
    get sale(): SaleDto {
       return this.saleService.item;
    }
    set sale(value: SaleDto) {
        this.saleService.item = value;
    }
    get sales():Array<SaleDto> {
       return this.saleService.items;
    }
    set sales(value: Array<SaleDto>) {
        this.saleService.items = value;
    }


}

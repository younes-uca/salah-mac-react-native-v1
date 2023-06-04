import {Component, OnInit} from '@angular/core';
import {ProductStockService} from 'src/app/controller/service/ProductStock.service';
import {ProductStockDto} from 'src/app/controller/model/ProductStock.model';
import {ProductStockCriteria} from 'src/app/controller/criteria/ProductStockCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { ShopService } from 'src/app/controller/service/Shop.service';
import { ProductService } from 'src/app/controller/service/Product.service';

import {ShopDto} from 'src/app/controller/model/Shop.model';
import {ProductDto} from 'src/app/controller/model/Product.model';


@Component({
  selector: 'app-product-stock-list-admin',
  templateUrl: './product-stock-list-admin.component.html'
})
export class ProductStockListAdminComponent extends AbstractListController<ProductStockDto, ProductStockCriteria, ProductStockService>  implements OnInit {

    fileName = 'ProductStock';

    shops :Array<ShopDto>;
    products :Array<ProductDto>;
  
    constructor(productStockService: ProductStockService, private shopService: ShopService, private productService: ProductService) {
        super(productStockService);
        this.pdfName='ProductStock.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadShop();
      this.loadProduct();
    }

    public async loadProductStocks(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ProductStock', 'list');
        isPermistted ? this.service.findAll().subscribe(productStocks => this.items = productStocks,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'shop?.reference', header: 'Shop'},
            {field: 'product?.libelle', header: 'Product'},
            {field: 'quantity', header: 'Quantity'},
            {field: 'defectiveQuantity', header: 'Defective quantity'},
        ];
    }


    public async loadShop(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ProductStock', 'list');
        isPermistted ? this.shopService.findAllOptimized().subscribe(shops => this.shops = shops,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadProduct(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ProductStock', 'list');
        isPermistted ? this.productService.findAllOptimized().subscribe(products => this.products = products,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ProductStockDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Shop': e.shop?.reference ,
                'Product': e.product?.libelle ,
                 'Quantity': e.quantity ,
                 'Defective quantity': e.defectiveQuantity ,
            }
        });

        this.criteriaData = [{
        //'Shop': this.criteria.shop?.reference ? this.criteria.shop?.reference : environment.emptyForExport ,
        //'Product': this.criteria.product?.libelle ? this.criteria.product?.libelle : environment.emptyForExport ,
            'Quantity Min': this.criteria.quantityMin ? this.criteria.quantityMin : environment.emptyForExport ,
            'Quantity Max': this.criteria.quantityMax ? this.criteria.quantityMax : environment.emptyForExport ,
            'Defective quantity Min': this.criteria.defectiveQuantityMin ? this.criteria.defectiveQuantityMin : environment.emptyForExport ,
            'Defective quantity Max': this.criteria.defectiveQuantityMax ? this.criteria.defectiveQuantityMax : environment.emptyForExport ,
        }];
      }
}

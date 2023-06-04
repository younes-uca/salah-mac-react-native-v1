import {Component, OnInit} from '@angular/core';
import {ProductCategoryService} from 'src/app/controller/service/ProductCategory.service';
import {ProductCategoryDto} from 'src/app/controller/model/ProductCategory.model';
import {ProductCategoryCriteria} from 'src/app/controller/criteria/ProductCategoryCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-product-category-list-admin',
  templateUrl: './product-category-list-admin.component.html'
})
export class ProductCategoryListAdminComponent extends AbstractListController<ProductCategoryDto, ProductCategoryCriteria, ProductCategoryService>  implements OnInit {

    fileName = 'ProductCategory';

  
    constructor(productCategoryService: ProductCategoryService) {
        super(productCategoryService);
        this.pdfName='ProductCategory.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadProductCategorys(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('ProductCategory', 'list');
        isPermistted ? this.service.findAll().subscribe(productCategorys => this.items = productCategorys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'reference', header: 'Reference'},
            {field: 'libelle', header: 'Libelle'},
        ];
    }



	public initDuplicate(res: ProductCategoryDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Reference': e.reference ,
                 'Libelle': e.libelle ,
            }
        });

        this.criteriaData = [{
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
        }];
      }
}

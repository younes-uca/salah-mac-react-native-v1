import {Component, OnInit} from '@angular/core';
import {BrandService} from 'src/app/controller/service/Brand.service';
import {BrandDto} from 'src/app/controller/model/Brand.model';
import {BrandCriteria} from 'src/app/controller/criteria/BrandCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';




@Component({
  selector: 'app-brand-list-admin',
  templateUrl: './brand-list-admin.component.html'
})
export class BrandListAdminComponent extends AbstractListController<BrandDto, BrandCriteria, BrandService>  implements OnInit {

    fileName = 'Brand';

  
    constructor(brandService: BrandService) {
        super(brandService);
        this.pdfName='Brand.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    }

    public async loadBrands(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Brand', 'list');
        isPermistted ? this.service.findAll().subscribe(brands => this.items = brands,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'libelle', header: 'Libelle'},
            {field: 'code', header: 'Code'},
        ];
    }



	public initDuplicate(res: BrandDto) {
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Libelle': e.libelle ,
                 'Code': e.code ,
            }
        });

        this.criteriaData = [{
            'Libelle': this.criteria.libelle ? this.criteria.libelle : environment.emptyForExport ,
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
        }];
      }
}

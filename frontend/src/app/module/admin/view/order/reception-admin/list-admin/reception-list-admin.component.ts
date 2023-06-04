import {Component, OnInit} from '@angular/core';
import {ReceptionService} from 'src/app/controller/service/Reception.service';
import {ReceptionDto} from 'src/app/controller/model/Reception.model';
import {ReceptionCriteria} from 'src/app/controller/criteria/ReceptionCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { OrderService } from 'src/app/controller/service/Order.service';
import { ReceptionStatusService } from 'src/app/controller/service/ReceptionStatus.service';

import {OrderDto} from 'src/app/controller/model/Order.model';
import {ReceptionStatusDto} from 'src/app/controller/model/ReceptionStatus.model';
import {ReceptionItemDto} from 'src/app/controller/model/ReceptionItem.model';


@Component({
  selector: 'app-reception-list-admin',
  templateUrl: './reception-list-admin.component.html'
})
export class ReceptionListAdminComponent extends AbstractListController<ReceptionDto, ReceptionCriteria, ReceptionService>  implements OnInit {

    fileName = 'Reception';

    orders :Array<OrderDto>;
    receptionStatuss :Array<ReceptionStatusDto>;
  
    constructor(receptionService: ReceptionService, private orderService: OrderService, private receptionStatusService: ReceptionStatusService) {
        super(receptionService);
        this.pdfName='Reception.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadOrder();
      this.loadReceptionStatus();
    }

    public async loadReceptions(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.service.findAll().subscribe(receptions => this.items = receptions,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'order?.reference', header: 'Order'},
            {field: 'reference', header: 'Reference'},
            {field: 'receptionDate', header: 'Reception date'},
            {field: 'receptionStatus?.libelle', header: 'Reception status'},
        ];
    }


    public async loadOrder(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.orderService.findAllOptimized().subscribe(orders => this.orders = orders,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }
    public async loadReceptionStatus(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Reception', 'list');
        isPermistted ? this.receptionStatusService.findAllOptimized().subscribe(receptionStatuss => this.receptionStatuss = receptionStatuss,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: ReceptionDto) {
        if (res.receptionItems != null) {
             res.receptionItems.forEach(d => { d.reception = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                'Order': e.order?.reference ,
                 'Reference': e.reference ,
                'Reception date': this.datePipe.transform(e.receptionDate , 'dd/MM/yyyy hh:mm'),
                 'Description': e.description ,
                'Reception status': e.receptionStatus?.libelle ,
            }
        });

        this.criteriaData = [{
        //'Order': this.criteria.order?.reference ? this.criteria.order?.reference : environment.emptyForExport ,
            'Reference': this.criteria.reference ? this.criteria.reference : environment.emptyForExport ,
            'Reception date Min': this.criteria.receptionDateFrom ? this.datePipe.transform(this.criteria.receptionDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Reception date Max': this.criteria.receptionDateTo ? this.datePipe.transform(this.criteria.receptionDateTo , this.dateFormat) : environment.emptyForExport ,
            'Description': this.criteria.description ? this.criteria.description : environment.emptyForExport ,
        //'Reception status': this.criteria.receptionStatus?.libelle ? this.criteria.receptionStatus?.libelle : environment.emptyForExport ,
        }];
      }
}

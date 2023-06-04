import {Component, OnInit} from '@angular/core';
import {CompanyService} from 'src/app/controller/service/Company.service';
import {CompanyDto} from 'src/app/controller/model/Company.model';
import {CompanyCriteria} from 'src/app/controller/criteria/CompanyCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';

import { SubscriberService } from 'src/app/controller/service/Subscriber.service';

import {StoreDto} from 'src/app/controller/model/Store.model';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';


@Component({
  selector: 'app-company-list-admin',
  templateUrl: './company-list-admin.component.html'
})
export class CompanyListAdminComponent extends AbstractListController<CompanyDto, CompanyCriteria, CompanyService>  implements OnInit {

    fileName = 'Company';

     yesOrNoBlocked :any[] =[];
    subscribers :Array<SubscriberDto>;
  
    constructor(companyService: CompanyService, private subscriberService: SubscriberService) {
        super(companyService);
        this.pdfName='Company.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
      this.loadSubscriber();
    this.yesOrNoBlocked =  [{label: 'Blocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadCompanys(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Company', 'list');
        isPermistted ? this.service.findAll().subscribe(companys => this.items = companys,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'ice', header: 'Ice'},
            {field: 'headquarters', header: 'Headquarters'},
            {field: 'lastPaidYearIS', header: 'Last paid year i s'},
            {field: 'lastPaidQuarterIS', header: 'Last paid quarter i s'},
            {field: 'lastPaidYearVAT', header: 'Last paid year v a t'},
            {field: 'lastPaidQuarterVAT', header: 'Last paid quarter v a t'},
            {field: 'blocked', header: 'Blocked'},
            {field: 'subscriber?.code', header: 'Subscriber'},
        ];
    }


    public async loadSubscriber(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Company', 'list');
        isPermistted ? this.subscriberService.findAllOptimized().subscribe(subscribers => this.subscribers = subscribers,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'Erreur', detail: 'Problème de permission'});
    }

	public initDuplicate(res: CompanyDto) {
        if (res.stores != null) {
             res.stores.forEach(d => { d.company = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Ice': e.ice ,
                 'Headquarters': e.headquarters ,
                 'Last paid year i s': e.lastPaidYearIS ,
                 'Last paid quarter i s': e.lastPaidQuarterIS ,
                 'Last paid year v a t': e.lastPaidYearVAT ,
                 'Last paid quarter v a t': e.lastPaidQuarterVAT ,
                'Blocked': e.blocked? 'Vrai' : 'Faux' ,
                'Subscriber': e.subscriber?.code ,
            }
        });

        this.criteriaData = [{
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
            'Headquarters': this.criteria.headquarters ? this.criteria.headquarters : environment.emptyForExport ,
            'Last paid year i s Min': this.criteria.lastPaidYearISMin ? this.criteria.lastPaidYearISMin : environment.emptyForExport ,
            'Last paid year i s Max': this.criteria.lastPaidYearISMax ? this.criteria.lastPaidYearISMax : environment.emptyForExport ,
            'Last paid quarter i s Min': this.criteria.lastPaidQuarterISMin ? this.criteria.lastPaidQuarterISMin : environment.emptyForExport ,
            'Last paid quarter i s Max': this.criteria.lastPaidQuarterISMax ? this.criteria.lastPaidQuarterISMax : environment.emptyForExport ,
            'Last paid year v a t Min': this.criteria.lastPaidYearVATMin ? this.criteria.lastPaidYearVATMin : environment.emptyForExport ,
            'Last paid year v a t Max': this.criteria.lastPaidYearVATMax ? this.criteria.lastPaidYearVATMax : environment.emptyForExport ,
            'Last paid quarter v a t Min': this.criteria.lastPaidQuarterVATMin ? this.criteria.lastPaidQuarterVATMin : environment.emptyForExport ,
            'Last paid quarter v a t Max': this.criteria.lastPaidQuarterVATMax ? this.criteria.lastPaidQuarterVATMax : environment.emptyForExport ,
            'Blocked': this.criteria.blocked ? (this.criteria.blocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
        //'Subscriber': this.criteria.subscriber?.code ? this.criteria.subscriber?.code : environment.emptyForExport ,
        }];
      }
}

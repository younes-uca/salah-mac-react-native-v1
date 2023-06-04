import {Component, OnInit} from '@angular/core';
import {SubscriberService} from 'src/app/controller/service/Subscriber.service';
import {SubscriberDto} from 'src/app/controller/model/Subscriber.model';
import {SubscriberCriteria} from 'src/app/controller/criteria/SubscriberCriteria.model';
import {AbstractListController} from 'src/app/zynerator/controller/AbstractListController';
import { environment } from 'src/environments/environment';


import {CompanyDto} from 'src/app/controller/model/Company.model';


@Component({
  selector: 'app-subscriber-list-admin',
  templateUrl: './subscriber-list-admin.component.html'
})
export class SubscriberListAdminComponent extends AbstractListController<SubscriberDto, SubscriberCriteria, SubscriberService>  implements OnInit {

    fileName = 'Subscriber';

     yesOrNoBlocked :any[] =[];
  
    constructor(subscriberService: SubscriberService) {
        super(subscriberService);
        this.pdfName='Subscriber.pdf';
    }

    ngOnInit() : void {
      this.findPaginatedByCriteria();
      this.initExport();
      this.initCol();
    this.yesOrNoBlocked =  [{label: 'Blocked', value: null},{label: 'Oui', value: 1},{label: 'Non', value: 0}];
    }

    public async loadSubscribers(){
        await this.roleService.findAll();
        const isPermistted = await this.roleService.isPermitted('Subscriber', 'list');
        isPermistted ? this.service.findAll().subscribe(subscribers => this.items = subscribers,error=>console.log(error))
        : this.messageService.add({severity: 'error', summary: 'erreur', detail: 'problème d\'autorisation'});
    }


    public initCol() {
        this.cols = [
            {field: 'code', header: 'Code'},
            {field: 'address', header: 'Address'},
            {field: 'blocked', header: 'Blocked'},
            {field: 'creationDate', header: 'Creation date'},
            {field: 'email', header: 'Email'},
            {field: 'phone', header: 'Phone'},
            {field: 'logo', header: 'Logo'},
            {field: 'firstName', header: 'First name'},
            {field: 'lastName', header: 'Last name'},
            {field: 'companyName', header: 'Company name'},
            {field: 'backupPath', header: 'Backup path'},
            {field: 'patent', header: 'Patent'},
            {field: 'rc', header: 'Rc'},
            {field: 'cnss', header: 'Cnss'},
            {field: 'ifisc', header: 'Ifisc'},
            {field: 'ice', header: 'Ice'},
        ];
    }



	public initDuplicate(res: SubscriberDto) {
        if (res.companys != null) {
             res.companys.forEach(d => { d.subscriber = null; d.id = null; });
        }
	}

   public prepareColumnExport() : void {
        this.exportData = this.items.map(e => {
            return {
                 'Code': e.code ,
                 'Address': e.address ,
                'Blocked': e.blocked? 'Vrai' : 'Faux' ,
                'Creation date': this.datePipe.transform(e.creationDate , 'dd/MM/yyyy hh:mm'),
                 'Email': e.email ,
                 'Phone': e.phone ,
                 'Logo': e.logo ,
                 'First name': e.firstName ,
                 'Last name': e.lastName ,
                 'Company name': e.companyName ,
                 'Backup path': e.backupPath ,
                 'Patent': e.patent ,
                 'Rc': e.rc ,
                 'Cnss': e.cnss ,
                 'Ifisc': e.ifisc ,
                 'Ice': e.ice ,
            }
        });

        this.criteriaData = [{
            'Code': this.criteria.code ? this.criteria.code : environment.emptyForExport ,
            'Address': this.criteria.address ? this.criteria.address : environment.emptyForExport ,
            'Blocked': this.criteria.blocked ? (this.criteria.blocked ? environment.trueValue : environment.falseValue) : environment.emptyForExport ,
            'Creation date Min': this.criteria.creationDateFrom ? this.datePipe.transform(this.criteria.creationDateFrom , this.dateFormat) : environment.emptyForExport ,
            'Creation date Max': this.criteria.creationDateTo ? this.datePipe.transform(this.criteria.creationDateTo , this.dateFormat) : environment.emptyForExport ,
            'Email': this.criteria.email ? this.criteria.email : environment.emptyForExport ,
            'Phone': this.criteria.phone ? this.criteria.phone : environment.emptyForExport ,
            'Logo': this.criteria.logo ? this.criteria.logo : environment.emptyForExport ,
            'First name': this.criteria.firstName ? this.criteria.firstName : environment.emptyForExport ,
            'Last name': this.criteria.lastName ? this.criteria.lastName : environment.emptyForExport ,
            'Company name': this.criteria.companyName ? this.criteria.companyName : environment.emptyForExport ,
            'Backup path': this.criteria.backupPath ? this.criteria.backupPath : environment.emptyForExport ,
            'Patent': this.criteria.patent ? this.criteria.patent : environment.emptyForExport ,
            'Rc': this.criteria.rc ? this.criteria.rc : environment.emptyForExport ,
            'Cnss': this.criteria.cnss ? this.criteria.cnss : environment.emptyForExport ,
            'Ifisc': this.criteria.ifisc ? this.criteria.ifisc : environment.emptyForExport ,
            'Ice': this.criteria.ice ? this.criteria.ice : environment.emptyForExport ,
        }];
      }
}

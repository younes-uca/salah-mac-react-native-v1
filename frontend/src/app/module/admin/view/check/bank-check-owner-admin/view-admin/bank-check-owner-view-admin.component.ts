import {Component, OnInit} from '@angular/core';


import {AbstractViewController} from 'src/app/zynerator/controller/AbstractViewController';
import { environment } from 'src/environments/environment';

import {BankCheckOwnerService} from 'src/app/controller/service/BankCheckOwner.service';
import {BankCheckOwnerDto} from 'src/app/controller/model/BankCheckOwner.model';
import {BankCheckOwnerCriteria} from 'src/app/controller/criteria/BankCheckOwnerCriteria.model';

import {CheckOwnerDto} from 'src/app/controller/model/CheckOwner.model';
import {CheckOwnerService} from 'src/app/controller/service/CheckOwner.service';
import {BankDto} from 'src/app/controller/model/Bank.model';
import {BankService} from 'src/app/controller/service/Bank.service';
@Component({
  selector: 'app-bank-check-owner-view-admin',
  templateUrl: './bank-check-owner-view-admin.component.html'
})
export class BankCheckOwnerViewAdminComponent extends AbstractViewController<BankCheckOwnerDto, BankCheckOwnerCriteria, BankCheckOwnerService> implements OnInit {


    constructor(private bankCheckOwnerService: BankCheckOwnerService, private checkOwnerService: CheckOwnerService, private bankService: BankService){
        super(bankCheckOwnerService);
    }

    ngOnInit(): void {
        this.checkOwner = new CheckOwnerDto();
        this.checkOwnerService.findAll().subscribe((data) => this.checkOwners = data);
        this.bank = new BankDto();
        this.bankService.findAll().subscribe((data) => this.banks = data);
    }


    get checkOwner(): CheckOwnerDto {
       return this.checkOwnerService.item;
    }
    set checkOwner(value: CheckOwnerDto) {
        this.checkOwnerService.item = value;
    }
    get checkOwners():Array<CheckOwnerDto> {
       return this.checkOwnerService.items;
    }
    set checkOwners(value: Array<CheckOwnerDto>) {
        this.checkOwnerService.items = value;
    }
    get bank(): BankDto {
       return this.bankService.item;
    }
    set bank(value: BankDto) {
        this.bankService.item = value;
    }
    get banks():Array<BankDto> {
       return this.bankService.items;
    }
    set banks(value: Array<BankDto>) {
        this.bankService.items = value;
    }


}
